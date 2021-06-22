package com.sejo.sales_management_system.staff;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class StaffService {

    private final StaffRepository staffRepository;

    @Autowired
    public StaffService(StaffRepository staffRepository) {
        this.staffRepository = staffRepository;
    }

    public List<Staff> getAllStaff() {
        return staffRepository.findAll();
    }

    public Long addNewStaff(Staff staff) {

        Optional<Staff> staffByFirstNameAndLastName = staffRepository.findStaffByFirstNameAndLastName(staff.getFirstName(), staff.getLastName());

        if(staffByFirstNameAndLastName.isPresent()){
            throw new IllegalStateException("Staff Member Already Exists");
        }

        Long userId = staffRepository.save(staff).getId();
        return userId;

    }

    public void deleteStaff(Long staffId) {
        boolean exists = staffRepository.existsById(staffId);

        if(!exists){
            throw new IllegalStateException("staff with ID " + staffId + " does not exist");
        }

        staffRepository.deleteById(staffId);
    }

    @Transactional
    public void updateStaff(Staff staff){
        Staff staffById = staffRepository.findById(staff.getId())
                .orElseThrow(() -> new IllegalStateException("Staff by id "+ staff.getId() + " odes not exist"));

        //Update First Name
        if(staff.getFirstName() != null
                && !staff.getFirstName().isEmpty()
                && !Objects.equals(staff.getFirstName(), staffById.getFirstName())){
            staffById.setFirstName(staff.getFirstName());
        }

        //Update Last Name
        if(staff.getLastName() != null
                && !staff.getLastName().isEmpty()
                && !Objects.equals(staff.getLastName(), staffById.getLastName())){
            staffById.setLastName(staff.getLastName());
        }

        //Update Date of Birth
        if(staff.getDob() != null
                && !staff.getDob().toString().isEmpty()
                && !Objects.equals(staff.getDob().toString(), staffById.getDob().toString())){
            staffById.setDob(staff.getDob());
        }

        //Update Access Level
        if(staff.getAccess() > 0 && staff.getAccess() < 4
                && staff.getAccess() != staffById.getAccess()){
            staffById.setAccess(staff.getAccess());
        }

    }

    public Staff getStaffMember(Long staffId) {

        return staffRepository.findById(staffId).orElseThrow(
                () -> new IllegalStateException("Staff with id "+staffId+" does not exist")
        );
    }
}
