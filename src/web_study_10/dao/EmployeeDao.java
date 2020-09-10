package web_study_10.dao;

import java.util.List;

import web_study_10.dto.Employee;

public interface EmployeeDao {
	List<Employee> selectEmpByAll();
	
	int insertEmployee(Employee emp);
}
