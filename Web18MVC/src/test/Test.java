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
			//1���ȼ�¼��־
			e.printStackTrace();
			
			//2�������쳣���ͣ��ֱ������Ӧ�Ĵ���
			//		ϵͳ�쳣��һ�㲻�ָܻ�����ʾ�û��Ժ�����
			//		Ӧ���쳣����ʾ�û���ȡ��ȷ�Ĳ���
			if(e instanceof AccountNotExistException){
				System.out.println("�ʺŲ�����!");
			}else if(e instanceof AccountLimitException){
				System.out.println("����!");
			}else{
				System.out.println("ϵͳ��æ���Ժ����ԣ�");
			}
		}
	}

}
