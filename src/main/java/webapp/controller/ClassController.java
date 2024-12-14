package webapp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import webapp.model.ClassRepository;
@Controller
public class ClassController {
    @Autowired
    ClassRepository classRepository;
    @GetMapping("/class")
    public String index(Model model){
        model.addAttribute("list", classRepository.findAll());
        return "class/index";
    }

    /*ADD*/
    @GetMapping("/class/add")
    public String add(){
        return "class/add";
    }

    @PostMapping("/class/add")
    public String add(webapp.model.Class obj){
        classRepository.save(obj);
        return "redirect:/class";
    }

    /*EDIT*/
    @GetMapping("/class/edit/{id}")
    public String edit(@PathVariable("id") short id, Model model){
        model.addAttribute("o", classRepository.findById(id).get());
        return "class/edit";
    }
    @PostMapping("/class/edit/{id}")
    public String edit(@PathVariable("id") short id, webapp.model.Class obj){
        obj.setId(id);
        classRepository.save(obj);
        return "redirect:/class";
    }


    /*DELETE*/
    @GetMapping("/class/delete/{id}")
    public String delete(@PathVariable("id") short id ){
        classRepository.deleteById(id);
        return "redirect:/class";
        }
    }
    
    

