package com.example.project.demo.Sirion.SearchMicroservice.Service;

import com.example.project.demo.Sirion.SearchMicroservice.Model.Mentor;

import java.util.List;

public interface MentorService {
    void createMentor(Mentor mentor);
    void deleteMentorById(long id);
    Mentor findById(long id);
    Mentor updateMentor(Mentor mentor);
    List<Mentor> getAllMentor();
}
