package web_study_10.dao.test;

import java.sql.Connection;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;

import web_study_10.dao.EmployeeDao;
import web_study_10.dao.impl.EmployeeDaoImpl;
import web_study_10.ds.JndiDS;
import web_study_10.dto.Employee;

public class EmployeeDaoTest {
	private EmployeeDao dao = EmployeeDaoImpl.getInstance();
	
	@Test
	public void testSelectEmpByAll() {
		System.out.println("testSelectEmpByAll");
		List<Employee> list = dao.selectEmpByAll();
		Assert.assertNotNull(list);
		list.stream().forEach(System.out::println);
	}

}
