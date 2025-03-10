package com.caregiver.Caregiver.Tracker.System.controller;

import com.caregiver.Caregiver.Tracker.System.model.Caregiver;
import com.caregiver.Caregiver.Tracker.System.model.Patient;
import com.caregiver.Caregiver.Tracker.System.service.CaregiverService;
import com.caregiver.Caregiver.Tracker.System.service.PatientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.ui.Model;

import java.util.List;

@Controller
@RequestMapping("/caregivers")
public class CaregiverController {

    @Autowired
    private CaregiverService caregiverService;

    @Autowired
    private PatientService patientService;

    @GetMapping
    public String getAllCaregivers(Model model){
        List<Caregiver> caregivers = caregiverService.getAllCaregivers();
        model.addAttribute("caregivers", caregivers);
        return "caregiver-list";
    }

    @GetMapping("/new")
    public String showCaregiverCreationForm(Model model){
        Caregiver caregiver = new Caregiver();
        List<Patient> patients = patientService.getAllPatients();
        model.addAttribute("caregiver", caregiver);
        model.addAttribute("patients", patients);
        return "caregiver-form";
    }

    @PostMapping("/save")
    public String saveCaregiver(@ModelAttribute("caregiver") Caregiver caregiver){
        caregiverService.saveCaregiver(caregiver);
        return "redirect:/caregivers";
    }

    @GetMapping("/edit/{id}")
    public String showCaregiverUpdateForm(@PathVariable int id, Model model){
        Caregiver caregiver = caregiverService.getCaregiverById(id);
        List<Patient> patients = patientService.getAllPatients();
        model.addAttribute("caregiver", caregiver);
        model.addAttribute("patients", patients);
        return "caregiver-form";
    }

    @GetMapping("/delete/{id}")
    public String deleteCaregiver(@PathVariable int id){
        caregiverService.deleteCaregiver(id);
        return "redirect:/caregivers";
    }
}
