package control;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.criteria.CriteriaBuilder.In;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.customersDAO;
import model.customerdetailorder;
import model.customers;
import model.orderdetail;
import util.HibernateUtils;

/**
 * Servlet implementation class selectProductCustomer
 */
@WebServlet("/selectProductCustomer")
public class selectProductCustomer extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public selectProductCustomer() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String id = request.getParameter("id");

		System.out.println("ID Customer : " + id);

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
		RequestDispatcher dispatcher = request.getRequestDispatcher("services_customer.jsp");
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

		String id = request.getParameter("id");
		String message ="Not found Order ID : "+id;
		String customerId = request.getParameter("customerId");
		List<orderdetail> list = new ArrayList<orderdetail>();
		customersDAO cus = new customersDAO();

		if (id.isEmpty() || id.equals("")) {
			HibernateUtils.beginTransaction();
			list = cus.selectProduct(customerId);
			HibernateUtils.commitTransaction();
		} else {
			try {
				HibernateUtils.beginTransaction();
				list = cus.selectProductByOrderId(id, customerId);
				HibernateUtils.commitTransaction();

			} catch (Exception e) {
				HibernateUtils.rollbackTransaction();
			}
		}

		System.out.println("dddddddddddddddddd");

		if (list.isEmpty() || list.size() == 0) {
			System.out.println("Empty : list");
			
			request.setAttribute("notfound", message);
			try {
				HibernateUtils.beginTransaction();
				list = cus.selectProduct(customerId);
				HibernateUtils.commitTransaction();

			} catch (Exception e) {
				HibernateUtils.rollbackTransaction();
			}
		} else {

		}

		request.setAttribute("listProduct", list);
		RequestDispatcher dispatcher = request.getRequestDispatcher("services_customer.jsp");
		if (dispatcher != null) {
			dispatcher.forward(request, response);
			System.out.println("send complete");
		}

	}

}
