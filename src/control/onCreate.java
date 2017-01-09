package control;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.*;
import model.*;

/**
 * Servlet implementation class onCreate
 */
@WebServlet("/onCreate")
public class onCreate extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public onCreate() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		customers cus = new customers();
		employee em = new employee();
		order ord = new order();
		orderdetail orde = new orderdetail();
		orderemployeedetail orem = new orderemployeedetail();
		product pro = new product();
		company com = new company();
		
		companyDAO comdao = new companyDAO();
		customersDAO cdao = new customersDAO();
		employeeDAO emdao = new employeeDAO();
		orderDAO ordao = new orderDAO();
		orderDetailDAO ordedao = new orderDetailDAO();
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
