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

import dao.customersDAO;
import model.orderdetail;
import util.HibernateUtils;

/**
 * Servlet implementation class getProductCustomer
 */
@WebServlet("/getProductCustomer")
public class getProductCustomer extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public getProductCustomer() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String id = (String) request.getAttribute("id");
		List<orderdetail> list = new ArrayList<orderdetail>();
		customersDAO cus = new customersDAO();

		try {
			HibernateUtils.beginTransaction();
			list = cus.selectProduct(id);
			HibernateUtils.commitTransaction();
		} catch (Exception e) {
			HibernateUtils.rollbackTransaction();
		}

		request.setAttribute("listProduct", list);
		 RequestDispatcher dispatcher =
		 request.getRequestDispatcher("services_customer.jsp");
		 if (dispatcher != null) {
		 dispatcher.forward(request, response);
		 System.out.println("send complete");
		 }

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

	}

}
