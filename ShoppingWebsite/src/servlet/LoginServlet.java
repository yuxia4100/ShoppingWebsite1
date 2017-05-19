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
import model.UserBeanBo;
import model.userBean;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String userName = request.getParameter("userName");
		String password = request.getParameter("password");
		System.out.println(userName);
		System.out.println(password);
		UserBeanBo ubo = new UserBeanBo();
		boolean verified = ubo.veriflyUser(userName, password);
		if (verified == true) {
			userBean ub = ubo.getUserBeanByName(userName);
			request.getSession().setAttribute("loginUser", ub);
			ShoppingCartBo scb = (ShoppingCartBo)request.getSession().getAttribute("ShoppingCart");
			List<GoodBean> res = scb.showShoppingCart();
			request.setAttribute("goodList", res);
			request.getRequestDispatcher("orderDetail.jsp").forward(request, response);
		} else {
			request.setAttribute("loginError", "Wrong user name or password!");
			request.getRequestDispatcher("login.jsp").forward(request, response);
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
