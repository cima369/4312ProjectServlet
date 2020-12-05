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
	private String page;

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
		page = this.mainPage;
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		request.getSession().setAttribute("applicationName", appName); // pack app name

		this.checkLogin(request);
		this.checkRegister(request);
		this.checkLogout(request);
		this.checkAddItem(request);
		this.checkInformation(request);

		/*
		 * System.out.println(request.getParameter("additem") + " " +
		 * request.getSession().getAttribute("adminloggedin"));
		 * System.out.println("login button pressed: " + request.getParameter("login"));
		 * System.out.println("register button pressed: " +
		 * request.getParameter("register"));
		 * System.out.println("logout button pressed: " +
		 * request.getParameter("logout"));
		 * System.out.println(request.getSession().getAttribute("loggedin"));
		 * accessDatabase();
		 */

		this.addMusicItems(request);
		this.addMovieItems(request);
		this.addComedyItems(request);

		request.getRequestDispatcher(this.page).forward(request, response);
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

	private void addMusicItems(HttpServletRequest request) {
		request.getSession().setAttribute("music1", "music1");
		request.getSession().setAttribute("music2", "music2");
		request.getSession().setAttribute("music3", "music3");
		request.getSession().setAttribute("music4", "music4");
	}

	private void addMovieItems(HttpServletRequest request) {
		request.getSession().setAttribute("movie1", "movie1");
		request.getSession().setAttribute("movie2", "movie2");
		request.getSession().setAttribute("movie3", "movie3");
		request.getSession().setAttribute("movie4", "movie4");
	}

	private void addComedyItems(HttpServletRequest request) {
		request.getSession().setAttribute("comedy1", "comedy1");
		request.getSession().setAttribute("comedy2", "comedy2");
		request.getSession().setAttribute("comedy3", "comedy3");
		request.getSession().setAttribute("comedy4", "comedy4");
	}

	private void checkLogin(HttpServletRequest request) {
		if (!(request.getParameter("login") == null)) {
			this.page = this.mainPage;
			String username = request.getParameter("username");
			String password = request.getParameter("password");
			request.getSession().setAttribute("loggedin", "1");
			request.getSession().setAttribute("adminloggedin", "1");
			// System.out.println("inputted username: " + username + " password: " +
			// password);
			// check if the account is admin if so set -
			// request.getSession().setAttribute("adminloggedin", "1")
			// check id, pass, and if admin or not
		}
	}

	private void checkRegister(HttpServletRequest request) {
		if (!(request.getParameter("register") == null)) {
			this.page = this.loginPage;
			int adminreg = 0;
			String usernameRegister = request.getParameter("usernameregister");
			String passwordRegister = request.getParameter("passwordregister");
			if (!(request.getParameter("adminregister") == null)) {
				adminreg = 1;
			}
			// send usernameRegister, passwordRegister, adminreg to database here
		}
	}

	private void checkLogout(HttpServletRequest request) {
		if (!(request.getParameter("logout") == null)) {
			this.page = this.mainPage;
			request.getSession().setAttribute("loggedin", "0");
			request.getSession().setAttribute("adminloggedin", "0");
		}
	}

	private void checkAddItem(HttpServletRequest request) {
		if (!(request.getParameter("additem") == null)) {
			this.page = this.adminPage;
		}
	}

	private void checkInformation(HttpServletRequest request) {
		if (!(request.getParameter("checkinformation") == null)) {
			this.page = this.adminPage;
			request.getSession().setAttribute("orderinformation", "Order ID, Email, Total, Date of Delivery");
		} else {
			request.getSession().setAttribute("orderinformation", "");
		}
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
