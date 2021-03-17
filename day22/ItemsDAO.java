package day19;

import java.util.HashMap;

interface ItemsDAO {
	public int insertItems(ItemsDTO itemsid);
	public int updateItems(ItemsDTO itemsid);
	public int deleteItems(int itemsid);
	public ItemsDTO getItem(int itemsid);
	public HashMap<Integer, ItemsDTO> getItemsAll();
}
