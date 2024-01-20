package com.externship.appointment.Doctor_storage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DoctorService {
    
    @Autowired
    private DoctorRepository doctorRepository;

    public void saveDoctor(Doctor doctor) {
        doctorRepository.save(doctor);
    }

    // Other methods if needed
}
