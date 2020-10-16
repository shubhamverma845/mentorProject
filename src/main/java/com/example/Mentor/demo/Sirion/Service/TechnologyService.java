package com.example.Mentor.demo.Sirion.Service;

import com.example.Mentor.demo.Sirion.Model.Technology;

import java.util.List;

public interface TechnologyService {
    void createTechnology(Technology technology);
    Technology findById(long id);
    List<Technology> getAllTechnology();
    void deleteTechnologyById(long id);
    Technology updateTechnology(Technology technology);
    List<Technology> getTechnologies(Integer pageNo, Integer pageSize, String sortBy, String ord);
}
