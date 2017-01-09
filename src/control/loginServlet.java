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
import javax.servlet.http.HttpSession;

import dao.*;
import model.*;
import util.HibernateUtil;
import util.HibernateUtils;

/**
 * Servlet implementation class loginServlet
 */
@WebServlet("/loginServlet")
public class loginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public loginServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		HttpSession session = request.getSession(true);

		// �Ѻ��Ҩҡ˹�� login.jsp
		String user = request.getParameter("Username");
		String pass = request.getParameter("Password");
		// End
		// ���ҧ�������������˹�ҷ����Ҩ�仵��
		String nextPage = "";
		// end

		// ���ҧ object �ҡ ����� class
		// DAO ����Ѻ���¡��ѧ�ѹ ���� �֧�����Ũҡ DB
		customersDAO cus = new customersDAO();
		companyDAO com = new companyDAO();
		employeeDAO em = new employeeDAO();
		orderDAO ord = new orderDAO();
		// END

		// ���ҧ object �ҡ�ǡ model �����Ѻ�����Ũҡ DAO
		customers customer = new customers();
		company compa = new company();
		employee employe = new employee();
		// end

		// ���ҧ arraylist �����Ѻ�����ŷ������¡�� �������¡��
		List<orderemployeedetail> list = new ArrayList<orderemployeedetail>();
		// end

		try {
			HibernateUtils.beginTransaction(); // �Դ����๵

			customer = cus.loginCustomer(user, pass);
			compa = com.loginCompany(user, pass);
			employe = em.loginEmployee(user, pass);
			
			System.out.println("===========================================");
			System.out.println("Customer : " + customer.isValid());
			System.out.println("Employe : " + employe.isValid());
			System.out.println("Company : " + compa.isValid());
			System.out.println("===========================================");

			HibernateUtils.commitTransaction(); // �Դ����๵

			if (customer.isValid()) {

				nextPage = "index_customer";
				session.setAttribute("customer", customer);

			} else if (employe.isValid()) {

				session.setAttribute("employe", employe);
				nextPage = "index_employee";
				

			} else if (compa.isValid()) {

				try {
					HibernateUtils.beginTransaction();
					list = (ArrayList<orderemployeedetail>) ord.selectAllOrder();
					HibernateUtils.commitTransaction();

				} catch (Exception e) {
					HibernateUtils.rollbackTransaction();
				}
				nextPage = "company";
				request.setAttribute("listProduct", list);

			} else {
				System.out.println("Login fail");
				nextPage = "login";

			}

		} catch (Exception e) {
			HibernateUtils.rollbackTransaction();
		}

		RequestDispatcher dispatcher = request.getRequestDispatcher(nextPage + ".jsp");
		if (dispatcher != null) {
			dispatcher.forward(request, response);
			System.out.println("send complete");

		}
	}

}
