package ctrl;

import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
//import javax.servlet.ServletRequest;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.MyDatabase;

@WebServlet({ "/VideoCo", "/VideoCo/*" })
public class VideoCo extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final String CONTEXT_APP_NAME = "applicationName";
	private String appName;
	private final String mainPage = "/UI.jsp";
	private final String loginPage = "/SignIn.jsp";
	private final String adminPage = "/Adminpage.jsp";

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public VideoCo() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public void init(ServletConfig config) throws ServletException {
		super.init(config);
		ServletContext context = getServletContext();
		appName = context.getInitParameter(CONTEXT_APP_NAME);
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		request.getSession().setAttribute("applicationName", appName); // pack app name
		String page = this.mainPage;

		if(!(request.getParameter("login") == null)) {
			page = this.mainPage;
			String username = request.getParameter("username");
			String password = request.getParameter("password");
			System.out.println("inputted username: " + username + " password: " + password);
			request.getSession().setAttribute("loggedin", "1");
			request.getSession().setAttribute("adminloggedin", "1");
			// check if the account is admin if so set - request.getSession().setAttribute("adminloggedin", "1")
		} 
		if (!(request.getParameter("register") == null)) {
			page = this.loginPage;
			int adminreg = 0;
			String usernameRegister = request.getParameter("usernameregister");
			String passwordRegister = request.getParameter("passwordregister");
			System.out.println("reguser: " + usernameRegister + " regpass: " + passwordRegister);
			if (!(request.getParameter("adminregister") == null)) {
				adminreg = 1;
			}
			// send usernameRegister, passwordRegister, adminreg to database here
		}
		if (!(request.getParameter("logout") == null)) {
			page = this.mainPage;
			request.getSession().setAttribute("loggedin", "0");
			request.getSession().setAttribute("adminloggedin", "0");
		}		
		if (!(request.getParameter("additem") == null)) {
			page = this.adminPage;
		}
		if (!(request.getParameter("checkinformation") == null)) {
			page = this.adminPage;
			request.getSession().setAttribute("orderinformation", "Order ID, Email, Total, Date of Delivery");
		} 
		System.out.println(request.getParameter("additem") + " " + request.getSession().getAttribute("adminloggedin"));
		
		System.out.println("login button pressed: " + request.getParameter("login"));
		System.out.println("register button pressed: " + request.getParameter("register"));
		System.out.println("logout button pressed: " + request.getParameter("logout"));
		System.out.println(request.getSession().getAttribute("loggedin"));
///////////////////
		//accessDatabase();
//////////////////		
		request.getSession().setAttribute("music1", "holyMolyUno");
		request.getSession().setAttribute("music2", "holyMoly2");
		request.getSession().setAttribute("music3", "holyMoly3");
		request.getSession().setAttribute("music4", "holyMoly4");
		request.getRequestDispatcher(page).forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		// System.out.println("POST is happening");
		doGet(request, response);
	}

	private void accessDatabase() {
		String dbUrl = "jdbc:mysql://rds-mysql-eecs4312-smartshopper.csh5frcxe9ub.us-east-1.rds.amazonaws.com/smart";
		String dbUsername = "admin";
		String dbPassword = "Netherthistle1";
		MyDatabase mydata = new MyDatabase(dbUrl, dbUsername, dbPassword);
		Connection con = mydata.getCon();
		if (con != null) {
			System.out.println("Database is connected");
		} else {
			System.out.println("Database is not connected");
		}

		Statement stmt = null;
		try {
			stmt = con.createStatement();
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		String strSelect = "select email from customers";
		System.out.println("The SQL statement is: " + strSelect + "\n");
		ResultSet rset = null;
		try {
			rset = stmt.executeQuery(strSelect);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		System.out.println("The records selected are:");
		int rowCount = 0;
		try {
			while (rset.next()) { // Move the cursor to the next row, return false if no more row
				String emailAddress = rset.getString("email");
				System.out.println(emailAddress);
				++rowCount;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		System.out.println("Total number of records = " + rowCount);

	}

}
