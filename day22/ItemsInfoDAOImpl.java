package day19;

import java.sql.Connection;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class ItemsInfoDAOImpl implements ItemsInfoDAO{
	
	@Override
	public int insertItemsInfo(ItemsInfoDTO items) {
		int updatedRows = 0;
		try {
			Connection con = DBUtility.getConnection();
			PreparedStatement ps = con.prepareStatement("INSERT INTO item_info VALUES (?, ?, ? ,?)");
			System.out.println("    "+items.getItem_qty());
			ps.setInt(1, items.getItem_no());
			ps.setString(2, items.getItem_desp());
			ps.setInt(3, items.getItem_price());
			ps.setInt(4, items.getItem_qty());
			updatedRows = ps.executeUpdate();
		}catch(Exception e) {
			DBUtility.closeConnection(e);
		}
		DBUtility.closeConnection(null);
		return updatedRows;
	}
	
	@Override
	public int updateItemsInfo(ItemsInfoDTO items) {
		int updatedRows = 0;
		try {
			Connection con = DBUtility.getConnection();
			PreparedStatement ps = con.prepareStatement("UPDATE items_info SET item_description = ?,item_price = ?,item_qty = ? where item_no = ?");
			ps.setInt(4, items.getItem_no());
			ps.setString(1, items.getItem_desp());
			ps.setInt(2, items.getItem_price());
			ps.setInt(3, items.getItem_qty());
			updatedRows = ps.executeUpdate();
		}catch(Exception e) {
			DBUtility.closeConnection(e);
		}
		DBUtility.closeConnection(null);
		return updatedRows;
	}
	
	@Override
	public int deleteItemsInfo(int itemsid) {
		int updatedRows = 0;
		try {
			Connection con = DBUtility.getConnection();
			PreparedStatement ps = con.prepareStatement("DELETE FROM item_info where item_no = ?");
			ps.setInt(1, itemsid);
			updatedRows = ps.executeUpdate();
		}catch(Exception e) {
			DBUtility.closeConnection(e);
		}
		DBUtility.closeConnection(null);
		return updatedRows;
	}
	
	@Override
	public List<ItemsInfoDTO> getItemInfo(int itemsid) {
		
		ItemsInfoDTO dto = new ItemsInfoDTO();
		ArrayList<ItemsInfoDTO> i = new ArrayList<ItemsInfoDTO>();
		try {
			Connection con = DBUtility.getConnection();
			PreparedStatement ps = con.prepareStatement("SELECT * FROM item_info where item_no = ?");
			ps.setInt(1, itemsid);
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				dto.setItem_no(rs.getInt(1));
				dto.setItem_desp(rs.getString(2));
				dto.setItem_price(rs.getInt(3));
				dto.setItem_qty(rs.getInt(4));
				i.add(dto);
			}
		}catch(Exception e) {
			DBUtility.closeConnection(e);
		}
		DBUtility.closeConnection(null);
		return i;
	}
	
	@Override
	public HashMap<Integer, ItemsInfoDTO> getItemsInfoAll() {
		// TODO Auto-generated method stub
		return null;
	}
	
}
