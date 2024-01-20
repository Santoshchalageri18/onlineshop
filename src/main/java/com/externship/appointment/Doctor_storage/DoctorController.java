package com.externship.appointment.Doctor_storage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
@RestController
@Controller
public class DoctorController {

    @Autowired
    private DoctorService doctorService;

    private final DoctorRepository doctorRepository;

    @Autowired
    public DoctorController(DoctorRepository doctorRepository) {
        this.doctorRepository = doctorRepository;
    }
    
    @GetMapping("/doctor/register")
    public String showDoctorRegistrationForm(Model model) {
        // Add an empty Doctor object to the model for Thymeleaf to bind with
        model.addAttribute("doctor", new Doctor());
        return "doctor_registration_form"; // Thymeleaf template name
    }

    @PostMapping("/doctor/register")
    public String registerDoctor(@ModelAttribute Doctor doctor) {
        // Save the doctor to the database using the service
        doctorService.saveDoctor(doctor);
        // Redirect to a confirmation page or any other appropriate page
        return "redirect:/doctor/registration-success";
    }

    @GetMapping("/doctor/registration-success")
    public String showRegistrationSuccess() {
        return "registration_success"; // Thymeleaf template name
    }
    @PostMapping("/updateDoctorStatus")
    public ResponseEntity<String> updateDoctorStatus(@RequestParam String email, @RequestParam String status) {
        // Find the doctor by email
    	  Doctor doctor = doctorRepository.findByEmail(email);

        // Ensure the doctor is not null before performing operations
        if (doctor != null) {
            // Update the status
            doctor.setStatus(status);

            // Save the updated doctor
            doctorRepository.save(doctor);

            return ResponseEntity.ok("Status updated successfully");
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Doctor not found");
        }
    }
    
    @PostMapping("/doclog")
    public String registerDoctor(@ModelAttribute("doctor") Doctor doctor, Model model) {
        // Set the default status when registering a new doctor
    	
        doctor.setStatus("Active"); // You can set any default status

        // Save the doctor to the database
        doctorService.saveDoctor(doctor);

        // Other registration logic...

        return "redirect:/login"; // Redirect to login page after registration
    }

    // Other controller methods...
}

