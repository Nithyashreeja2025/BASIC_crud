package com.steffi.employeeandleave.controller;

import com.steffi.employeeandleave.EmployeeandleaveApplication;
import com.steffi.employeeandleave.model.Employee;
import com.steffi.employeeandleave.model.Leave;
import com.steffi.employeeandleave.repository.EmployeeRepository;
import com.steffi.employeeandleave.repository.LeaveRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/")
public class Controller {
    private EmployeeRepository er;
    private LeaveRepository lr;

    public Controller(EmployeeRepository er, LeaveRepository lr) {
        this.er = er;
        this.lr = lr;
    }
    @PostMapping("/apply")
    public String getLeave(@RequestBody Leave leave){
        int id=leave.getEmployeeId();
        List<Employee> employees= er.findAll();
        int found=0;
        Employee emp=null;
        for(Employee e:employees){
            if(e.getEmployeeId()==id){
                found=1;
                emp=e;
                break;
            }
        }
        if(found==1){
            if(emp.getLeaveBalance()< leave.getNumberOfDays()){
                lr.save(leave);
                return "Insufficient leave balance!Leave not approved";
            }
            else{
                leave.setStatus("Approved");
                lr.save(leave);
                return "Leave approved";
            }
        }
        else{
            return "Employee not found";
        }

    }
    @GetMapping("/{employeeId}")
    public String getLeave(@PathVariable int employeeId){
        List<Leave> leaves=lr.findAll();
        String result="";
        for(Leave l:leaves){
            if(l.getEmployeeId()==employeeId){
                result+="Leaveid:"+l.getLeaveId()+"\nLeavestatus:"+l.getStatus()+"\n\n";
            }

        }
        return result;

    }
}
