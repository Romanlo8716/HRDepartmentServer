package com.example.hrdepartmentbase.Services;

import com.example.hrdepartmentbase.Controllers.WorkerController;
import com.example.hrdepartmentbase.Models.LaborBook;
import com.example.hrdepartmentbase.Models.Post;
import com.example.hrdepartmentbase.Repository.LaborBookRepository;
import com.example.hrdepartmentbase.Repository.PostRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.expression.ExpressionException;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class LaborBookServiceImpl implements LaborBookService{

    private final static Logger logger = LoggerFactory.getLogger(WorkerController.class);
    private LaborBookRepository laborBookRepository;

    public LaborBookServiceImpl(LaborBookRepository laborBookRepository) {
        this.laborBookRepository = laborBookRepository;
    }

    @Override
    public void addLaborBook(LaborBook laborBook) {
        laborBookRepository.save(laborBook);
    }

    @Override
    public Optional<LaborBook> getLaborBookById(Long id){
        return laborBookRepository.findById(id);
    }

    @Override
    public void deleteLaborBook(Long id){
        laborBookRepository.deleteById(id);
    }

    @Override
    public void updateLaborBook(Long id, LaborBook laborBook) {
        LaborBook laborBookUpdate = laborBookRepository.findById(id).orElseThrow(() -> new ExpressionException("Post not exist with id: " + id));

        laborBookUpdate.setDateRecord(laborBook.getDateRecord());
        laborBookUpdate.setNameWork(laborBook.getNameWork());
        laborBookUpdate.setNameDocument(laborBookUpdate.getNameDocument());
        laborBookUpdate.setNumberDocument(laborBookUpdate.getNumberDocument());
        laborBookUpdate.setInformationAboutWork(laborBook.getInformationAboutWork());

        laborBookRepository.save(laborBookUpdate);
    }
}
