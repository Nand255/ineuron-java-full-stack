package in.ineuron.controller;
import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import in.ineuron.dto.Student;
import in.ineuron.service.IStudentService;
import in.ineuron.servicefactory.StudentServiceFactory;


@WebServlet("/controller/*")
public class ControllerServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doProcess(request,response);
	}


	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doProcess(request,response);	
	}

	private void doProcess(HttpServletRequest request, HttpServletResponse response) throws ServletException , IOException {
		
		IStudentService studentService = StudentServiceFactory.getStudentService();
		
		System.out.println("Request URI: "+request.getRequestURI());
		System.out.println("Path Info: "+request.getPathInfo());
		
		// To add student info
		if(request.getRequestURI().endsWith("addform")) {			
			
			String sage = request.getParameter("sage");
			String sname = request.getParameter("sname");
			String saddr = request.getParameter("saddr");
			
			Student student = new Student();
			student.setSname(sname);
			student.setSage(Integer.parseInt(sage));
			student.setSaddress(saddr);
			
			String status = studentService.addStudent(student);
			request.setAttribute("status", status);

			RequestDispatcher rd = null;
			rd = request.getRequestDispatcher("../insertResult.jsp");
			rd.forward(request, response);
		}
		
		//To search student
		if (request.getRequestURI().endsWith("searchform")) {
			String sid = request.getParameter("sid");
			
			Student student = studentService.searchStudent(Integer.parseInt(sid));
			request.setAttribute("student", student);
			
			RequestDispatcher rd = null;
			rd = request.getRequestDispatcher("../display.jsp");
			rd.forward(request, response);
		}
		
		//Delete operation
		if (request.getRequestURI().endsWith("deleteform")) {
			String sid = request.getParameter("sid");
			
			String status = studentService.deleteStudent(Integer.parseInt(sid));
			request.setAttribute("status", status);

			RequestDispatcher rd = null;
			rd = request.getRequestDispatcher("../deleteResult.jsp");
			rd.forward(request, response);
		}
		
		//Update Operation
		if (request.getRequestURI().endsWith("editform")) {
			String sid = request.getParameter("sid");

			Student student = studentService.searchStudent(Integer.parseInt(sid));
			
			RequestDispatcher rd = null;
			if (student != null) {
				request.setAttribute("student", student);
				rd = request.getRequestDispatcher("../updateForm.jsp");
				rd.forward(request, response);
			}
			
		}
		
		if (request.getRequestURI().endsWith("updateRecord")) {
			String sid = request.getParameter("sid");
			String sname = request.getParameter("sname");
			String sage = request.getParameter("sage");
			String saddr = request.getParameter("saddr");
			
			Student student = new Student();
			student.setSid(Integer.parseInt(sid));
			student.setSname(sname);
			student.setSage(Integer.parseInt(sage));
			student.setSaddress(saddr);
			
			String status = studentService.updateStudent(student);
			RequestDispatcher rd = null;

			request.setAttribute("status", status);
			rd = request.getRequestDispatcher("../../updateResult.jsp");
			rd.forward(request, response);

		}
	}
}
