package org.launchcode.techjobs.persistent.controllers;

import jakarta.validation.Valid;
import org.launchcode.techjobs.persistent.models.Employer;
import org.launchcode.techjobs.persistent.models.Job;
import org.launchcode.techjobs.persistent.models.Skill;
import org.launchcode.techjobs.persistent.models.data.JobRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;
import org.launchcode.techjobs.persistent.models.data.EmployerRepository;
import org.launchcode.techjobs.persistent.models.data.SkillRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Optional;

/**
 * Created by LaunchCode
 */
@Controller
public class HomeController {

    //TASK 3
    //ADD EmployerRepository
    //ANNOTATE @Autowired
    @Autowired
    private EmployerRepository employerRepository;

    //ADD SkillRepository
    //ANNOTATE @Autowired
    @Autowired
    private SkillRepository skillRepository;

    //ADD JobRepository
    //ANNOTATE @Autowired
    @Autowired
    private JobRepository jobRepository;


    @RequestMapping("/")
    public String index(Model model) {

        model.addAttribute("title", "MyJobs");

        return "index";
    }

    @GetMapping("add")
    public String displayAddJobForm(Model model) {
	model.addAttribute("title", "Add Job");
        model.addAttribute(new Job());
        //***ADD EMPLOYER DATA TO MODEL****
        model.addAttribute("employers", employerRepository.findAll());
        //***ADD SKILL TO MODEL****
        model.addAttribute("skills", skillRepository.findAll());
        return "add";
    }

    @PostMapping("add")
    public String processAddJobForm(@ModelAttribute @Valid Job newJob,
                                       Errors errors, Model model, @RequestParam int employerId,
                                    //TASK 4: ADD REQUEST PARAM BELOW
                                    //PASS IN ATTRIBUTE SKILLS
                                    @RequestParam List<Integer> skills) {

        //IF ERROR
        if (errors.hasErrors()) {
	    model.addAttribute("title", "Add Job");
        //ADD JOBS TO MODEL
        model.addAttribute("employers", employerRepository.findAll());
        //ADD SKILLS TO MODEL
            model.addAttribute("skills", skillRepository.findAll());
            return "add";

        }

        //RETRIEVE EMPLOYER OBJ BASED ON ID
        Optional<Employer> result = employerRepository.findById(employerId);
        if (result.isPresent()) {
            Employer employer = result.get();
            newJob.setEmployer(employer); //SET EMPLOYER ON NEWJOB OBJ

//            //GET LIST OF SKILL OBJ BASED ON ID
//            List<Skill> skillObjs = (List<Skill>) skillRepository.findAllById(skills);
//            newJob.setSkills(skillObjs);
//
//            jobRepository.save(newJob);

        }

        //GET LIST OF SKILL OBJ BASED ON ID
        List<Skill> skillObjs = (List<Skill>) skillRepository.findAllById(skills);
        newJob.setSkills(skillObjs);

        jobRepository.save(newJob);

        return "redirect:";
    }

    @GetMapping("view/{jobId}")
    public String displayViewJob(Model model, @PathVariable int jobId) { //FIND JOB BY ID
        Optional<Job> result = jobRepository.findById(jobId); //USING REPO -
                                                            // OPTIONAL IF JOB NOT FOUND
        if (result.isPresent()) {
            Job job = result.get();
            model.addAttribute("job", job); //ADD TO MODEL
            return "view"; //RETURN
        } else {
            return "redirect:/"; //HOMEPAGE IF NO RESULT
        }
    }
}
