package com.project.Doctor.dao;

import com.project.Doctor.model.Doctor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface IDoctorRepository extends JpaRepository<Doctor, Integer> {
    Doctor findByid(Integer id);
    @Modifying
    @Query(value = "DELETE FROM Doctor d WHERE d.name = :name")
    void  deleteByName(@Param("name") String name);
    Doctor findByName(String name);

}
