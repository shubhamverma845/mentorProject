package com.example.project.demo.Sirion.SearchMicroservice.Controller;

import com.example.project.demo.Sirion.SearchMicroservice.Model.MentorSkill;
import com.example.project.demo.Sirion.SearchMicroservice.Service.MentorService;
import com.example.project.demo.Sirion.SearchMicroservice.Service.MentorSkillService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/mentorSkill")
public class MentorSkillController {

    @Autowired
    MentorSkillService mentorSkillService;

    @Autowired
    MentorService mentorService;

    @GetMapping()
    public List<MentorSkill> getAllSkills(){
        return mentorSkillService.getAllMentorSkill();
    }

    @PostMapping(value = "/createMentorSkill", headers = "Accept=application/json")
    public ResponseEntity<Void> createMentorSkill(@RequestBody MentorSkill mentorSkill) {
        mentorSkillService.createMentorSkill(mentorSkill);
        HttpHeaders headers = new HttpHeaders();
        return new ResponseEntity<>(headers, HttpStatus.CREATED);
    }

    @PutMapping(value = "/updateMentorSkill", headers = "Accept=application/json")
    public ResponseEntity<String> updateMentorSkill(@RequestBody MentorSkill currentMentorSkill){
        MentorSkill mentorSkill = mentorSkillService.findById(currentMentorSkill.getMentorId());

        if(mentorSkill == null){
            return new ResponseEntity<>("Mentor not Found",HttpStatus.NOT_FOUND);
        }

        mentorSkillService.updateMentorSkill(currentMentorSkill);
        return new ResponseEntity<>("MentorSkill is updated",HttpStatus.OK);
    }

//    @PutMapping(value = "/addMentorSkill/{mentorId}/{skillId}", headers = "Accept=application/json")
//    public ResponseEntity<String> addMentorSkill(@PathVariable("mentorId") long mentorId, @PathVariable("skillId") long skillId){
//
//    }
}