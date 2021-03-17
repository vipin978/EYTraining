package day19;

import java.sql.Connection;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.HashMap;

public class ItemsDAOImpl implements ItemsDAO{
	@Override
	public int insertItems(ItemsDTO itemsid) {
		int updatedRows = 0;
		try {
			Connection con = DBUtility.getConnection();
			PreparedStatement ps = con.prepareStatement("INSERT INTO inventory VALUES (?, ?, ?)");
			ps.setInt(1, itemsid.getInv_no());
			ps.setInt(2, itemsid.getItem_no());
			ps.setInt(3, itemsid.getItem_unt());
			updatedRows = ps.executeUpdate();
		}catch(Exception e) {
			DBUtility.closeConnection(e);
		}
		DBUtility.closeConnection(null);
		return updatedRows;
	}
	
	@Override
	public int updateItems(ItemsDTO itemsid) {
		int updatedRows = 0;
		try {
			Connection con = DBUtility.getConnection();
			PreparedStatement ps = con.prepareStatement("UPDATE inventory SET item_unit = ? where inv_no = ? and item_no = ?");
			ps.setInt(2, itemsid.getInv_no());
			ps.setInt(3, itemsid.getItem_no());
			ps.setInt(1, itemsid.getItem_unt());
			updatedRows = ps.executeUpdate();
		}catch(Exception e) {
			DBUtility.closeConnection(e);
		}
		DBUtility.closeConnection(null);
		return updatedRows;
	}
	
	@Override
	public int deleteItems(int itemsid) {
		int updatedRows = 0;
		try {
			Connection con = DBUtility.getConnection();
			PreparedStatement ps = con.prepareStatement("DELETE FROM inventory where item_no = ?");
			ps.setInt(1, itemsid);
			updatedRows = ps.executeUpdate();
		}catch(Exception e) {
			DBUtility.closeConnection(e);
		}
		DBUtility.closeConnection(null);
		return updatedRows;
	}
	
	@Override
	public ItemsDTO getItem(int itemsid) {
		ItemsDTO dto = new ItemsDTO();
		try {
			Connection con = DBUtility.getConnection();
			PreparedStatement ps = con.prepareStatement("SELECT * FROM inventory where inv_no = ?");
			ps.setInt(1, itemsid);
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				dto.setInv_no(rs.getInt(1));
				dto.setItem_no(rs.getInt(2));
				dto.setItem_unt(rs.getInt(3));
			}
		}catch(Exception e) {
			DBUtility.closeConnection(e);
		}
		DBUtility.closeConnection(null);
		return dto;
	}
	
	@Override
	public HashMap<Integer, ItemsDTO> getItemsAll() {
		// TODO Auto-generated method stub
		return null;
	}
	
}
