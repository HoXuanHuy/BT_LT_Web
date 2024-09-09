package hello123.controller;

import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet(urlPatterns = { "/home", "/trangchu" })
public class hellocontroller extends HttpServlet {

	private static final long serialVersionUID = 148295057574120606L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		resp.setContentType("text/html");
		String ten1 = req.getParameter("ten");
		String ho1 = req.getParameter("ho");

		//dua du lieu ra view
		req.setAttribute("fname", ten1);
		req.setAttribute("lname", ho1);
		RequestDispatcher rd = req.getRequestDispatcher("/view/login.jsp");

		rd.forward(req, resp);

//		PrintWriter printW = resp.getWriter();
//		printW.print(ho1+" "+ten1);
//		printW.close();

	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(req, resp);
	}

}
