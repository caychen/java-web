package Utils;

import dao.impl.EmployeeDAOJdbcImpl;

/**
 * ��������ʹ�������ļ�����ýӿ����Ӧʵ����Ķ�Ӧ��ϵ��
 * 	��������ʵ���෢���ı䣬������ȥ�޸Ĺ������Դ����
 * 
 * @author ľʯǰ��Cam
 *
 */
public class Factory {
	public static Object getInstance(String type){
		Object obj = null;
		
		if("EmployeeDAO".equals(type)){
			obj = new EmployeeDAOJdbcImpl();
		}
		return obj;
	}
}
