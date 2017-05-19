package servlet;

import java.io.IOException;
import java.util.*;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.GoodBean;
import model.ShoppingCartBo;

/**
 * Servlet implementation class ShoppingCartServlet
 */
@WebServlet("/ShoppingCartServlet")
public class ShoppingCartServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ShoppingCartServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		
		String type = request.getParameter("type");
		ShoppingCartBo scb = (ShoppingCartBo)request.getSession().getAttribute("ShoppingCart");
		
		if (type.equals("addGood")){
			if (scb == null) {
				scb = new ShoppingCartBo();
				request.getSession().setAttribute("ShoppingCart", scb);
			}
			int goodId = Integer.parseInt(request.getParameter("goodId"));
			scb.addGoods(goodId, 1);
			
		} else if (type.equals("delete")) {
			int goodId = Integer.parseInt(request.getParameter("goodId"));
			scb.deleteGoods(goodId);
			
		} else if (type.equals("showCart")) {
			if (scb == null) {
				scb = new ShoppingCartBo();
				request.getSession().setAttribute("ShoppingCart", scb);
			}
		} else if (type.equals("deleteAll")) {
			if (scb != null) {
				scb.deleteAllGoods();
			}
		} else if (type.equals("updateGoods")) {
			String[] goodIds = request.getParameterValues("goodId");
			String[] newAmount = request.getParameterValues("newAmount");
			for (int i = 0; i < goodIds.length; i++) {
				System.out.println("update good id is " + goodIds[i]);
				System.out.println("the new amount is " + newAmount[i]);
				scb.updateGoods(Integer.parseInt(goodIds[i]), Integer.parseInt(newAmount[i]));
			}
			
		}
		 
		List<GoodBean> res = scb.showShoppingCart();
		request.setAttribute("ShoppingCartInfo", res);
		request.getRequestDispatcher("ShoppingCart.jsp").forward(request, response);
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
