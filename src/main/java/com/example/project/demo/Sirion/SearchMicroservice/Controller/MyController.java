package com.example.project.demo.Sirion.SearchMicroservice.Controller;

import com.example.project.demo.Sirion.SearchMicroservice.Model.Mentor;
import com.example.project.demo.Sirion.SearchMicroservice.Model.MentorSkill;
import com.example.project.demo.Sirion.SearchMicroservice.Service.MentorService;
import com.example.project.demo.Sirion.SearchMicroservice.Service.MentorSkillService;
import com.example.project.demo.Sirion.TechnologyMicroservice.Model.Technology;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.LongStream;


class MentorDetails{
    String name;
    float rating;
    long yoe;
    List<String> skill;

    public MentorDetails(String name, float rating, long yoe, List<String> skill) {
        this.name = name;
        this.rating = rating;
        this.yoe = yoe;
        this.skill = skill;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public float getRating() {
        return rating;
    }

    public void setRating(float rating) {
        this.rating = rating;
    }

    public long getYoe() {
        return yoe;
    }

    public void setYoe(long yoe) {
        this.yoe = yoe;
    }

    public List<String> getSkill() {
        return skill;
    }

    public void setSkill(List<String> skill) {
        this.skill = skill;
    }
}

@RestController
@RequestMapping
public class MyController {

    @Autowired
    MentorSkillService mentorSkillService;

    @Autowired
    MentorService mentorService;

    //getSearchResults
    @GetMapping(value = "/searchMentor", headers = "Accept=application/json")
    public List<String> searchMentorBySkill(@RequestParam String skill){

        RestTemplate restTemplate = new RestTemplate();
        final String baseUrl = "http://localhost:8969/technology/searchByName";

        URI uri = UriComponentsBuilder.fromHttpUrl(baseUrl).queryParam("name",skill).build().toUri();

        System.out.println(uri.getPath());

        ResponseEntity<Technology[]> result = restTemplate.getForEntity(uri,Technology[].class);

        List<String> list = new ArrayList<>();
        List<MentorSkill> mentorSkillsList = mentorSkillService.getAllMentorSkill();

        if (result.getBody()!=null){
            for (Technology tech: result.getBody()){
                long skillId = tech.getId();

                for (MentorSkill mentorSkill: mentorSkillsList){

                    long[] skillIdAddr = mentorSkill.getSkillId();
                    boolean contains = LongStream.of(skillIdAddr).anyMatch(x -> x == skillId);

                    if(contains){
                        list.add(mentorService.findById(mentorSkill.getMentorId()).getUsername());
                    }
                }
            }
        } else {
            list.add("No Mentors found for::" + skill);

        }

        return list;
    }


    //getMentorDetails
    @GetMapping(value = "/getMentorDetails/{mentorId}", headers = "Accept=application/json")
    public ResponseEntity<MentorDetails> getMentorDetails(@PathVariable("mentorId") long mentorId){

        List<String> skills = new ArrayList<>();

        Mentor mentor = mentorService.findById(mentorId);

        if(mentor == null){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        MentorSkill mentorSkill = mentorSkillService.findById(mentorId);

        if (mentorSkill == null){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        long[] mentorSkills = mentorSkill.getSkillId();

        for (long skillId: mentorSkills){

            RestTemplate restTemplate = new RestTemplate();
            final String baseUrl = "http://localhost:8969/technology/getSkillName";

            URI uri = UriComponentsBuilder.fromHttpUrl(baseUrl).queryParam("skillId", skillId).build().toUri();

            ResponseEntity<String> result = restTemplate.getForEntity(uri,String.class);

            skills.add(result.getBody());
        }

        return new ResponseEntity<>(new MentorDetails(mentor.getUsername(), mentorSkill.getRating(), mentor.getYearsOfExperience(), skills), HttpStatus.OK);
    }
}
