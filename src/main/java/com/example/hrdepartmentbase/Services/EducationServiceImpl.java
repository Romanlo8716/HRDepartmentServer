package com.example.hrdepartmentbase.Services;

import com.example.hrdepartmentbase.Models.Education;
import com.example.hrdepartmentbase.Models.LaborBook;
import com.example.hrdepartmentbase.Repository.EducationRepository;
import org.springframework.expression.ExpressionException;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class EducationServiceImpl implements EducationService{

    EducationRepository educationRepository;


    public EducationServiceImpl(EducationRepository educationRepository) {
        this.educationRepository = educationRepository;
    }

    @Override
    public void addEducation(Education education) {
        educationRepository.save(education);
    }

    @Override
    public Optional<Education> getEducationById(Long id){
        return educationRepository.findById(id);
    }

    @Override
    public void deleteEducation(Long id){
        educationRepository.deleteById(id);
    }

    @Override
    public void updateEducation(Long id, Education education) {
        Education educationUpdate = educationRepository.findById(id).orElseThrow(() -> new ExpressionException("Post not exist with id: " + id));

        educationUpdate.setSpecial(education.getSpecial());
        educationUpdate.setDateYearEnd(education.getDateYearEnd());
        educationUpdate.setNumberDiploma(education.getNumberDiploma());
        educationUpdate.setSeriesDiploma(education.getSeriesDiploma());


        educationRepository.save(educationUpdate);
    }
}
