package model;

import java.util.ArrayList;

public interface ShopDAO {
	public ShopDTO getShopByName(String name);
	public ShopDTO getShopDTO(int id);
	public ArrayList<ShopDTO> getAllItem();
	public int deleteShop(int id);
	public int updateShop(ShopDTO shopDTO);
	public int insertShop(ShopDTO shopDTO);
}
