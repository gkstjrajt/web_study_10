package web_study_10.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import web_study_10.dao.DeptDao;
import web_study_10.ds.JndiDS;
import web_study_10.dto.Department;
import web_study_10.exception.CustomSQLException;

public class DeptDaoImpl implements DeptDao {
	private static final DeptDaoImpl instance = new DeptDaoImpl();
	
	private DeptDaoImpl() {}
	
	public static DeptDaoImpl getInstance() {
		return instance;
	}



	@Override
	public List<Department> SelectDeptByAll() {
		String sql = "SELECT DEPT_NO, DEPT_NAME, DEPT_FLOOR FROM DEPARTMENT ORDER BY DEPT_NO";
		try(Connection con = JndiDS.getConnection();
				PreparedStatement pstmt = con.prepareStatement(sql)){
				ResultSet rs = pstmt.executeQuery();
			if(rs.next()) {
				List<Department> list = new ArrayList<Department>();
				do {
					list.add(getDepartment(rs));
				} while(rs.next());
				return list;
			}
		} catch (SQLException e) {
			throw new CustomSQLException(e);
		}
		return null;
	}

	private Department getDepartment(ResultSet rs) throws SQLException {
		int deptNo = rs.getInt("DEPT_NO");
		String deptName = rs.getString("DEPT_NAME");
		int deptFloor = rs.getInt("DEPT_FLOOR");
		return new Department(deptNo, deptName, deptFloor);
	}

	@Override
	public int getNextNo() {
		String sql = "SELECT MAX(DEPT_NO)+1 FROM DEPARTMENT";
		try(Connection con = JndiDS.getConnection();
				PreparedStatement pstmt = con.prepareStatement(sql)){
				ResultSet rs = pstmt.executeQuery();
			if(rs.next()) {
				return rs.getInt(1);
			}
		} catch (SQLException e) {
			throw new CustomSQLException(e);
		}
		return 0;
	}
	
	@Override
	public int insertDept(Department dept) {
		String sql = "INSERT INTO DEPARTMENT VALUES(?, ?, ?)";
		try(Connection con = JndiDS.getConnection();
				PreparedStatement pstmt = con.prepareStatement(sql) ){
					pstmt.setInt(1, dept.getDeptNo());
					pstmt.setString(2, dept.getDeptName());
					pstmt.setInt(3, dept.getDeptFloor());
			return pstmt.executeUpdate();
		} catch (SQLException e) {
			throw new CustomSQLException(e);
		}
	}

	@Override
	public Department SelectDeptByNo(Department dept) {
		String sql = "SELECT DEPT_NO, DEPT_NAME, DEPT_FLOOR FROM DEPARTMENT WHERE DEPT_NO = ?";
		try(Connection con = JndiDS.getConnection();
				PreparedStatement pstmt = con.prepareStatement(sql)){
					pstmt.setInt(1, dept.getDeptNo());	
			try(ResultSet rs = pstmt.executeQuery()){
				if(rs.next()) {
					return getDepartment(rs);
				}
			}
		} catch (SQLException e) {
			throw new CustomSQLException(e);
		}
		return null;
	}

	@Override
	public int deleteDept(Department dept) {
		String sql = "DELETE FROM DEPARTMENT WHERE DEPT_NO = ?";
		try(Connection con = JndiDS.getConnection();
				PreparedStatement pstmt = con.prepareStatement(sql)){
					pstmt.setInt(1, dept.getDeptNo());
				return pstmt.executeUpdate();
		} catch (SQLException e) {
			throw new CustomSQLException(e);
		}
	}

	@Override
	public int updateDept(Department dept) {
		String sql = "UPDATE DEPARTMENT SET DEPT_NAME = ?, DEPT_FLOOR = ? WHERE DEPT_NO = ?";
		try(Connection con = JndiDS.getConnection();
				PreparedStatement pstmt = con.prepareStatement(sql)){
					pstmt.setString(1, dept.getDeptName());
					pstmt.setInt(2, dept.getDeptFloor());
					pstmt.setInt(3, dept.getDeptNo());
				return pstmt.executeUpdate();
		} catch (SQLException e) {
			throw new CustomSQLException(e);
		}
	}

}
