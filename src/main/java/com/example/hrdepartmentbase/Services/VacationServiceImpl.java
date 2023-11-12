package com.example.hrdepartmentbase.Services;

import com.example.hrdepartmentbase.Models.MedicalBook;
import com.example.hrdepartmentbase.Models.Vacation;
import com.example.hrdepartmentbase.Repository.VacationRepository;
import org.springframework.expression.ExpressionException;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class VacationServiceImpl implements VacationService{

    public VacationServiceImpl(VacationRepository vacationRepository) {
        this.vacationRepository = vacationRepository;
    }

    VacationRepository vacationRepository;
    @Override
    public void addVacation(Vacation vacation) {
        vacationRepository.save(vacation);
    }

    @Override
    public Optional<Vacation> getVacationById(Long id){
        return vacationRepository.findById(id);
    }

    @Override
    public void deleteVacation(Long id){
        vacationRepository.deleteById(id);
    }

    @Override
    public void updateVacation(Long id, Vacation vacation) {
        Vacation vacationUpdate = vacationRepository.findById(id).orElseThrow(() -> new ExpressionException("Post not exist with id: " + id));

        vacationUpdate.setTypeVacation(vacation.getTypeVacation());
        vacationUpdate.setDateEndVacation(vacation.getDateEndVacation());
        vacationUpdate.setDateStartVacation(vacation.getDateStartVacation());

        vacationRepository.save(vacationUpdate);
    }
}
