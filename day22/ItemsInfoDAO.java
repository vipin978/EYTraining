package day19;

import java.util.HashMap;
import java.util.List;

interface ItemsInfoDAO {
	public int insertItemsInfo(ItemsInfoDTO itemsid);
	public int updateItemsInfo(ItemsInfoDTO itemsid);
	public int deleteItemsInfo(int itemsid);
	public List<ItemsInfoDTO> getItemInfo(int itemsid);
	public HashMap<Integer, ItemsInfoDTO> getItemsInfoAll();
}
