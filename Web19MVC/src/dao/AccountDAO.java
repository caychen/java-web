package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import utils.DBUtils;
import entity.Account;

public class AccountDAO {
	public Account findByAccountNo(String accountNo) throws Exception{
		Account account = null;
		Connection conn = null;
		try {
			conn = DBUtils.getConnection();
			String sql = "SELECT * FROM t_account WHERE accountNo=?";
			PreparedStatement prepState = conn.prepareStatement(sql);
			prepState.setString(1, accountNo);
			ResultSet rs = prepState.executeQuery();
			if(rs.next()){
				account = new Account();
				account.setId(rs.getInt("id"));
				account.setAccountNo(accountNo);
				account.setBalance(rs.getDouble("balance"));
			}
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}finally{
			DBUtils.closeConnection(conn);
		}
		
		return account;
	}
}
