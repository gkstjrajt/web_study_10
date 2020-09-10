package web_study_10.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import web_study_10.dao.EmployeeDao;
import web_study_10.ds.JndiDS;
import web_study_10.dto.Department;
import web_study_10.dto.Employee;
import web_study_10.dto.Title;
import web_study_10.exception.CustomSQLException;

public class EmployeeDaoImpl implements EmployeeDao {
	private static final EmployeeDaoImpl instance = new EmployeeDaoImpl();
	
	private EmployeeDaoImpl() {}

	public static EmployeeDaoImpl getInstance() {
		return instance;
	}


	@Override
	public List<Employee> selectEmpByAll() {
		String sql = "SELECT EMP_NO, EMP_NAME, TNO, MANAGER, SALARY, DNO, REGDATE, EMAIL, TEL, TITLE_NAME, DEPT_NAME, MANAGER_NAME FROM VW_EMPLOYEE_JOIN";
		try(Connection con = JndiDS.getConnection();
				PreparedStatement pstmt = con.prepareStatement(sql)){
				ResultSet rs = pstmt.executeQuery();
			if(rs.next()) {
				List<Employee> list = new ArrayList<Employee>();
				do {
					list.add(getEmployee(rs));
				} while(rs.next());
				return list;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	private Employee getEmployee(ResultSet rs) throws SQLException {
		// EMP_NO, EMP_NAME, TNO, MANAGER, SALARY, DNO, REGDATE, EMAIL, TEL, TITLE_NAME, DEPT_NAME, MANAGER_NAME
		// EMP_NO, EMP_NAME, TNO, MANAGER, SALARY, DNO, REGDATE, EMAIL, TEL, PASSWD, PIC_URL, TITLE_NAME, DEPT_NAME, MANAGER_NAME
		int empNo = rs.getInt("EMP_NO");
		String empName = rs.getString("EMP_NAME");
		Title title = new Title(rs.getInt("TNO"), rs.getString("TITLE_NAME"));
		Employee manager = new Employee(rs.getInt("MANAGER"), rs.getString("MANAGER_NAME"));
		int salary = rs.getInt("SALARY");
		Department dept = new Department(rs.getInt("DNO"), rs.getString("DEPT_NAME"));
		String email = rs.getString("EMAIL");
		Date regDate = rs.getTimestamp("REGDATE");
		String tel = rs.getString("TEL");
		return new Employee(empNo, empName, title, manager, salary, dept, email, regDate, tel);
	}

	@Override
	public int insertEmployee(Employee emp) {
		String sql = "INSERT INTO VW_EMPLOYEE_JOIN(EMP_NO, EMP_NAME, TNO, MANAGER, SALARY, DNO, EMAIL, TEL, PASSWD) VALUES(?, ?, ?, ?, ?, ?, ?, ?, ?)";
		try(Connection con = JndiDS.getConnection();
				PreparedStatement pstmt = con.prepareStatement(sql)){
					pstmt.setInt(1, emp.getEmpNo());
					pstmt.setString(2, emp.getEmpName());
					pstmt.setInt(3, emp.getTitle().getTitleNo());
					pstmt.setInt(4, emp.getManager().getEmpNo());
					pstmt.setInt(5, emp.getSalary());
					pstmt.setInt(6, emp.getDept().getDeptNo());
					pstmt.setString(7, emp.getEmail());
					pstmt.setString(8, emp.getTel());
					pstmt.setString(9, emp.getPasswd());
			return pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return 0;
	}


}
