package dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import Utils.DBUtils;
import dao.EmployeeDAO;
import entity.Employee;

public class EmployeeDAOJdbcImpl implements EmployeeDAO {

	@Override
	public List<Employee> findAll() throws Exception {
		// TODO Auto-generated method stub
		List<Employee> employees = new ArrayList<Employee>();
		
		Connection conn = null;
		
		try
		{
			conn = DBUtils.getConnection();
			Statement state = conn.createStatement();
			ResultSet rs = state.executeQuery("select * from t_emp");
			
			while(rs.next())
			{
				int id = rs.getInt("id");
				String name = rs.getString("name");
				double salary = rs.getDouble("salary");
				int age = rs.getInt("age");
				
				Employee e = new Employee();
				e.setId(id);
				e.setName(name);
				e.setSalary(salary);
				e.setAge(age);
				employees.add(e);
			}
		}catch(Exception e)
		{
			e.printStackTrace();
			throw e;
		}finally{
			DBUtils.closeConnection(conn);
		}
		return employees;
	}

	@Override
	public void deleteEmp(int id) throws Exception {
		// TODO Auto-generated method stub
		Connection conn = null;
		try
		{
			conn = DBUtils.getConnection();
			PreparedStatement state = conn.prepareStatement("delete from t_emp where id=?");
			state.setInt(1, id);
			
			state.executeUpdate();
			
		}catch(Exception e){
			e.printStackTrace();
			throw e;
		}finally{
			DBUtils.closeConnection(conn);
		}
	}

	@Override
	public void addEmp(Employee emp) throws Exception {
		// TODO Auto-generated method stub
		Connection conn = null;
		try
		{
			conn = DBUtils.getConnection();
			String sql = "insert into t_emp(name,salary,age) values(?,?,?)";
			PreparedStatement state = conn.prepareStatement(sql);
			
			state.setString(1, emp.getName());
			state.setDouble(2, emp.getSalary());
			state.setInt(3, emp.getAge());
			
			state.executeUpdate();
			
		}catch(Exception e){
			e.printStackTrace();
			throw e;
		}finally{
			DBUtils.closeConnection(conn);
		}
	}

	@Override
	public Employee findById(int id) throws Exception {
		// TODO Auto-generated method stub
		Employee emp = null;
		Connection conn = null;
		try {
			conn = DBUtils.getConnection();
			String sql = "select * from t_emp where id=?";
			PreparedStatement state = conn.prepareStatement(sql);
			state.setInt(1, id);
			
			ResultSet rs = state.executeQuery();
			
			if(rs.next())
			{
				emp = new Employee();
				
				String name = rs.getString("name");
				double salary = rs.getDouble("salary");
				int age = rs.getInt("age");
				
				emp.setId(id);
				emp.setName(name);
				emp.setSalary(salary);
				emp.setAge(age);
			}
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			DBUtils.closeConnection(conn);
		}
		
		return emp;
	}

	@Override
	public void modifyEmp(Employee emp) throws Exception {
		// TODO Auto-generated method stub
		Connection conn = null;
		try
		{
			conn = DBUtils.getConnection();
			String sql = "update t_emp set name=?,salary=?,age=? where id=?";
			PreparedStatement state = conn.prepareStatement(sql);
			
			state.setString(1, emp.getName());
			state.setDouble(2, emp.getSalary());
			state.setInt(3, emp.getAge());
			state.setInt(4, emp.getId());
			
			state.executeUpdate();
			
		}catch(Exception e){
			e.printStackTrace();
			throw e;
		}finally{
			DBUtils.closeConnection(conn);
		}
	}
}
