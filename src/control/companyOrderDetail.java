package control;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.companyDAO;
import model.orderdetail;

/**
 * Servlet implementation class companyOrderDetail
 */
@WebServlet("/companyOrderDetail")
public class companyOrderDetail extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public companyOrderDetail() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		String idorder = request.getParameter("idorder");
		List<orderdetail> list = new ArrayList<orderdetail>();
		companyDAO com = new companyDAO();
		list = com.selectProductByOrderId(idorder);
		request.setAttribute("listProduct", list);
		RequestDispatcher dispatcher = request.getRequestDispatcher("company_OrderDetail.jsp");
		if (dispatcher != null) {
			dispatcher.forward(request, response);
			System.out.println("send complete");
		}
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
