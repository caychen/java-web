package entity;

/**
 * ʵ����
 * 	ʵ��������Ӧ��������Щ�У���Ӧ��ʵ����ͻ�����Щ�У���������Ҫƥ�䡣
 * 	���⣬������Ҫ�ж�Ӧ��get/set������
 * @author ľʯǰ��Cam
 *
 */
public class Employee {
	private int id;
	private String name;
	private double salary;
	private int age;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public double getSalary() {
		return salary;
	}
	public void setSalary(double salary) {
		this.salary = salary;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	
}
