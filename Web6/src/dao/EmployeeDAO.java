package dao;

import java.util.List;

import entity.Employee;

/**
 * DAO�ӿڣ�����һϵ�з������ݿ�ķ���
 * 	��Щ���漰����ļ�����
 * 
 * @author ľʯǰ��Cam
 *
 */
public interface EmployeeDAO {
	public List<Employee> findAll() throws Exception;
	
	public void deleteEmp(int id) throws Exception;
	
	public void addEmp(Employee emp) throws Exception;
	
	public Employee findById(int id) throws Exception;
	
	public void modifyEmp(Employee emp) throws Exception;
}
