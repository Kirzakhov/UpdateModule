package com.vivek;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.vivek.duo.UpdateDuo;

@WebServlet("/Update")
public class Update extends HttpServlet{
	public void doGet(HttpServletRequest req, HttpServletResponse res) throws IOException {
		PrintWriter out = res.getWriter();
		String un = req.getParameter("uname");
		String up = req.getParameter("pass");
		UpdateDuo ud = new UpdateDuo();
		int i = ud.update(un, up);
		if(i>0)
			out.println("Record Updated");
		else
			out.println("User with given username doesn't exist");
	}
}
