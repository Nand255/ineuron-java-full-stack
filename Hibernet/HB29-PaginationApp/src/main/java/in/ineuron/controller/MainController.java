package in.ineuron.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.hibernate.HibernateException;

import in.ineuron.dto.InsurancePolicyDTO;
import in.ineuron.service.InsurancePolicyService;
import in.ineuron.service.InsurancePolicyServiceImpl;

@WebServlet(urlPatterns = "/controller", loadOnStartup = 1)
public class MainController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public MainController() {
		
	}
	
	private InsurancePolicyService service;
	
	@Override
	public void init() throws ServletException {
		service = new InsurancePolicyServiceImpl();
	}
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		int pageNo = 0;
		int pageSize = 0;
		List<InsurancePolicyDTO> listDto = null;
		String targetPage = null;
		RequestDispatcher rd = null;
		long pageCount = 0L;
		HttpSession session = null;
		
		String value = request.getParameter("s1");
		session = request.getSession(true);
		
		if (value.equalsIgnoreCase("generatereport")) {
			// Get the value from the button
			pageSize = Integer.parseInt(request.getParameter("pageSize"));
			pageNo = 1;
			if (session != null) 
				session.setAttribute("pageSize", pageSize);
			
		} else {
			//Getting the value from the hyperlink
			pageNo = Integer.parseInt(request.getParameter("pageNo"));
			if (session != null) 
				pageSize = (int) session.getAttribute("pageSize");
		}
		
		try {
			pageCount = service.fetchPageCount(pageSize);
			listDto = service.fetchPageData(pageSize, pageNo);
			
			request.setAttribute("policiesList", listDto);
			request.setAttribute("pageCount", pageCount);
			request.setAttribute("pageNo", pageNo);
			
			targetPage = "./report.jsp";
			
		} catch (HibernateException he) {
			he.printStackTrace();
			targetPage = "./error.jsp";
		}
		catch (Exception e) {
			e.printStackTrace();
			targetPage = "./error.jsp";
		}
		
		rd = request.getRequestDispatcher(targetPage);
		rd.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

	@Override
	public void destroy() {
		
	}
	
}
