package day19;

import java.util.HashMap;

public interface InvoiceMasterDAO {
	public int insertInvoiceMaster(InvoiceMasterDTO invDTO);
	public int updateInvoiceMaster(InvoiceMasterDTO invDTO);
	public int deleteInvoiceMaster(int invid);
	public InvoiceMasterDTO getInvoiceMaster(int ivoId);
	public HashMap<Integer, InvoiceMasterDTO> getInvoiceMasterAll();
}
