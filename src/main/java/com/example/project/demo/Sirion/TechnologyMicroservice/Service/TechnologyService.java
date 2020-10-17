package com.example.project.demo.Sirion.TechnologyMicroservice.Service;

import com.example.project.demo.Sirion.TechnologyMicroservice.Model.Technology;

import java.util.List;

public interface TechnologyService {
    void createTechnology(Technology technology);
    Technology findById(long id);
    List<Technology> getAllTechnology();
    void deleteTechnologyById(long id);
    Technology updateTechnology(Technology technology);
    List<Technology> getTechnologies(Integer pageNo, Integer pageSize, String sortBy, String ord);
    List<Technology> findByName(String name);
}
