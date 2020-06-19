package com.capgemin.empwebapp.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ReadOperation extends HttpServlet {
	 protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			 throws ServletException, IOException {
		 	// TODO Auto-generated method stub
			 req.getRequestDispatcher("showusers.jsp").forward(req, resp);
	}
}
