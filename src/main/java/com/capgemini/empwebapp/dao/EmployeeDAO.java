package com.capgemini.empwebapp.dao;
import java.util.List;

import com.capgemini.empwebapp.dto.EmployeeBean;
public interface EmployeeDAO {
	  public EmployeeBean getEmployeeDetailsByname(String name);
	  public boolean deleteEmployee(int id);
	  public boolean updateEmployee(EmployeeBean bean);
	  public boolean createEmployeeInfo(EmployeeBean bean);
	  public boolean addEmployee(EmployeeBean bean);
	  public List<EmployeeBean> getAllEmployee();
	}



