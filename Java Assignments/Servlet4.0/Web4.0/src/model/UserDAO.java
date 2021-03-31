package model;

public interface UserDAO {
	public UserDTO getUserDTO(int id);
	public int deleteUser(int id);
	public int updateUser(UserDTO userDTO);
	public int insertUser(UserDTO userDTO);
	public UserDTO getUserByName(String uname,String password);
}
