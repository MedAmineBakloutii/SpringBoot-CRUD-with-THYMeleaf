package com.crud.crud.controller;

import com.crud.crud.entity.Staff;
import com.crud.crud.service.StaffService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class StaffController {

    @Autowired
    StaffService staffService;

    @GetMapping("/")
    public String getAllStaffs(Model model) {
        List<Staff> staffList = staffService.getAll();
        if (staffList.size() > 0) {
            model.addAttribute("staffs", staffList);
        }
        return "list-staffs";
    }

    @GetMapping("/add-staff")
    public String addStaff(Model model) {
        model.addAttribute("staff", new Staff());
        return "add-edit-staff";
    }

    @PostMapping("/save-staff")
    public String saveStaff(@ModelAttribute("staff") Staff staff) {
        staffService.save(staff);
        return "redirect:/";
    }

    @GetMapping("/staff-update/{id}")
    public String getStaff(Model model, @PathVariable("id") Integer id) {
        Staff staff = staffService.getById(id);
        model.addAttribute("staff", staff);
        return "add-edit-staff";
    }

    @GetMapping("/staff-delete/{id}")
    public String deleteStaff(@PathVariable("id") Integer id) {
        Staff deleteStaff = staffService.getById(id);
        staffService.delete(deleteStaff);
        return "redirect:/";
    }
}
