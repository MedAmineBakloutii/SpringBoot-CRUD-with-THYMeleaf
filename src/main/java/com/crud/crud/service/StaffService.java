package com.crud.crud.service;

import com.crud.crud.entity.Staff;

import java.util.List;

public interface StaffService { void save(Staff staff);
    List<Staff> getAll(); Staff getById(Integer id); void delete(Staff staff);
}
