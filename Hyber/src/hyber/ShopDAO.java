package hyber;

import java.util.List;


import org.hibernate.Query;
import org.hibernate.Session;

public class ShopDAO{
	
	private int shopType;
	
	public ShopDAO(int type) {
		this.shopType = type;
	}
	
	public static ShopDAO getShopDAOImpl(int name) {
		return new ShopDAO(name);
	}
	
	public ShopDTO getShopDTO(int id) {
		Session session = HybernateSession.getSession();
		session.beginTransaction();
		Query query = session.getNamedQuery("ShopDTO.byItemNo");
		query.setInteger(0, id);
		query.setInteger(1, shopType);
		List<ShopDTO> result = query.list();
		session.getTransaction().commit();
		return result.get(0);
	}
	
	
	public List<ShopDTO> getAllItem() {
		Session session = HybernateSession.getSession();
		session.beginTransaction();
		Query query = session.getNamedQuery("ShopDTO.everything");
		query.setInteger(0, shopType);
		List<ShopDTO> result = query.list();
		session.getTransaction().commit();
		return result;
	}
	
	public void insertShop(ShopDTO shopDTO) {
		Session session = HybernateSession.getSession();
		session.beginTransaction();
		session.save(shopDTO);
		session.getTransaction().commit();
	}
	
}
