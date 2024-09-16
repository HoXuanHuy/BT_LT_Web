package webhxh.controller;

import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import webhxh.dao.impl.UserDaoImpl;
import webhxh.model.UserModel;

@WebServlet(urlPatterns = { "/forgot" })
public class Forgotcontroller extends HttpServlet {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		resp.setCharacterEncoding("UTF-8");
		req.setCharacterEncoding("UTF-8");
		resp.setContentType("text/html");
		
		String username = req.getParameter("username");
		String email = req.getParameter("email");
//		String npassword = req.getParameter("npassword");
		
		UserDaoImpl userDao = new UserDaoImpl();
		
		UserModel user= userDao.findByUsername(username);
		if (user!=null) {
			if (user.getEmail().equals(email)&&user.getUsername().equals(username)) {
//				if(userDao.changepassword(username, npassword)!=null) {
//				req.getRequestDispatcher("/views/login.jsp").forward(req, resp);
//				return;
//				}
				
				HttpSession session = req.getSession(true);
				session.setAttribute("account", user);
				req.getRequestDispatcher("/views/changepsw.jsp").forward(req, resp);
				return;
			}
			else {
				String alertMsg = "username and email not matched!";
				req.setAttribute("alert", alertMsg);
				req.getRequestDispatcher("/views/forgotpsw.jsp").forward(req, resp);
				return;
			}
		}
		else {
			String alertMsg = "Not exist username";
			req.setAttribute("alert", alertMsg);
			req.getRequestDispatcher("/views/forgotpsw.jsp").forward(req, resp);
			return;
		}
	}
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(req, resp);
	}
	

}
