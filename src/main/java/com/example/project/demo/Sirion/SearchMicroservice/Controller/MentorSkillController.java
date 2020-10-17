package com.example.project.demo.Sirion.SearchMicroservice.Controller;


import com.example.project.demo.Sirion.SearchMicroservice.Model.Mentor;
import com.example.project.demo.Sirion.SearchMicroservice.Model.MentorSkill;
import com.example.project.demo.Sirion.SearchMicroservice.Service.MentorService;
import com.example.project.demo.Sirion.SearchMicroservice.Service.MentorSkillService;
import com.example.project.demo.Sirion.TechnologyMicroservice.Model.Technology;
import com.example.project.demo.Sirion.TechnologyMicroservice.Service.TechnologyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.persistence.GeneratedValue;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.LongStream;

@RestController
@RequestMapping("/mentorSkill")
public class MentorSkillController {

    @Autowired
    MentorSkillService mentorSkillService;

    @Autowired
    TechnologyService technologyService;

    @Autowired
    MentorService mentorService;

    @GetMapping()
    public List<MentorSkill> getAllSkills(){
        return mentorSkillService.getAllMentorSkill();
    }

    @PostMapping(value = "/createMentorSkill", headers = "Accept=application/json")
    public ResponseEntity<Void> createMentorSkill(@RequestBody MentorSkill mentorSkill) {
        mentorSkillService.createMentorSkill(mentorSkill);
//        System.out.println("fafafddddddddddddddddddd");
        HttpHeaders headers = new HttpHeaders();
        return new ResponseEntity<>(headers, HttpStatus.CREATED);
    }

    @PutMapping(value = "/addMentorSkill/{id}/{skillId}", headers = "Accept=application/json")
    public ResponseEntity<String> updateMentorSkill(@PathVariable("id") long id,
                                                    @PathVariable("skillId") long skillId) {
        Technology technology = technologyService.findById(id);
        if (technology == null) {
            return new ResponseEntity<>("No such Skill", HttpStatus.NOT_FOUND);
        }

        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PutMapping(value = "/deleteMentorSkill/{id}/{skillId}", headers = "Accept=application/json")
    public ResponseEntity<MentorSkill> deleteMentorSkill(@PathVariable("id") long id, @PathVariable("skillId") long skillId) {

        MentorSkill mentorSkill = mentorSkillService.findById(id);
        if (mentorSkill == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        long[] oldSkills = mentorSkill.getSkillId();

        long[] newSkills = new long[oldSkills.length + 1];

        mentorSkill.setSkillId(newSkills);

        mentorSkillService.updateMentorSkill(mentorSkill);
        return new ResponseEntity<>(mentorSkill, HttpStatus.OK);
    }

    @GetMapping(value = "/searchMentor", headers = "Accept=application/json")
    public List<String> getMentors(@RequestParam String skill){

        List<Technology> technologyList = technologyService.findByName(skill);

        List<String> list = new ArrayList<>();

        List<MentorSkill> mentorSkillsList = mentorSkillService.getAllMentorSkill();

        for (Technology tech : technologyList){
            long skillId = tech.getId();

            for (MentorSkill mentorSkill: mentorSkillsList){
                long[] skillIdArr = mentorSkill.getSkillId();

                boolean contains = LongStream.of(skillIdArr).anyMatch(x -> x == skillId);

                if(contains){
                    list.add(mentorService.findById(mentorSkill.getMentorId()).getUsername());
                }
            }
        }
        return list;
    }
}
