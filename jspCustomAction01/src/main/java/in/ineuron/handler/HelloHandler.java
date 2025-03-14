package in.ineuron.handler;

import java.io.IOException;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.PageContext;
import javax.servlet.jsp.tagext.Tag;

public class HelloHandler implements Tag {
	
	PageContext pageContext ;
	private String name;
	
	public String getName() {
		System.out.println("HelloHandler.getName()");
		return name;
	}

	public void setName(String name) {
		System.out.println("HelloHandler.setName()");
		this.name = name;
	}

	static {
		System.out.println("HelloHandler.class file is loading...");
	}
	
	public HelloHandler() {
		System.out.println("HelloHandler object is instantiated...");
	}
	
	@Override
	public int doEndTag() throws JspException {
		System.out.println("HelloHandler.doEndTag()");
		return EVAL_PAGE;
	}

	@Override
	public int doStartTag() throws JspException {
		System.out.println("HelloHandler.doStartTag()");
		try {
			JspWriter out = pageContext.getOut();
			out.println("<h1>Hello this from tag handler class</h1>");
			
			if(name == null) 
				System.out.println("Hello guest");
			else
				System.out.println("hello"+name);
		} catch (IOException e) {
			e.printStackTrace();
		}
		return EVAL_BODY_INCLUDE;
	}

	@Override
	public Tag getParent() {
		System.out.println("HelloHandler.getParent()");
		return null;
	}

	@Override
	public void release() {
		System.out.println("HelloHandler.release()");
	}

	@Override
	public void setPageContext(PageContext pageContext) {
		System.out.println("HelloHandler.setPageContext()");
		this.pageContext = pageContext;
	}

	@Override
	public void setParent(Tag arg0) {
		System.out.println("HelloHandler.setParent()");
	}

}
