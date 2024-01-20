package com.externship.appointment.Doctor_storage;

import org.springframework.data.jpa.repository.JpaRepository;

public interface DoctorRepository extends JpaRepository<Doctor, String> {
    // You can add custom queries or methods here if needed
	 Doctor findByEmail(String email);
}
