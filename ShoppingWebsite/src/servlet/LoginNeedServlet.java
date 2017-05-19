package servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.GoodBean;
import model.ShoppingCartBo;
import model.userBean;

/**
 * Servlet implementation class LoginNeedServlet
 */
@WebServlet("/LoginNeedServlet")
public class LoginNeedServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginNeedServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		userBean loginUser =  (userBean) request.getSession().getAttribute("loginUser");
		if (loginUser == null) {
			System.out.println("You need login!");
			request.getRequestDispatcher("login.jsp").forward(request, response);
		} else {
			System.out.println("You have logged in!");
			ShoppingCartBo scb = (ShoppingCartBo)request.getSession().getAttribute("ShoppingCart");
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
