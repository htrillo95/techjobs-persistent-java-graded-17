package org.launchcode.techjobs.persistent.controllers;

import jakarta.validation.Valid;
import org.launchcode.techjobs.persistent.models.Employer;
import org.launchcode.techjobs.persistent.models.data.EmployerRepository; //IMPORTED REPO
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@Controller
@RequestMapping("employers")
public class EmployerController {

    //TASK 2
    //IMPORT EMPLOYER REPO
    //ADD PRIVATE FIELD
    @Autowired //DEPENDENCY
    private EmployerRepository employerRepository;


    //ADD INDEX METHOD
    //RESPONDS @ /EMPLOYERS
    @GetMapping ("/")
    public String index(Model model) {
        Iterable<Employer> employers = employerRepository.findAll();
        model.addAttribute("employers", employers);
        return "employers/index"; //TEMPLATE USE
    }


    @GetMapping("add")
    public String displayAddEmployerForm(Model model) {
        model.addAttribute(new Employer());
        return "employers/add";
    }


    //TASK 2 CONTINUED
    @PostMapping("add")
    public String processAddEmployerForm(@ModelAttribute @Valid Employer newEmployer,
                                    Errors errors, Model model) {

        if (errors.hasErrors()) {
            return "employers/add";
        }

        //ADDED, SAVE EMPLOYER OBJ USING EMPLOYER-REPO
        employerRepository.save(newEmployer);
        return "redirect:";
    }



    //TASK 2 FINAL
    @GetMapping("view/{employerId}") //RENDERS PAGE TO VIEW EMPLOYER OBJ
    public String displayViewEmployer(Model model, @PathVariable int employerId) {

        //REPLACED optEmployer w employerRepo.findById
        //****Optional <Employer> optEmployer = null;****

        Optional<Employer> optEmployer = employerRepository.findById(employerId);

        if (optEmployer.isPresent()) {
            Employer employer = (Employer) optEmployer.get();
            model.addAttribute("employer", employer);
            return "employers/view";
        } else {
            return "redirect:../";
        }

    }
}
