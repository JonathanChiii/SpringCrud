/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.demo.dao;


import java.util.List;

import com.demo.model.Employee;


public interface EmployeeDAO {
    public void save(Employee e);
    public void update(Employee e);
    public void delete(int id);
    public List<Employee> findAll();
    public Employee findById(Integer id);
    public List<Employee> findByProperty(Integer property,Object value);

}
