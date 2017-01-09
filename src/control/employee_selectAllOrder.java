package control;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.employeeDAO;
import dao.orderDAO;
import model.order;
import model.orderemployeedetail;

/**
 * Servlet implementation class employee_selectAllOrder
 */
@WebServlet("/employee_selectAllOrder")
public class employee_selectAllOrder extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public employee_selectAllOrder() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		
		ArrayList<orderemployeedetail> list = new ArrayList<>();
		orderDAO ord = new orderDAO();
		list = (ArrayList<orderemployeedetail>) ord.selectAllOrder();

		request.setAttribute("list", list);

		RequestDispatcher dispatcher = request.getRequestDispatcher("services_employee.jsp");
		if (dispatcher != null) {
			dispatcher.forward(request, response);
			System.out.println("send To Service_employee.jsp");
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
