package test;

import java.util.List;

import dao.EmployeeDAO;
import dao.impl.EmployeeDAOJdbcImpl;
import entity.Employee;

public class TestDAO {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		EmployeeDAO dao = new EmployeeDAOJdbcImpl();
		
		List<Employee> emps = dao.findAll();
		
		System.out.println(emps.size());
		
	}

}
