package com.example.hrdepartmentbase.Services;

import com.example.hrdepartmentbase.Models.LaborBook;
import com.example.hrdepartmentbase.Models.MedicalBook;
import com.example.hrdepartmentbase.Repository.MedicalBookRepository;
import org.springframework.expression.ExpressionException;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class MedicalBookServiceImpl implements MedicalBookService{

    public MedicalBookServiceImpl(MedicalBookRepository medicalBookRepository) {
        this.medicalBookRepository = medicalBookRepository;
    }

    MedicalBookRepository medicalBookRepository;

    @Override
    public void addMedicalBook(MedicalBook medicalBook) {
        medicalBookRepository.save(medicalBook);
    }

    @Override
    public Optional<MedicalBook> getMedicalBookById(Long id){
        return medicalBookRepository.findById(id);
    }

    @Override
    public void deleteMedicalBook(Long id){
        medicalBookRepository.deleteById(id);
    }

    @Override
    public void updateMedicalBook(Long id, MedicalBook medicalBook) {
        MedicalBook medicalBookUpdate = medicalBookRepository.findById(id).orElseThrow(() -> new ExpressionException("Post not exist with id: " + id));

        medicalBookUpdate.setConclusion(medicalBook.getConclusion());
        medicalBookUpdate.setDateExam(medicalBook.getDateExam());
        medicalBookUpdate.setPlaceExam(medicalBookUpdate.getPlaceExam());

        medicalBookRepository.save(medicalBookUpdate);
    }
}
