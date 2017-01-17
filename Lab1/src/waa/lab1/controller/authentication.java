package waa.lab1.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import waa.lab1.model.User;
import waa.lab1.service.AuthenticationService;

/**
 * Servlet implementation class authentication
 */
@WebServlet("/authentication")
public class authentication extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public authentication() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//doGet(request, response);
		HttpSession session=request.getSession();
		
		User user = new User();
		
		String logInUsername = request.getParameter("txtUsername");
		String logInPassword = request.getParameter("txtPassword");
		
		user.setUsername(logInUsername);
		user.setPassword(logInPassword);
		
		AuthenticationService as = new AuthenticationService();
		
		boolean flag = false;
		try{
			flag = as.authenticateLogin(user);
			if(flag){
				session.setAttribute("userName", user.getUsername());
				session.setAttribute("passWord", user.getPassword());
				request.getRequestDispatcher("welcome.jsp").forward(request, response);
			}else{
				request.setAttribute("msgLoginFailed", "Username and/or Password Incorrect.");
				request.getRequestDispatcher("login.jsp").forward(request, response);
			}
		}catch(Exception e){
			e.printStackTrace();
		}
		
	}

}
