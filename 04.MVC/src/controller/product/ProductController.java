package controller.product;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.product.ProductDao;
import dao.product.ProductDaoImpl;
import model.product.Product;

@WebServlet(name="ProductController", 
	urlPatterns= {"/product_input", "/product_save", "/product_search", "/product_detail", "/product_update", "/product_delete"})
public class ProductController extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("UTF-8");
		process(req,resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("UTF-8");
		process(req,resp);
	}
	
	private void process(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		String uri = req.getRequestURI();
		System.out.println(uri);
		
		int lastIndex = uri.lastIndexOf("/");
		System.out.println(lastIndex);
		
		String action = uri.substring(lastIndex+1);
		System.out.println(action);
		
		if(action.equals("product_input")) {
		}
		else if(action.equals("product_save")) {
			
			String name = req.getParameter("name");
			String description = req.getParameter("description");
			int price = Integer.parseInt(req.getParameter("price"));
			
			Product product = new Product(name,description,price);
			
			ProductDao dao = new ProductDaoImpl();
			dao.insert(product);
			
			List<Product> productList = dao.selectAll();
			
			req.setAttribute("productList", productList);
			
		}
//		else if(action.equals("product_search")) {
//			
//			ProductDao dao = new ProductDaoImpl();
//			List<Product> productList = dao.selectAll();
//			
//			req.setAttribute("productList", productList);
//			
//		}
		else if(action.equals("product_detail")) {
			
			int productid = Integer.parseInt(req.getParameter("productid")); //화면에서 가져와
			
			ProductDao dao = new ProductDaoImpl();
			
			Product product = dao.selectByProductid(productid);
			
			req.setAttribute("productDetail", product);
			
		}
		else if(action.equals("product_update")) {
			
			int productid = Integer.parseInt(req.getParameter("productid"));
			String name = req.getParameter("name");
			String description = req.getParameter("description");
			int price = Integer.parseInt(req.getParameter("price"));
			
			Product product = new Product(productid, name, description, price);
			
			ProductDao dao = new ProductDaoImpl();
			dao.update(product);
			
			List<Product> productList = dao.selectAll();
			
			req.setAttribute("productList", productList);
			
		}
		else if(action.equals("product_delete")) {
			
			int productid = Integer.parseInt(req.getParameter("productid")); //화면에서 가져와
			
			ProductDao dao = new ProductDaoImpl();
			dao.delete(productid);
			
			List<Product> productList = dao.selectAll();
			
			req.setAttribute("productList", productList);
			
		}
		
		String dispatcherUrl = null;
		
		if(action.equals("product_input")) {
			dispatcherUrl = "jsp2/product/productSave2.jsp";
		}
		else if(action.equals("product_save")) {
			
			dispatcherUrl = "jsp2/product/list.jsp";
		}
		else if(action.equals("product_detail")) {
			
			dispatcherUrl = "jsp2/product/detail.jsp";
		}
		else if(action.equals("product_update")) {
			
			dispatcherUrl = "jsp2/product/list.jsp";
		}
		else if(action.equals("product_delete")) {
			
			dispatcherUrl = "jsp2/product/list.jsp"; 
		}
		
		RequestDispatcher dispatcher = req.getRequestDispatcher(dispatcherUrl);
		dispatcher.forward(req, resp);
	}
}
