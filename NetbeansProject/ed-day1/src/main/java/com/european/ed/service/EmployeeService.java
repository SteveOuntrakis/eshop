package com.european.ed.service;

import com.european.ed.util.ActionResult;
import com.european.ed.model.Employee;
import com.european.ed.model.Role;


public class EmployeeService {
    private Employee employee;

    public EmployeeService() {
        employee= new Employee();
    }
    

    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }
    
    public ActionResult changeRole(Role newRole){
        if(employee.getId()<100){
            return new ActionResult(false,"id less than 100",300);
        }
        employee.setRole(newRole);
        return new ActionResult(true,"Success",200);
    }
}
