package com.capgemini.empwebapp.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;
import com.capgemini.empwebapp.dto.EmployeeBean;

public class EmployeeDAOImpl implements EmployeeDAO {
		@Override
		public EmployeeBean getEmployeeDetailsByname(String name) {
			ResultSet res = null;
			String url = "jdbc:mysql://localhost:3306/emp_db?useSSL=false&user=root&password=12345";
			String query = "select * from employee_info where name=?";
			try (Connection connection = DriverManager.getConnection(url);
					PreparedStatement preparedStatement = connection.prepareStatement(query);) {
				Class.forName("com.mysql.jdbc.Driver");

				preparedStatement.setString(1, name);
				res = preparedStatement.executeQuery();
				EmployeeBean beans = new EmployeeBean();
				if (res.next()) {
					beans.setEid(res.getInt("eid"));
					beans.setEname(res.getString("ename"));
					beans.setDob((res.getDate("dob")));
					beans.setPhone((res.getLong("phone")));
					beans.setDesignation((res.getString("designation")));
					return beans;
				} else {
					return null;
				}
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} finally {
				try {

					if (res != null) {
						res.close();
					}
				} catch (SQLException e) {
					// TODO: handle exception
				}
			}
			return null;
		}

		@Override
		public boolean deleteEmployee(int id) {
			// TODO Auto-generated method stub
					String url = "jdbc:mysql://localhost:3306/emp_db?useSSL="
							+ "false&user=root&password=12345";
					String query = "delete from employee_info where eid=?";

					try (Connection connection = DriverManager.getConnection(url);
							PreparedStatement preparedStatement = connection.prepareStatement(query);) {
						Class.forName("com.mysql.jdbc.Driver");
						preparedStatement.setInt(1, id);
						int res = preparedStatement.executeUpdate();
						if (res != 0) {
							return true;
						}
					} catch (Exception e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					return false;
				}

		@Override
		public boolean updateEmployee(EmployeeBean bean) {
			String query = "update employee_info set name=? where eid=?";
			String url = "jdbc:mysql://localhost:3306/emp_db?useSSL=false&user=root&password=12345";
			try (Connection connection = DriverManager.getConnection(url);
					PreparedStatement preparedStatement = connection.prepareStatement(query);) {
				Class.forName("com.mysql.jdbc.Driver");
				preparedStatement.setString(1, bean.getEname());
				preparedStatement.setInt(2, bean.getEid());
				int res = preparedStatement.executeUpdate();
				if (res != 0) {
					return true;
				}

			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return false;
		}


		@Override
		public boolean createEmployeeInfo(EmployeeBean bean) {
			String url = "jdbc:mysql://localhost:3306/emp_db?useSSL=false&user=root&password=12345";
			String query = "insert into employee_info values(?,?,?,?,?,?,?)";
			try (Connection connection = DriverManager.getConnection(url);
					
					PreparedStatement preparedStatement = connection.prepareStatement(query);) {
				Class.forName("com.mysql.jdbc.Driver");
				preparedStatement.setInt(1, bean.getEid());
				preparedStatement.setString(2, bean.getEname());
				preparedStatement.setLong(3, bean.getPhone());
				
				preparedStatement.setDate(4, bean.getDob());
				preparedStatement.setString(5, bean.getDesignation());
				preparedStatement.setDouble(9, bean.getSal());
				
				preparedStatement.setDate(11, bean.getDoj());
				preparedStatement.setLong(10, bean.getDeptid());	

				int res = preparedStatement.executeUpdate();

				if (res != 0) {
					return true;
				}

			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return false;
		}

		@Override
		public List<EmployeeBean> getAllEmployee() {
			String url = "jdbc:mysql://localhost:3306/emp_db?useSSL=false&user=root&password=12345";
			String query = "select * from employee_info ";

			List<EmployeeBean> empList = new LinkedList<EmployeeBean>();
			try (Connection connection = DriverManager.getConnection(url);
					PreparedStatement preparedStatement = connection.prepareStatement(query);
					ResultSet res = preparedStatement.executeQuery();) {
				Class.forName("com.mysql.jdbc.Driver");
				while (res.next()) {
					EmployeeBean beans = new EmployeeBean();
					beans.setEid(res.getInt("eid"));
					beans.setEname(res.getString("ename"));
					beans.setPhone(res.getLong("phone"));
					beans.setDob(res.getDate("dob"));
					beans.setDesignation(res.getString("designation"));
					beans.setDoj(res.getDate("doj"));
					beans.setSal(res.getLong("sal"));
					beans.setDeptid(res.getInt("deptid"));
					empList.add(beans);
				}

				if (empList.isEmpty()) {
					return null;
				} else {
					return empList;
				}
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} 
			return null;
		}

		@Override
		public boolean addEmployee(EmployeeBean bean) {
			// TODO Auto-generated method stub
			return false;
		}
		
	}


   

