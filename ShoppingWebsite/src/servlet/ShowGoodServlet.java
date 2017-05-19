package servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.GoodBean;
import model.GoodBeanBo;

/**
 * Servlet implementation class ShowGoodServlet
 */
@WebServlet("/ShowGoodServlet")
public class ShowGoodServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ShowGoodServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String type = request.getParameter("type");
		if (type.equals("showDetail")) {
			int goodId = Integer.parseInt(request.getParameter("goodId"));
			GoodBeanBo gbbo = new GoodBeanBo();
			GoodBean gb = gbbo.getGoodBean(goodId);
			request.setAttribute("goodInfo", gb);
			request.getRequestDispatcher("showDetail.jsp").forward(request, response);
		} else if (type.equals("fenye")) {
			String pageNow = request.getParameter("pageNow");
			System.out.println("Servlet get " + pageNow);
			request.setAttribute("pageNow", pageNow);
			request.getRequestDispatcher("Index.jsp").forward(request, response);	
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
