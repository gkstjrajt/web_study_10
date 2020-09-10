package web_study_10.service;

import java.util.List;

import web_study_10.dao.DeptDao;
import web_study_10.dao.impl.DeptDaoImpl;
import web_study_10.dto.Department;

public class DeptService {
	private DeptDao dao = DeptDaoImpl.getInstance();
	
	public List<Department> SelectDeptByAll(){
		return dao.SelectDeptByAll();
	}
	
	public int getNextNo() {
		return dao.getNextNo();
	}
	
	public int addDept(Department dept) {
		return dao.insertDept(dept);
	}
	
	public Department selectDeptByNo(Department dept) {
		return dao.SelectDeptByNo(dept);
	}
	
	public int removeDept(Department dept) {
		return dao.deleteDept(dept);
	}
	
	public int modifyDept(Department dept) {
		return dao.updateDept(dept);
	}
}
