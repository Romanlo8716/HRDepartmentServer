package com.example.hrdepartmentbase.Controllers;

import com.example.hrdepartmentbase.Models.LaborBook;
import com.example.hrdepartmentbase.Services.LaborBookService;
import com.example.hrdepartmentbase.Services.PostService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@CrossOrigin(origins = "*")
public class LaborBookController {

    private final static Logger logger = LoggerFactory.getLogger(WorkerController.class);
    private LaborBookService laborBookService;

    public LaborBookController(LaborBookService laborBookService) {
        this.laborBookService = laborBookService;
    }

    @PostMapping(value = "addLaborBook")
    void addLaborBook(@RequestBody LaborBook laborBook){
        laborBookService.addLaborBook(laborBook);
    }

    @GetMapping(value = "getLaborBookById/{id}")
    Optional<LaborBook> getLaborBookById(@PathVariable Long id){
        return laborBookService.getLaborBookById(id);
    }

    @DeleteMapping(value = "deleteLaborBook/{id}")
    void deleteLaborBook(@PathVariable Long id){
        laborBookService.deleteLaborBook(id);
    }

    @PutMapping(value = "updateLaborBook/{id}")
    void updateLaborBook(@PathVariable Long id, @RequestBody LaborBook laborBook){
        laborBookService.updateLaborBook(id, laborBook);
    }
}
