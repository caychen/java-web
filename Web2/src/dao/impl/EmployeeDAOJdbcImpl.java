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
}
