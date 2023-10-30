package com.example.hrdepartmentbase.Controllers;


import com.example.hrdepartmentbase.Models.Worker;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@Controller
public class MainPagesController {

    @GetMapping("/")
    public String mainPages(Model model){

        Worker worker = new Worker();

        worker.setName("Николай");

        model.addAttribute("nameWorker", worker.getName());

        return "mainPages";
    }


}
