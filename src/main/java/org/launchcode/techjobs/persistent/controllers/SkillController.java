package org.launchcode.techjobs.persistent.controllers;

//IMPORT CLASSES/PACKAGES
import jakarta.validation.Valid;
import org.launchcode.techjobs.persistent.models.Skill;
import org.launchcode.techjobs.persistent.models.data.SkillRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

//MARK SPRING MVC CONTROLLER
//MAPPED TO "skills" URL path
@Controller
@RequestMapping("skills")
public class SkillController {

    //SKILL REPO DEPENDENCY
    @Autowired
    private SkillRepository skillRepository;

    //HANDLE REQUEST @ "/skills"
    //RETURNS LIST SKILLS
    @GetMapping("/")
    public String index(Model model) {
        //RETRIEVES SKILLS
        Iterable<Skill> skills = skillRepository.findAll();

        //ADDED TO MODEL
        model.addAttribute("skills", skills);

        //RETURN "skills/index" TO TEMPLATE
        return "skills/index";
    }

    //HANDLE REQUEST "/skills/add"
    //DISPLAY FORM FOR ADDING NEW SKILL
    @GetMapping("add")
    public String displayAddSkillForm(Model model) {

        //ADD SKILL OBJ TO MODEL FOR FORM
        model.addAttribute(new Skill());

        //RETURN "skills/add" TEMP
        return "skills/add";
    }

    //PROCESS FORM ADD NEW SKILL
    @PostMapping("add")
    public String processAddSkillForm(@ModelAttribute @Valid Skill newSkill,
                                      Errors errors, Model model) {

        //IF ERRORS, RE-DISPLAY FORM
        if (errors.hasErrors()) {
            return "skills/add";
        }

        //SKILL SAVED TO DB
        skillRepository.save(newSkill);


        return "redirect:"; //IF NOT FOUND
    }

    //HANDLE REQUEST "/skills/view/{skillId}"
    //DISPLAY DETAILS OF SKILL
    @GetMapping("view/{skillId}")
    public String displayViewSkill(Model model, @PathVariable int skillId) {

        //FIND SKILL BY ID FROM DB
        Optional<Skill> optSkill = skillRepository.findById(skillId);

        //ADD TO MODEL & RETURN "skills/view" TEMP
        if (optSkill.isPresent()) {
            Skill skill = optSkill.get();
            model.addAttribute("skill", skill);
            return "skills/view";
        } else {

            return "redirect:../"; //IF NOT FOUND
        }
    }
}