package service;

import java.util.Random;

import dao.AccountDAO;
import entity.Account;

public class AccountService {
	public String apply(String accountNo, double amount) throws Exception{
		String number = "";
		//1、检查帐号是否存在，如果不存在，要提示用户帐号不存在，否则进行下一步
		AccountDAO dao = new AccountDAO();
		Account account = dao.findByAccountNo(accountNo);
		if(account == null){
			//抛出一个自定义异常(应用异常，即不是系统原因产生的异常，而是用户使用不当造成的，需要提示用户采取正确的操作)
			throw new AccountNotExistException();
		}
		
		//2、检查余额是否充足，如果余额不足，则需要提示用户，否则就进行下一步
		if(account.getBalance() * 10 < amount){
			//余额不足
			throw new AccountLimitException();
		}
		
		//3、生成一个序列号，并且保存该序列号到数据库
		Random rnd = new Random();
		number = rnd.nextInt(10000000) + "";
		//保存该序列号到数据库，略...
		return number;
	}
}
