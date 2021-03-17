package day19;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.HashMap;

public class InvoiceMasterDAOImpl implements InvoiceMasterDAO{
	
	HashMap<Integer, InvoiceMasterDTO> dtos;
	
	@Override
	public int insertInvoiceMaster(InvoiceMasterDTO invDTO) {
		int updatedRows = 0;
		try {
			Connection con = DBUtility.getConnection();
			PreparedStatement ps = con.prepareStatement("INSERT INTO invoicemaster VALUES (?, ?, ?)");
			ps.setInt(1, invDTO.getInv_no());
			ps.setDate(2, invDTO.getInv_date());
			ps.setInt(3, invDTO.getCustomer_no());
			updatedRows = ps.executeUpdate();
		}catch(Exception e) {
			DBUtility.closeConnection(e);
		}
		DBUtility.closeConnection(null);
		return updatedRows;
	}
	
	@Override
	public int updateInvoiceMaster(InvoiceMasterDTO invDTO) {
		int updatedRows = 0;
		try {
			Connection con = DBUtility.getConnection();
			PreparedStatement ps = con.prepareStatement("UPDATE invoicemaster SET inv_date = ?,customer_no = ? where inv_no = ?");
			ps.setDate(1, invDTO.getInv_date());
			ps.setInt(2, invDTO.getCustomer_no());
			ps.setInt(3, invDTO.getInv_no());
			updatedRows = ps.executeUpdate();
		}catch(Exception e) {
			DBUtility.closeConnection(e);
		}
		DBUtility.closeConnection(null);
		return updatedRows;
	}
	
	@Override
	public int deleteInvoiceMaster(int invid) {
		int updatedRows = 0;
		try {
			Connection con = DBUtility.getConnection();
			PreparedStatement ps = con.prepareStatement("DELETE FROM invoicemaster where inv_no = ?");
			ps.setInt(1, invid);
			updatedRows = ps.executeUpdate();
		}catch(Exception e) {
			DBUtility.closeConnection(e);
		}
		DBUtility.closeConnection(null);
		return updatedRows;
	}
	
	@Override
	public InvoiceMasterDTO getInvoiceMaster(int ivoId) {
		InvoiceMasterDTO dto = new InvoiceMasterDTO();
		try {
			Connection con = DBUtility.getConnection();
			PreparedStatement ps = con.prepareStatement("SELECT * FROM invoicemaster where inv_no = ?");
			ps.setInt(1, ivoId);
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				dto.setInv_no(rs.getInt(1));
				dto.setInv_date(rs.getDate(2));
				dto.setCustomer_no(rs.getInt(3));
			}
		}catch(Exception e) {
			DBUtility.closeConnection(e);
		}
		DBUtility.closeConnection(null);
		return dto;
	}
	
	@Override
	public HashMap<Integer, InvoiceMasterDTO> getInvoiceMasterAll() {
		
		return null;
	}
	
}
