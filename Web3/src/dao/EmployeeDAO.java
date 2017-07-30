package dao;

import java.util.List;

import entity.Employee;

/**
 * DAO接口，声明一系列访问数据库的方法
 * 	这些不涉及具体的技术。
 * 
 * @author 木石前盟Cam
 *
 */
public interface EmployeeDAO {
	public List<Employee> findAll() throws Exception;
	
	public void deleteEmp(int id) throws Exception;
	
	public void addEmp(Employee emp) throws Exception;
	
	public Employee findById(int id) throws Exception;
	
	public void modifyEmp(Employee emp) throws Exception;
}
