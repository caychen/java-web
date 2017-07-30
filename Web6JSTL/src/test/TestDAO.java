package test;

import java.util.List;

import Utils.Factory;
import dao.EmployeeDAO;
import entity.Employee;

public class TestDAO {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		EmployeeDAO dao = (EmployeeDAO) Factory.getInstance("EmployeeDAO");
		
		List<Employee> emps = dao.findAllByPage(2, 5);
		
		for (Employee employee : emps) {
			System.out.println(employee);
		}
	}

}
