package com.caregiver.Caregiver.Tracker.System.controller;

import com.caregiver.Caregiver.Tracker.System.model.Caregiver;
import com.caregiver.Caregiver.Tracker.System.model.Patient;
import com.caregiver.Caregiver.Tracker.System.model.Preference;
import com.caregiver.Caregiver.Tracker.System.service.CaregiverService;
import com.caregiver.Caregiver.Tracker.System.service.PatientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import java.security.Principal;

import java.util.List;
import java.util.Optional;
import java.util.Set;

@Controller
@RequestMapping("/patients")
public class PatientController {

    @Autowired
    private PatientService patientService;

    @Autowired
    private CaregiverService caregiverService;

    @GetMapping
    public String getAllPatients(Model model){
        List<Patient> patients = patientService.getAllPatients();
        model.addAttribute("patients", patients);
        return "patient-list";
    }

    @GetMapping("/new")
    public String showPatientCreationForm(Model model){
         Patient patient = new Patient();
         List<Caregiver> caregivers = caregiverService.getAllCaregivers();
         model.addAttribute("patient", patient);
         model.addAttribute("caregivers", caregivers);
         return "patient-form";
    }

    @PostMapping("/save")
    public String savePatient(@ModelAttribute("patient") Patient patient){
        patientService.savePatient(patient);
        return "redirect:/patients";
    }

    @GetMapping("/edit/{id}")
    public String showPatientEditFprm(@PathVariable int id, Model model){
        Patient patient = patientService.getPatientById(id);
        List<Caregiver> caregivers = caregiverService.getAllCaregivers();
        model.addAttribute("patient", patient);
        model.addAttribute("caregivers", caregivers);
        return "patient-form";

    }

    @GetMapping("/delete/{id}")
    public String deletePatient(@PathVariable int id){
        patientService.deletePatient(id);
        return "redirect:/patients";
    }

    @GetMapping("/profile")
    public String patientProfile(Principal principal, Model model){
        Optional<Patient> patient = patientService.findByEmail(principal.getName());

        if(patient.isPresent()){
            Set<Caregiver> caregivers = patientService.getAllCaregiver(patient.get());
            Preference preference = patient.get().getPreference();
            model.addAttribute("caregivers", caregivers);
            model.addAttribute("patient", patient.get());
            model.addAttribute("preference", preference);
            return "patient-profile";
        }
        return "redirect:/";
    }
}
