package com.pms.controller;

import com.pms.entity.Student;
import com.pms.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class StudentController {

    @Autowired
    private StudentService studentService;

    @GetMapping("/students")
    public String getStudents(Model model) {

        model.addAttribute("students",
                studentService.getAllStudents());

        return "students";
    }

    @GetMapping("/register")
    public String registerPage(Model model) {

        model.addAttribute("student",
                new Student());

        return "register";
    }

    @PostMapping("/register")
    public String saveStudent(
            @ModelAttribute Student student) {

        studentService.saveStudent(student);

        return "redirect:/login";
    }
}
