package com.example.project.demo.Sirion.TechnologyMicroservice.Repository;

import com.example.project.demo.Sirion.TechnologyMicroservice.Model.Technology;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TechnologyRepository extends JpaRepository<Technology, Long>{
    List<Technology> findByTechName(String techName);
}
