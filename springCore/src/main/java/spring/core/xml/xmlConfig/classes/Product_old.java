package spring.core.xml.xmlConfig.classes;

import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.context.ApplicationContext;

public class Product_old extends HttpServlet{
    private   LearnSpring learnSpring;
	/**
	 * 
	 */
	private static final long serialVersionUID = -9132076516736359156L;

	@Override
	public void init() throws ServletException {
		// TODO Auto-generated method stub
		super.init();
	           ServletContext config=getServletConfig().getServletContext();
		ApplicationContext ac = (ApplicationContext) getServletContext().getAttribute("applicationContextData");
	
                 learnSpring=LearnSpring.getInstance(ac);
             
             
	}
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
	doPost(req, resp);
	}
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {

		
		
		learnSpring.listProducts();
		req.setAttribute("productList", learnSpring.getList());
                req.setAttribute("productNames", learnSpring.getNames());
		req.getRequestDispatcher("Product.jsp").forward(req, resp);
//	
	}

}
