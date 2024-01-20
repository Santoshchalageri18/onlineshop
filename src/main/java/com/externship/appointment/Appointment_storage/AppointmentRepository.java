package com.externship.appointment.Appointment_storage;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AppointmentRepository extends JpaRepository<Appointment, String>, CustomRepository, CustomTwo {
    // You can add custom query methods here if needed
}
