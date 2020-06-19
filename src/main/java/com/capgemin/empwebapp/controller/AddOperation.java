package com.capgemin.empwebapp.controller;
import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.capgemini.empwebapp.dao.EmployeeDAO;
import com.capgemini.empwebapp.dao.EmployeeDAOImpl;
import com.capgemini.empwebapp.dto.EmployeeBean;

@SuppressWarnings("serial")
@WebServlet("/addEmployee")
public class AddOperation extends HttpServlet {
	@SuppressWarnings("unused")
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String id=req.getParameter("empId");
		String firstname=req.getParameter("empName");
		String designation=req.getParameter("designation");
		
		EmployeeBean demo=new EmployeeBean();
		demo.setEid(Integer.parseInt(id));
		demo.setEname(firstname);
		demo.setDesignation(designation);
		EmployeeDAO dao=new EmployeeDAOImpl();
		dao.addEmployee(demo);
		boolean check= dao.addEmployee(demo);

	}

}

