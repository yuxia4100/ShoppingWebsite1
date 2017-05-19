package servlet;
import model.userBean;
import model.UserBeanBo;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;



/**
 * Servlet implementation class RegisterServlet
 */
@WebServlet("/RegisterServlet")
public class RegisterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RegisterServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		userBean ub = new userBean();
		String userName = request.getParameter("userName");
		String userFirstName = request.getParameter("firstName");
		String userLastName = request.getParameter("lastName");
		String userPassword = request.getParameter("password");
		String userEmail = request.getParameter("email");
		String userPhone = request.getParameter("phone");
		String userAddress = request.getParameter("address");
		String userPostcode = request.getParameter("postcode");
		
		ub.setUserName(userName);
		ub.setUserFirstName(userFirstName);
		ub.setUserLastName(userLastName);
		ub.setUserPassword(userPassword);
		ub.setUserEmail(userEmail);
		ub.setUserPhone(userPhone);
		ub.setUserAddress(userAddress);
		ub.setUserPostcode(userPostcode);
		
		UserBeanBo ubo = new UserBeanBo();
		boolean hasAdded = ubo.addUser(ub);
		System.out.println(hasAdded);
		
		if (hasAdded == true) {
			request.setAttribute("registerInfo", "You have registered, please login");
			request.getRequestDispatcher("login.jsp").forward(request, response);
		} else {
			request.setAttribute("registerInfo", "please user other user name");
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
