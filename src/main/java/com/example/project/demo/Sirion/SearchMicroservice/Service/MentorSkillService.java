package com.example.project.demo.Sirion.SearchMicroservice.Service;


import com.example.project.demo.Sirion.SearchMicroservice.Model.Mentor;
import com.example.project.demo.Sirion.SearchMicroservice.Model.MentorSkill;
import org.springframework.stereotype.Service;

import java.util.List;

public interface MentorSkillService {
    void createMentorSkill(MentorSkill mentorSkill);
    void deleteMentorSkillById(long id);
    MentorSkill updateMentorSkill(MentorSkill mentorSkill);
    MentorSkill findById(long id);
    List<MentorSkill> getAllMentorSkill();
}
