package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class UserDAOImpl implements UserDAO{
	
	public static UserDAOImpl getUserDAOImpl() {
		return new UserDAOImpl();
	}
	
	@Override
	public UserDTO getUserDTO(int id) {
		try {
			UserDTO userDTO=new UserDTO();
			Connection con=DBUtility.getConnection();
			PreparedStatement ps=con.prepareStatement("select * from users where id=?");
			ps.setInt(1, id);
			ResultSet rs=ps.executeQuery();
			if(rs.next()) {
				userDTO.setUid(rs.getInt(1));
				userDTO.setName(rs.getString(2));
				userDTO.setAge(rs.getInt(3));
				userDTO.setPass(rs.getString(4));
				userDTO.setFlag(rs.getInt(5));
			}
			return userDTO;
		}catch(Exception e) {
				e.printStackTrace();
				return null;
			}
	}
	
	@Override
	public UserDTO getUserByName(String uname,String password) {
		UserDTO userDTO=null;
		try {
			Connection con=DBUtility.getConnection();
			PreparedStatement ps=con.prepareStatement("select * from users where name=? and password = ?");
			ps.setString(1, uname);
			ps.setString(2, password);
			ResultSet rs=ps.executeQuery();
			userDTO = new UserDTO();
			if(rs.next()) {
				userDTO.setUid(rs.getInt(1));
				userDTO.setName(rs.getString(2));
				userDTO.setAge(rs.getInt(3));
				userDTO.setPass(rs.getString(4));
				userDTO.setFlag(rs.getInt(5));
				return userDTO;
			}
		}catch(Exception e) {
				e.printStackTrace();
				return null;
			}
		return null;
	}
	
	@Override
	public int insertUser(UserDTO userDTO) {
		try {
		Connection con = DBUtility.getConnection();
		PreparedStatement ps=con.prepareStatement("insert into users (name,age,password,flag) values (?,?,?,?)");
		ps.setString(1, userDTO.getName());
		ps.setInt(2, userDTO.getAge());
		ps.setString(3, userDTO.getPass());
		ps.setInt(4, userDTO.getFlag());
		int count = ps.executeUpdate();
		return count;
		}catch(Exception e) {
			e.printStackTrace();
		}
		return 0;
	}
	
	@Override
	public int updateUser(UserDTO userDTO) {
		return 0;
	}
	
	public int updateUserFlag(String name,String password,int flag) {
		try {
		Connection con=DBUtility.getConnection();
		PreparedStatement ps=con.prepareStatement("update users set flag = ? where name = ? and password = ?");
		ps.setInt(1, flag);
		ps.setString(2, name);
		ps.setString(3, password);
		int count = ps.executeUpdate();
		return count;
		}
		catch(Exception e) {
			return 0;
		}
	}
	
	@Override
	public int deleteUser(int id) {
		// TODO Auto-generated method stub
		return 0;
	}
}
