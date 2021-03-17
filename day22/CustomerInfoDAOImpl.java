package day19;

import java.sql.Connection; 
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.HashMap;

public class CustomerInfoDAOImpl implements CustomerInfoDAO{
	
	@Override
	public int insertCustomerInfo(CustomerInfoDTO csiDTO) {
		int updatedRows = 0;
		try {
			Connection con = DBUtility.getConnection();
			PreparedStatement ps = con.prepareStatement("INSERT INTO customer_info VALUES (?, ?, ?, ?)");
			ps.setInt(1, csiDTO.getCustomer_no());
			ps.setString(2, csiDTO.getCustomer_address());
			ps.setString(3, csiDTO.getCustomer_email());
			ps.setString(4, csiDTO.getCustomer_phone());
			updatedRows = ps.executeUpdate();
		}catch(Exception e) {
			DBUtility.closeConnection(e);
		}
		DBUtility.closeConnection(null);
		return updatedRows;
	}
	
	@Override
	public int updateCustmerInfo(CustomerInfoDTO csiDTO) {
		int updatedRows = 0;
		try {
			Connection con = DBUtility.getConnection();
			PreparedStatement ps = con.prepareStatement("UPDATE customer_info SET customer_address = ?,customer_email = ?,customer_phone = ? where inv_no = ?");
			ps.setInt(4, csiDTO.getCustomer_no());
			ps.setString(1, csiDTO.getCustomer_address());
			ps.setString(2, csiDTO.getCustomer_email());
			ps.setString(3, csiDTO.getCustomer_phone());
			updatedRows = ps.executeUpdate();
		}catch(Exception e) {
			DBUtility.closeConnection(e);
		}
		DBUtility.closeConnection(null);
		return updatedRows;
	}
	
	@Override
	public int deleteCustomerInfo(int csid) {
		int updatedRows = 0;
		try {
			Connection con = DBUtility.getConnection();
			PreparedStatement ps = con.prepareStatement("DELETE FROM customer_info where customer_no = ?");
			ps.setInt(1, csid);
			updatedRows = ps.executeUpdate();
		}catch(Exception e) {
			DBUtility.closeConnection(e);
		}
		DBUtility.closeConnection(null);
		return updatedRows;
	}
	
	@Override
	public CustomerInfoDTO getCustomerInfo(int csid) {
		CustomerInfoDTO dto = new CustomerInfoDTO();
		try {
			Connection con = DBUtility.getConnection();
			PreparedStatement ps = con.prepareStatement("SELECT * FROM customer_info where customer_no = ?");
			ps.setInt(1, csid);
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				dto.setCustomer_no(rs.getInt(1));
				dto.setCustomer_address(rs.getString(2));
				dto.setCustomer_email(rs.getString(3));
				dto.setCustomer_phone(rs.getString(4));
			}
		}catch(Exception e) {
			DBUtility.closeConnection(e);
		}
		DBUtility.closeConnection(null);
		return dto;
	}
	
	@Override
	public HashMap<Integer, CustomerInfoDTO> getCustomerInfoAll() {
		// TODO Auto-generated method stub
		return null;
	}
}
