package web_study_10.dao;

import java.util.List;

import web_study_10.dto.Department;

public interface DeptDao {
	List<Department> SelectDeptByAll();
	
	int getNextNo();
	
	int insertDept(Department dept);
	
	Department SelectDeptByNo(Department dept);
	
	int deleteDept(Department dept);
	
	int updateDept(Department dept);
	
}
