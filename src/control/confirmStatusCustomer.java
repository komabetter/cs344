package control;

import java.io.IOException;

import javax.persistence.criteria.CriteriaBuilder.In;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.customersDAO;
import model.customers;
import model.orderdetail;
import model.product;
import util.HibernateUtil;
import util.HibernateUtils;

/**
 * Servlet implementation class confirmStatusCustomer
 */
@WebServlet("/confirmStatusCustomer")
public class confirmStatusCustomer extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public confirmStatusCustomer() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		String idcustomer = request.getParameter("idcus");
		String idpro = request.getParameter("idpro");
		String idorder = request.getParameter("idorder");

		boolean check = false;
		customersDAO cus = new customersDAO();
		check = cus.updateResiveProduct(Integer.parseInt(idpro), Integer.parseInt(idorder), Integer.parseInt(idcustomer));
		
		System.out.println("End fonfirm");
		
		request.setAttribute("id", idcustomer);	
		RequestDispatcher dispatcher = request.getRequestDispatcher("getProductCustomer");
		if (dispatcher != null) {
			dispatcher.forward(request, response);
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
