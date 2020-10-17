package com.example.project.demo.Sirion.SearchMicroservice.Service;

import com.example.project.demo.Sirion.SearchMicroservice.Model.MentorSkill;
import com.example.project.demo.Sirion.SearchMicroservice.Repository.MentorSkillReopsitory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MentorSkillServiceImp implements MentorSkillService {

    @Autowired
    MentorSkillReopsitory mentorSkillReopsitory;

    @Override
    public void createMentorSkill(MentorSkill mentorSkill) {
        mentorSkillReopsitory.save(mentorSkill);
    }

    @Override
    public void deleteMentorSkillById(long id) {
        mentorSkillReopsitory.deleteById(id);
    }

    @Override
    public MentorSkill updateMentorSkill(MentorSkill mentorSkill) {
        return mentorSkillReopsitory.save(mentorSkill);
    }

    @Override
    public MentorSkill findById(long id) {
        return mentorSkillReopsitory.findById(id).get();
    }

    @Override
    public List<MentorSkill> getAllMentorSkill() {
        return mentorSkillReopsitory.findAll();
    }
}
