package day19;

import java.util.HashMap;

interface CustomerInfoDAO {
	public int insertCustomerInfo(CustomerInfoDTO csiDTO);
	public int updateCustmerInfo(CustomerInfoDTO csiDTO);
	public int deleteCustomerInfo(int csid);
	public CustomerInfoDTO getCustomerInfo(int csid);
	public HashMap<Integer, CustomerInfoDTO> getCustomerInfoAll();
}
