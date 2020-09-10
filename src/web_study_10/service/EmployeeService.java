package web_study_10.service;

import java.util.List;

import web_study_10.dao.EmployeeDao;
import web_study_10.dao.impl.EmployeeDaoImpl;
import web_study_10.dto.Employee;

public class EmployeeService {
	EmployeeDao dao = EmployeeDaoImpl.getInstance();
	
	public List<Employee> getAllEmp() {
		return dao.selectEmpByAll();
	}
	
	public int addEmp(Employee emp) {
		return dao.insertEmployee(emp);
	}
}
