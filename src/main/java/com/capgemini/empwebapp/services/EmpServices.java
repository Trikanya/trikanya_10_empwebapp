package com.capgemini.empwebapp.services;

import java.util.List;

import com.capgemini.empwebapp.dto.EmployeeBean;

public interface EmpServices {

	public EmployeeBean getEmployeeDetailsByname(String name);
	  public boolean deleteEmployee(int id);
	  public boolean updateEmployee(EmployeeBean bean);
	  public boolean createEmployeeInfo(EmployeeBean bean);
	  public List<EmployeeBean> getAllEmployee();

}
