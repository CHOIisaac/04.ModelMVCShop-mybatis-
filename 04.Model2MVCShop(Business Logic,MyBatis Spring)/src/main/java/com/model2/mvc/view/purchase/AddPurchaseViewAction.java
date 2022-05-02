package com.model2.mvc.view.purchase;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.model2.mvc.framework.Action;
import com.model2.mvc.service.domain.Product;
import com.model2.mvc.service.domain.Purchase;
import com.model2.mvc.service.domain.User;
import com.model2.mvc.service.product.dao.ProductDAO;
import com.model2.mvc.service.purchase.PurchaseService;
import com.model2.mvc.service.purchase.impl.PurchaseServiceImpl;

public class AddPurchaseViewAction extends Action {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		HttpSession session = request.getSession();
		User user = (User)session.getAttribute("user");
		
		Purchase purchase = new Purchase();
//		purchase.setPaymentOption(request.getParameter("payment_option"));
//		purchase.setBuyer(request.getParameter("user_name"));
		
		int prodNo = Integer.parseInt(request.getParameter("prodNo"));
		
		ProductDAO productDAO = new ProductDAO();
		Product product = null;
		product = productDAO.findProduct(prodNo);
		
		request.setAttribute("product", product);
		
		System.out.println("AddPurchaseAction ::"+purchase);
//		
//		PurchaseService purchaseService=new PurchaseServiceImpl();
//		purchaseService.addPurchase(purchase);
//		
	
		return "forward:/purchase/addPurchaseView.jsp";
	}
}	
