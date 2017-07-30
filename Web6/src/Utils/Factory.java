package Utils;

import dao.impl.EmployeeDAOJdbcImpl;

/**
 * 工厂可以使用配置文件来获得接口与对应实现类的对应关系，
 * 	这样，当实现类发生改变，不用再去修改工厂类的源代码
 * 
 * @author 木石前盟Cam
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
