package service;

import java.util.Random;

import dao.AccountDAO;
import entity.Account;

public class AccountService {
	public String apply(String accountNo, double amount) throws Exception{
		String number = "";
		//1������ʺ��Ƿ���ڣ���������ڣ�Ҫ��ʾ�û��ʺŲ����ڣ����������һ��
		AccountDAO dao = new AccountDAO();
		Account account = dao.findByAccountNo(accountNo);
		if(account == null){
			//�׳�һ���Զ����쳣(Ӧ���쳣��������ϵͳԭ��������쳣�������û�ʹ�ò�����ɵģ���Ҫ��ʾ�û���ȡ��ȷ�Ĳ���)
			throw new AccountNotExistException();
		}
		
		//2���������Ƿ���㣬������㣬����Ҫ��ʾ�û�������ͽ�����һ��
		if(account.getBalance() * 10 < amount){
			//����
			throw new AccountLimitException();
		}
		
		//3������һ�����кţ����ұ�������кŵ����ݿ�
		Random rnd = new Random();
		number = rnd.nextInt(10000000) + "";
		//��������кŵ����ݿ⣬��...
		return number;
	}
}
