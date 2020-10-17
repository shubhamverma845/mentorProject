package com.example.project.demo.Sirion.SearchMicroservice.Controller;


import com.example.project.demo.Sirion.SearchMicroservice.Model.Mentor;
import com.example.project.demo.Sirion.SearchMicroservice.Service.MentorService;
import com.example.project.demo.Sirion.TechnologyMicroservice.Model.Technology;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/mentor")
public class MentorController {

    @Autowired
    MentorService mentorService;

    @GetMapping(value = "/getAllMentors", headers = "Accept=application/json")
    public List<Mentor> getAllMentor(){
        return mentorService.getAllMentor();
    }

    @GetMapping(value = "/{id}", headers = "Accept=application/json")
    public ResponseEntity<Mentor> getMentorById(@PathVariable long id){
        Mentor mentor = mentorService.findById(id);

        if(mentor == null){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        return new ResponseEntity<>(mentor, HttpStatus.OK);
    }

    @PostMapping(value = "/createMentor", headers = "Accept=application/json")
    public ResponseEntity<Void> createMentor(@RequestBody Mentor mentor){
        mentorService.createMentor(mentor);
        HttpHeaders headers = new HttpHeaders();
        return new ResponseEntity<Void>(headers, HttpStatus.CREATED);
    }

    @DeleteMapping(value = "/deleteMentor/{id}", headers = "Accept=application/json")
    public ResponseEntity<Mentor> deleteMentor(@PathVariable("id") long id){
        Mentor mentor = mentorService.findById(id);
        if (mentor == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        mentorService.deleteMentorById(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @PutMapping(value = "/updateMentor", headers = "Accept=application/json")
    public ResponseEntity<String> updateMentor(@RequestBody Mentor currentMentor){
        Mentor mentor = mentorService.findById(currentMentor.getId());
        if (mentor == null){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        mentorService.updateMentor(currentMentor);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
