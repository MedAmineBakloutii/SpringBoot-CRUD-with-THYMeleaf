package com.crud.crud.repository;

import com.crud.crud.entity.Staff;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StaffRepo extends JpaRepository<Staff, Integer> {

}