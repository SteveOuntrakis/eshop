package com.european.ed.userinterface;

import com.european.ed.model.Department;
import com.european.ed.model.Employee;
import com.european.ed.model.Role;
import com.european.ed.service.EmployeeService;
import com.european.ed.util.ActionResult;

public class Ui {

    public void functionTest() {
        EmployeeService employeeService = new EmployeeService();
        ActionResult actionResult = employeeService.changeRole(new Role());
        System.out.println(actionResult);
    }
    public void function2(){
        Employee employee = new Employee();
        Department department = new Department();
        employee.setName("Stefanos");
        department.setName("Sales");
        employee.setDepartment(department);
        department.setEmployee(employee);
        System.out.println(employee.getDepartment().getName());
    }

}
