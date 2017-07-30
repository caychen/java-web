package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import Utils.DBUtils;
import entity.User;

public class UserDAO {
	public void register(User user) throws Exception {
		Connection conn = null;

		try {
			conn = DBUtils.getConnection();
			String sql = "insert into t_user(username,name,pwd,gender,email) values(?,?,?,?,?)";
			PreparedStatement state = conn.prepareStatement(sql);
			
			state.setString(1, user.getUsername());
			state.setString(2, user.getName());
			state.setString(3, user.getPwd());
			state.setString(4, user.getGender());
			state.setString(5, user.getEmail());
			
			state.executeUpdate();
			
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		} finally {
			DBUtils.closeConnection(conn);
		}
	}

	public User findByUserName(String username) throws Exception {
		// TODO Auto-generated method stub
		Connection conn = null;
		User user = null;

		try {
			conn = DBUtils.getConnection();
			String sql = "select * from t_user where username=?";
			PreparedStatement state = conn.prepareStatement(sql);
			state.setString(1, username);
			
			ResultSet rs = state.executeQuery();
			if(rs.next()){
				user = new User();
				user.setId(rs.getInt("id"));
				user.setUsername(rs.getString("username"));
				user.setName(rs.getString("name"));
				user.setPwd(rs.getString("pwd"));
				user.setGender(rs.getString("gender"));
				user.setEmail(rs.getString("email"));
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBUtils.closeConnection(conn);
		}
		return user;
	}
}
