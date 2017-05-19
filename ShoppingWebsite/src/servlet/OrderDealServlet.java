package servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.GoodBean;
import model.OrderBeanBo;
import model.OrderFullInfoBean;
import model.ShoppingCartBo;
import model.userBean;
/**
 * Servlet implementation class OrderDeal
 */
@WebServlet("/OrderDealServlet")
public class OrderDealServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public OrderDealServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		OrderBeanBo obb = new OrderBeanBo();
		ShoppingCartBo scb = (ShoppingCartBo) request.getSession().getAttribute("ShoppingCart");
		int userId = ((userBean)request.getSession().getAttribute("loginUser")).getUserId();
		System.out.println("the user Id is " + userId);
		OrderFullInfoBean ofib = obb.addOrder(scb, userId);
		
		if (ofib!= null) {
			request.setAttribute("OrderFullInfo", ofib);
			request.getRequestDispatcher("orderConfirm.jsp").forward(request, response);
		} else {
			List<GoodBean> res = scb.showShoppingCart();
			request.setAttribute("goodList", res);
			request.getRequestDispatcher("orderDetail.jsp").forward(request, response);
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
