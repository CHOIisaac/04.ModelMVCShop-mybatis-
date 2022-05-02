package com.model2.mvc.service.purchase.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.model2.mvc.common.Search;
import com.model2.mvc.service.domain.Product;
import com.model2.mvc.service.domain.Purchase;
import com.model2.mvc.service.purchase.PurchaseDAO;
import com.model2.mvc.service.purchase.PurchaseService;

@Service("purchaseServiceImpl")
public class PurchaseServiceImpl implements PurchaseService{
	
	@Autowired
	@Qualifier("pruchaseDAOImpl")
	private PurchaseDAO purchaseDAO;
	
	public PurchaseServiceImpl() {
		System.out.println(this.getClass());
	}
	
	public void setPurchaseDAO(PurchaseDAO purchaseDAO) {
		this.purchaseDAO = purchaseDAO;
	}
	
	public void addPurchase(Purchase purchase) throws Exception{
		purchaseDAO.insertPurchase(purchase);
	}
	
	public Purchase getPurchase(int prodNo) throws Exception {
		return purchaseDAO.findPurchase(prodNo);
	}
	
	public Map<String, Object> getPurchaseList(Search search, String userId) throws Exception{
		List<Product> list = purchaseDAO.getPurchaseList(search);
		int totalCount = purchaseDAO.getTotalCount(search);
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("list", list);
		map.put("totalCount", new Integer(totalCount));
		
		return map;
	}
	
	public void updatePurchase(Purchase purchase) throws Exception;
	
	public void updateTranCode(Purchase purchase) throws Exception;
	
	public Map<String, Object> getSaleList(Search search) throws Exception;
}
