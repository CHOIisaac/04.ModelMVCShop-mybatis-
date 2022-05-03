package com.model2.mvc.service.purchase.test;

import java.util.List;
import java.util.Map;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.model2.mvc.common.Search;
import com.model2.mvc.service.domain.Product;
import com.model2.mvc.service.domain.Purchase;
import com.model2.mvc.service.domain.User;
import com.model2.mvc.service.purchase.PurchaseService;


/*
 *	FileName :  UserServiceTest.java
 * 占쏙옙 JUnit4 (Test Framework) 占쏙옙 Spring Framework 占쏙옙占쏙옙 Test( Unit Test)
 * 占쏙옙 Spring 占쏙옙 JUnit 4占쏙옙 占쏙옙占쏙옙 占쏙옙占쏙옙 클占쏙옙占쏙옙占쏙옙 占쏙옙占쏙옙 占쏙옙占쏙옙占쏙옙 占쏙옙占� 占쏙옙占쏙옙 占쌓쏙옙트 占쌘드를 占쌜쇽옙 占쏙옙 占쏙옙 占쌍댐옙.
 * 占쏙옙 @RunWith : Meta-data 占쏙옙 占쏙옙占쏙옙 wiring(占쏙옙占쏙옙,DI) 占쏙옙 占쏙옙체 占쏙옙占쏙옙체 占쏙옙占쏙옙
 * 占쏙옙 @ContextConfiguration : Meta-data location 占쏙옙占쏙옙
 * 占쏙옙 @Test : 占쌓쏙옙트 占쏙옙占쏙옙 占쌀쏙옙 占쏙옙占쏙옙
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:config/commonservice.xml" })
public class PurchaseServiceTest {

	//==>@RunWith,@ContextConfiguration 占싱울옙 Wiring, Test 占쏙옙 instance DI
	@Autowired
	@Qualifier("purchaseServiceImpl")
	private PurchaseService purchaseService;

	//@Test
	public void testAddPurchase() throws Exception {
		
		Product product = new Product();
		product.setProdNo(10022);
		
		User user = new User();
		user.setUserId("user21");
		
		Purchase purchase = new Purchase();
		purchase.setPurchaseProd(product);
		purchase.setBuyer(user);
		purchase.setDivyRequest("1111");
		purchase.setDivyDate("12-05-27");
		
		purchaseService.addPurchase(purchase);
		
		purchase = purchaseService.getPurchase(10022);

		//==> console �솗�씤
		System.out.println("========================================"+purchase);
		
		//==> API �솗�씤
//		Assert.assertEquals(10041, purchase.getTranNo());
//		Assert.assertEquals(10021, purchase.getPurchaseProd().getProdNo());
//		Assert.assertEquals("user01", purchase.getBuyer().getUserId());
//		Assert.assertEquals("1", purchase.getPaymentOption().trim());
//		Assert.assertEquals("�꽌�슱", purchase.getDivyAddr());
//		Assert.assertEquals("12-05-27 00:00:00.0", purchase.getDivyDate());
	}
	
	//@Test
	public void testGetPurchase() throws Exception {
		
		Purchase purchase = new Purchase();
		purchase = purchaseService.getPurchase(10014);

		//==> console �솗�씤
		System.out.println("======================"+purchase);
		
		//==> API �솗�씤
//		Assert.assertEquals(10001, purchase.getTranNo());
//		Assert.assertEquals(10001, purchase.getPurchaseProd().getProdNo());
//		Assert.assertEquals("user21", purchase.getBuyer().getUserId());
//		Assert.assertEquals("�꽌�슱", purchase.getDivyAddr());

//		Assert.assertNotNull(purchaseService.getPurchase(10007));
//		Assert.assertNotNull(purchaseService.getPurchase(10008));
	}
	
	@Test
	 public void testUpdatePurchase() throws Exception{
		 
		Purchase purchase = purchaseService.getPurchase(10015);
		Assert.assertNotNull(purchase);
		
		purchase.setPaymentOption("1");
		purchase.setReceiverName("test");
//		purchase.setReceiverPhone("testName");
		purchase.setDivyAddr("12");
//		purchase.setDivyRequest("1111");
//		purchase.setDivyDate("123");
		
		purchaseService.updatePurchase(purchase);
		
		purchase = purchaseService.getPurchase(10014);
		Assert.assertNotNull(purchase);
		
//		//==> console �솗�씤
		System.out.println(purchase);
			
		//==> API �솗�씤
		Assert.assertEquals(10041, purchase.getTranNo());
		Assert.assertEquals(10021, purchase.getPurchaseProd().getProdNo());
		Assert.assertEquals("user21", purchase.getBuyer().getUserId());
		Assert.assertEquals("2", purchase.getPaymentOption().trim());
		Assert.assertEquals("1", purchase.getReceiverName().trim());
		Assert.assertEquals("12", purchase.getDivyAddr());
//		Assert.assertEquals("123", purchase.getDivyDate());
	 }
	 
	 //==>  二쇱꽍�쓣 ��怨� �떎�뻾�븯硫�....
	 //@Test
	 public void testGetPurchaseListAll() throws Exception{
		 
	 	Search search = new Search();
	 	search.setCurrentPage(1);
	 	search.setPageSize(3);
	 	Map<String,Object> map = purchaseService.getPurchaseList(search, "user01");
	 	
	 	List<Object> list = (List<Object>)map.get("list");
	 	Assert.assertEquals(3, list.size());
	 	
		//==> console �솗�씤
	 	System.out.println(list);
	 	
	 	Integer totalCount = (Integer)map.get("totalCount");
	 	System.out.println(totalCount);
	 	
	 }
}