/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.demo.rm;


import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.demo.model.Employee;

public class UserRowMapper implements RowMapper<Employee>{
	

    @Override
    public Employee mapRow(ResultSet rs, int i) throws SQLException {
       Employee employee=new Employee();
       employee.setId(rs.getInt("id"));
       employee.setName(rs.getString("name"));
       employee.setPassword(rs.getString("password"));
       employee.setEmail(rs.getString("email"));
       employee.setSalary(rs.getInt("salary"));
       return employee;
       
       
    }
    
    
    

      
}
