package test;

import service.AccountLimitException;
import service.AccountNotExistException;
import service.AccountService;

public class Test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		AccountService service = new AccountService();
		try {
			String number = service.apply("1234567890123456", 80000);
			System.out.println("number: " + number);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			//1、先记录日志
			e.printStackTrace();
			
			//2、区分异常类型，分别进行相应的处理：
			//		系统异常，一般不能恢复，提示用户稍后重试
			//		应用异常，提示用户采取正确的操作
			if(e instanceof AccountNotExistException){
				System.out.println("帐号不存在!");
			}else if(e instanceof AccountLimitException){
				System.out.println("余额不足!");
			}else{
				System.out.println("系统繁忙，稍后重试！");
			}
		}
	}

}
