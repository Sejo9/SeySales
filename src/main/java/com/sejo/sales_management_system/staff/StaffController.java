package com.sejo.sales_management_system.staff;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "api/v1/staff")
@CrossOrigin("*")
public class StaffController {

    private final StaffService staffService;

    @Autowired
    public StaffController(StaffService staffService) {
        this.staffService = staffService;
    }


    @GetMapping
    public List<Staff> getAllStaff() {
        return staffService.getAllStaff();
    }


    @GetMapping(path = "{staffId}")
    public Staff getStaffMember(@PathVariable("staffId") Long staffId){
        return staffService.getStaffMember(staffId);
    }


    @PostMapping
    public Long createNewStaff(@RequestBody Staff staff){
        return staffService.addNewStaff(staff);
    }


    @DeleteMapping(path = "{staffId}")
    public void deleteStaff(@PathVariable("staffId") Long staffId){
        staffService.deleteStaff(staffId);
    }


    @PutMapping
    public void updateStaff(@RequestBody Staff staff){
        staffService.updateStaff(staff);
    }

}
