package com.crud.crud.service;

import java.util.List;

import com.crud.crud.entity.Staff;
import com.crud.crud.repository.StaffRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
@Service
public class StaffServiceImpl implements StaffService { @Autowired
StaffRepo staffRepo;
    @Override
    public void save(Staff staff) {
        if (staff.getId() == null) { staffRepo.save(staff);
        } else {
            Staff staffUpdate =
                    staffRepo.findById(staff.getId()).get(); staffUpdate.setName(staff.getName()); staffUpdate.setDesgn(staff.getDesgn());
            staffUpdate.setEmailId(staff.getEmailId()); staffRepo.save(staffUpdate);
        }}
    @Override
    public List<Staff> getAll() { return staffRepo.findAll();
    }
    @Override
    public Staff getById(Integer id) {
        return staffRepo.findById(id).get();
    }
    @Override
    public void delete(Staff staff) { staffRepo.delete(staff);
    }
}
