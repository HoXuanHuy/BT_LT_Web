package webhxh.controller;

import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import webhxh.dao.impl.UserDaoImpl;
import webhxh.model.UserModel;

@WebServlet(urlPatterns = { "/signup" })
public class Signupcontroller extends HttpServlet {
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
		
		String fullname = req.getParameter("fullname");
		String username = req.getParameter("username");
		String email = req.getParameter("email");
		String password = req.getParameter("password");
		String phone = req.getParameter("phone");
		String roleidstr = req.getParameter("roleid");
		int roleid = Integer.parseInt(roleidstr);
		
		String alertMsg = "";
		
		UserDaoImpl userDao = new UserDaoImpl();
		
		if (userDao.CheckUserExist(username) == true) {
			alertMsg = "Username exist!";
			req.setAttribute("alert", alertMsg);
			req.getRequestDispatcher("/views/signup.jsp").forward(req, resp);
			return;

		}

		if (userDao.CheckEmailExist(email) == true) {
			alertMsg = "Email exist!";
			req.setAttribute("alert", alertMsg);
			req.getRequestDispatcher("/views/signup.jsp").forward(req, resp);
			return;
		}

		userDao.insert(new UserModel(fullname,username,email,password,null, phone,roleid, null));
		req.getRequestDispatcher("/views/login.jsp").forward(req, resp);
		return;
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(req, resp);
	}

}
