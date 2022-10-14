package com.demo.daoImpl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import com.demo.dao.EmployeeDAO;
import com.demo.model.Employee;
import com.demo.rm.UserRowMapper;
import com.demo.dao.BaseDAO;

@Repository
public class EmployeeDAOImpl extends BaseDAO implements EmployeeDAO  {

	@Override
	public void save(Employee e) {
		// TODO Auto-generated method stub
		String query = "INSERT INTO Employee (id, name, email, password, salary) VALUES (:id, :name, :email, :password, :salary)";
		Map<String, String> hm = new HashMap<>();
		hm.put("id", Integer.toString(e.getId()));
		hm.put("name", e.getName());
		hm.put("email", e.getEmail());
		hm.put("password", e.getPassword());
		hm.put("salary", Integer.toString(e.getSalary()));
		super.getNamedParameterJdbcTemplate().update(query,hm);
	}

	@Override
	public void update(Employee e) {
		String query = "Update employee set name=:name, email=:email, password=:password, salary=:salary where id=:id";
		Map hm = new HashMap<>();
		hm.put("id", e.getId());
		hm.put("name", e.getName());
		hm.put("email", e.getEmail());
		hm.put("password", e.getPassword());
		hm.put("salary", e.getSalary());
		super.getNamedParameterJdbcTemplate().update(query,hm);
		
	}

	@Override
	public void delete(int id) {
		// TODO Auto-generated method stub
		String query = "delete from employee where id=:id";
		Map hm = new HashMap<>();
		hm.put("id", id);
		super.getNamedParameterJdbcTemplate().update(query,hm);
	}

	@Override
	public List<Employee> findAll() {
		String sql="SELECT "
                +"          id "
                +"          ,name "
                +"          ,email "
                +"          ,password "
                +"          ,salary "
                +" FROM "
                +"           Employee";
         return getNamedParameterJdbcTemplate().query(sql,new UserRowMapper());
	}

	@Override
	public Employee findById(Integer id) {
		String query = "select * from employee where id=:id";
		Map m=new HashMap();
	       m.put("id",id);
	       return getNamedParameterJdbcTemplate().queryForObject(query, m, new UserRowMapper());
	}

	@Override
	public List<Employee> findByProperty(Integer property, Object value) {
		// TODO Auto-generated method stub
		return null;
	}

}
