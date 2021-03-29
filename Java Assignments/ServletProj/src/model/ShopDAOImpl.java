package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

public class ShopDAOImpl implements ShopDAO{
	
	private String shopName;
	
	public ShopDAOImpl(String name) {
		this.shopName = name;
	}
	
	public static ShopDAOImpl getShopDAOImpl(String name) {
		return new ShopDAOImpl(name);
	}
	
	@Override
	public ShopDTO getShopDTO(int id) {
		ShopDTO shopDTO=new ShopDTO();
		Connection con=DBUtility.getConnection();
		PreparedStatement ps;
		try {
			ps = con.prepareStatement("select * from "+ this.shopName +" where itemNo=?");
			ps.setInt(1, id);
			ResultSet rs=ps.executeQuery();
			if(rs.next()) {
				shopDTO.setItemNo(rs.getInt(1));
				shopDTO.setItemName(rs.getString(2));
				shopDTO.setItemPrice(rs.getInt(3));
				shopDTO.setItemURL(rs.getString(4));
				return shopDTO;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	
	@Override
	public ShopDTO getShopByName(String name) {
		ShopDTO shopDTO=new ShopDTO();
		Connection con=DBUtility.getConnection();
		PreparedStatement ps;
		try {
			ps = con.prepareStatement("select * from "+ this.shopName +" where itemName=?");
			ps.setString(1, name);
			ResultSet rs=ps.executeQuery();
			if(rs.next()) {
				shopDTO.setItemNo(rs.getInt(1));
				shopDTO.setItemName(rs.getString(2));
				shopDTO.setItemPrice(rs.getInt(3));
				shopDTO.setItemURL(rs.getString(4));
				return shopDTO;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	
	@Override
	public ArrayList<ShopDTO> getAllItem() {
		ArrayList<ShopDTO> list = new ArrayList<ShopDTO>();
		Connection con=DBUtility.getConnection();
		PreparedStatement ps;
		try {
			ps = con.prepareStatement("select * from "+ this.shopName);
			ResultSet rs=ps.executeQuery();
			while(rs.next()) {
				ShopDTO shopDTO=new ShopDTO();
				shopDTO.setItemNo(rs.getInt(1));
				shopDTO.setItemName(rs.getString(2));
				shopDTO.setItemPrice(rs.getInt(3));
				shopDTO.setItemURL(rs.getString(4));
				list.add(shopDTO);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}
	
	@Override
	public int insertShop(ShopDTO shopDTO) {
		Connection con=DBUtility.getConnection();
		try {
			PreparedStatement ps = con.prepareStatement("insert into "+ this.shopName + " values (?,?,?,?)");
			ps.setInt(1, shopDTO.getItemNo());
			ps.setString(2, shopDTO.getItemName());
			ps.setInt(3, shopDTO.getItemPrice());
			ps.setString(4, shopDTO.getItemURL());
			int count = ps.executeUpdate();
			return count;
		}catch(Exception e){
			e.printStackTrace();
		}
		return 0;
	}
	
	@Override
	public int updateShop(ShopDTO shopDTO) {
		// TODO Auto-generated method stub
		return 0;
	}
	
	@Override
	public int deleteShop(int id) {
		// TODO Auto-generated method stub
		return 0;
	}
}
