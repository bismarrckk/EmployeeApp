/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSF/JSFManagedBean.java to edit this template
 */
package com.bizz.EmployeeApp.controller;


import com.bizz.EmployeeApp.entity.Employees;
import com.bizz.EmployeeApp.service.EmployeesFacade;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Named;
import jakarta.faces.application.FacesMessage;
import jakarta.faces.context.FacesContext;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;
import java.io.Serializable;
import java.util.List;
import org.primefaces.PrimeFaces;

/**
 *
 * @author BIZZ
 */
@Named(value = "employeeBean")
@ApplicationScoped
@Transactional
public class EmployeeBean implements Serializable{

    /**
     * Creates a new instance of EmployeeBean
     */
   
    private Employees selectedEmployee;
       
    
    @Inject
    private EmployeesFacade ef;

    public EmployeeBean() {
    }

    
    public Employees getSelectedEmployee() {
        return selectedEmployee;
    }

    public void setSelectedEmployee(Employees selectedEmployee) {
        this.selectedEmployee = selectedEmployee;
    }
    
    public void newEmployee(){
       this.selectedEmployee=new Employees();
   }

    public void save(){
        if(this.selectedEmployee.getId() ==null){
            ef.create(this.selectedEmployee);
             ef.edit(this.selectedEmployee);
        FacesContext.getCurrentInstance().addMessage(null,new FacesMessage("Employee Created Successfully"));
        }else{
         ef.edit(this.selectedEmployee);
         FacesContext.getCurrentInstance().addMessage(null,new FacesMessage("Update Successful"));
        }
    
        PrimeFaces.current().executeScript("PF('manageEmployeesDialog').hide()");
        PrimeFaces.current().ajax().update("form:messages", "form:dt-employees");
       
       
    }
    
    public List<Employees> allEmployees(){
        return ef.findAll();
    }
    
    public void delete(){
        ef.remove(this.selectedEmployee);
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Employee Deleted"));
        PrimeFaces.current().ajax().update("form:messages", "form:dt-employees");
    }
    
      

   
    
}
