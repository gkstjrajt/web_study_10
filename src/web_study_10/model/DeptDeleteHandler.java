package web_study_10.model;

import java.io.IOException;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import web_study_10.dto.Department;
import web_study_10.service.DeptService;

@WebServlet("/DeptDeleteHandler")
public class DeptDeleteHandler extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private DeptService service;
	
	public void init(ServletConfig config) throws ServletException {
		service = new DeptService();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		process(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		process(request, response);
	}

	private void process(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		if(request.getMethod().equalsIgnoreCase("GET")) {
			System.out.println("GET");
			int deptNo = Integer.parseInt(request.getParameter("deptNo").trim());
			int res = service.removeDept(new Department(deptNo));
			
			response.getWriter().print(res);
		} else {
			System.out.println("POST");
		}
	}

}
