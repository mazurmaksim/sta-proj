package net.students.accounting.controller;

import net.students.accounting.repository.storage.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.ui.Model;

@Controller
public class PublicDataController {

    @Autowired
    StudentRepository studentRepository;

    @RequestMapping(value = "/students", method = RequestMethod.GET)
    public String getAllCustomers(Model model){
        model.addAttribute("allStudents",studentRepository.findAll(new Sort("id")));
        return "students";
    }


}
