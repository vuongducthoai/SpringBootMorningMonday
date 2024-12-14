package webapp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import webapp.model.ClassRepository;
import webapp.model.Student;
import webapp.model.StudentRepository;

@Controller
public class StudentController {
    @Autowired
    StudentRepository studentRepository;

    @Autowired
    ClassRepository classRepository;

    @GetMapping("/student")
    public String index(Model model) {
        model.addAttribute("list", studentRepository.findAll());
        return "student/index";
    }

    @GetMapping("/student/add")
    public String add(Model model) {
        model.addAttribute("student", new Student());
        model.addAttribute("classes", classRepository.findAll());
        return "student/add";
    }

    @PostMapping("/student/add")
    public String addStudent(@ModelAttribute("student") Student student) {
        studentRepository.save(student);
        return "redirect:/student";
    }

    @GetMapping("/student/edit/{id}")
    public String edit(@PathVariable("id") Long id, Model model) {
        model.addAttribute("obj", studentRepository.findById(id).orElseThrow());
        model.addAttribute("classes", classRepository.findAll());
        return "student/edit";
    }

    @PostMapping("/student/edit/{id}")
    public String edit(Student obj, @PathVariable("id") int id) {
        obj.setId(id);
        studentRepository.save(obj);
        return "redirect:/student";
    }

    @GetMapping("/student/delete/{id}")
    public String delete(@PathVariable("id") Long id) {
        studentRepository.deleteById(id);
        return "redirect:/student";
    }
}
