package control;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.employeeDAO;

/**
 * Servlet implementation class reseiveOrderServlet
 */
@WebServlet("/reseiveOrderServlet")
public class reseiveOrderServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public reseiveOrderServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String idem = request.getParameter("idem");
		String idor = request.getParameter("idor");

			employeeDAO em = new employeeDAO();
			em.saveEmployeeResiver(Integer.parseInt(idem), Integer.parseInt(idor));
			em.UpdateOrder(Integer.parseInt(idor));
			RequestDispatcher dispatcher = request.getRequestDispatcher("employee_selectAllOrder");
			if (dispatcher != null) {
				dispatcher.forward(request, response);
				System.out.println("send complete");
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
