package com.capgemini.empwebapp.services;

import java.util.List;

import com.capgemini.empwebapp.dao.EmployeeDAO;
import com.capgemini.empwebapp.dao.EmployeeDAOImpl;
import com.capgemini.empwebapp.dto.EmployeeBean;

public class EmpServicesImpl implements EmpServices{

		private EmployeeDAO dao=new EmployeeDAOImpl();

		@Override
		public EmployeeBean getEmployeeDetailsByname(String name) {
			// TODO Auto-generated method stub
			return null;
		}

		@Override
		public boolean deleteEmployee(int id) {
			// TODO Auto-generated method stub
			return false;
		}

		@Override
		public boolean updateEmployee(EmployeeBean bean) {
			// TODO Auto-generated method stub
			return false;
		}

		@Override
		public boolean createEmployeeInfo(EmployeeBean bean) {
			// TODO Auto-generated method stub
			return false;
		}

		@Override
		public List<EmployeeBean> getAllEmployee() {
			// TODO Auto-generated method stub
			return null;
		}

      
	}



