package app02a.httpsession.quiz;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


//JSP를 포함한 버전
@WebServlet(name = "ShoppingCartServlet", urlPatterns = {
        "/products", "/viewProductDetails", 
        "/addToCart", "/viewCart" })
public class ShoppingCart extends HttpServlet {

	private static final long serialVersionUID = -20L;
    private static final String CART_ATTRIBUTE = "cart";

    private List<Product> products = new ArrayList<Product>();
	
    
    @Override
    public void init() throws ServletException {
        products.add(new Product(1, "Bravo 32' HDTV",
                "유명 TV 제조사에서 만든 저가형 HDTV",
                150));
        products.add(new Product(2, "Bravo BluRay 플레이어",
                "세련된 고급 BluRay 플레이어", 45));
        products.add(new Product(3, "Bravo 스테레오 시스템",
                "iPod 플레이어가 탑재된 5 스피커 하이파이 시스템", 
                120));
        products.add(new Product(4, "Bravo iPod 플레이어",
                "여러 포맷을 재생할 수 있는 iPod 플러그인",
                40));
    }

    @Override
    public void doGet(HttpServletRequest request,
            HttpServletResponse response) throws ServletException,
            IOException {
    	request.setCharacterEncoding("UTF-8");
		process(request,response);
    }


	@Override
    public void doPost(HttpServletRequest request,
            HttpServletResponse response) throws ServletException,
            IOException {
		request.setCharacterEncoding("UTF-8");
		process(request,response);
    }
	
	private void process(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		String uri = req.getRequestURI();
		int lastIndex = uri.lastIndexOf("/");
		String action = uri.substring(lastIndex+1);
		
		HttpSession session = req.getSession();
		List<Product> cart = (List<Product>) session.getAttribute(CART_ATTRIBUTE);
		
		if(action.equals("products")) {
			
			req.setAttribute("productList", products);
		}
		else if(action.equals("viewProductDetails")) {
			
			int productid = Integer.parseInt(req.getParameter("id"));
			Product product = products.get(productid - 1);
			
			req.setAttribute("productDetail", product);
		}
		else if(action.equals("addToCart")) {
			String productid = req.getParameter("id");
			Product shoppingItem = null;
			
			if(cart == null) {
				cart = new ArrayList<Product>();
				session.setAttribute(CART_ATTRIBUTE, cart);
			}
			
			for (Product product : products) {
				if(Integer.toString(product.getId()).equals(productid)) {
					shoppingItem = product;
				}
			}
			cart.add(shoppingItem);
			
			req.setAttribute("productList", products);
		}
		else if(action.equals("viewCart")) {
			
			try {
				int count = cart.size();
				req.setAttribute("count", count);
				float total = 0;
				for (Product product : cart) {
					total += product.getPrice();
				}
				
				req.setAttribute("total", total);
			} catch (NullPointerException e) {
			}
			
			req.setAttribute("cartList", cart);
			
		}
		
		String dispatcherUrl = null;
		
		if(action.equals("products")) {
			dispatcherUrl = "jspProducts/products.jsp";
		}
		else if(action.equals("viewProductDetails")) {
			dispatcherUrl = "jspProducts/viewProductDetails.jsp";
		}
		else if(action.equals("addToCart")) {
			dispatcherUrl = "jspProducts/products.jsp";
		}
		else if(action.equals("viewCart")) {
			dispatcherUrl = "jspProducts/viewCart.jsp";
		}
		
		RequestDispatcher dispatcher = req.getRequestDispatcher(dispatcherUrl);
		dispatcher.forward(req, resp);
	}

    /* "/products" : 상품목록(리스트)을 화면에 보여준다.[상품이름, 가격, 상세보기(@링크:viewProductDetails로 이동)], @링크:장바구니 보기(viewCart로 이동)*/
    
    /* "/viewProductDetails" : 상세정보화면을 보여준다.[상품아이디, 상품이름, 설명, 가격, 장바구니버튼] */
    
    /* "/addToCart" : 상품들의 장바구니 버튼을 누를때만 카트에 포함
			
			[[로직]]
			1.세션객체 만들기
			2.(List<ShoppingItem>) cart = (List<ShoppingItem>) session.getAttribute(CART_ATTRIBUTE);
			3.cart == null 경우 : List<ShoppingItem> cart를 만들어 session.setAttribute(CART_ATTRIBUTE, cart);
			4.cart.add(shoppingItem);
			5.상품목록을 화면에 출력 	
    */  
    
    /* "/viewCart" : cart에 들어 있는 목록을 출력
		
			-세션에 있는 카트를 가져와 카트가 null이 아니라면 카트 내용을 출력한다.
			-수량 상품 가격 수량*가격 마지막 줄에 총구매 합계액을 출력한다.
			-금액을 출력(, 형식을 추가:선택사항)
			-맨 윗줄에 상품목록으로 갈 수 있도록 링크 걸어 놓기
    */
}