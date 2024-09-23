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

@WebServlet(urlPatterns = { "/changepass" })
public class changepswcontroller extends HttpServlet {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	UserDaoImpl userDao = new UserDaoImpl();
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String alertMsg = "";
		HttpSession session = req.getSession(false);
		if (session != null && session.getAttribute("account1") != null) {
			UserModel u = (UserModel) session.getAttribute("account1");
//			req.setAttribute("username", u.getUsername());
			
			String username = u.getUsername();
			String npassword = req.getParameter("npassword");
			String cfpassword=req.getParameter("confirm-password");
			
			if (!npassword.equals(cfpassword)) {
				alertMsg = "Password not matched!";
				req.setAttribute("alert", alertMsg);
				req.getRequestDispatcher("/views/changepsw.jsp").forward(req, resp);
				return;
			}
			
			
			if(userDao.changepassword(username, npassword)!=null) {
			req.getRequestDispatcher("/views/login.jsp").forward(req, resp);
			return;
			}
		} else {
			resp.sendRedirect(req.getContextPath() + "/forgotpsw");
		}
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(req, resp);
	}

}
