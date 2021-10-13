package el.servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import el.model.Address;
import el.model.Employee;

@WebServlet(urlPatterns= {"/elTest"})
public class ElTestServlet extends HttpServlet{

	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		
		//1-1 객체생성
		Address address = new Address();
		address.setStreetName("언주로");
		address.setStreetNumber("5090B");
		address.setCity("유성구");
		address.setState("서울특별시");
		address.setZipcode("12345");
		address.setCountry("대한민국");
		
		request.setAttribute("addr", address);
		
		//1-2 다른 객체를 참조하는 객체생성
		Employee employee = new Employee();
		employee.setId(1);
		employee.setName("일순이");
		employee.setAddress(address);

		request.setAttribute("emp", employee);
		
		//2-1
		Map<String, String> capitals = new HashMap<String, String>();
		capitals.put("china", "베이징");
		capitals.put("korea", "서울");
		
		request.setAttribute("cap", capitals);
		
		//2-2
		Map<String, Employee> empMap = new HashMap();
		empMap.put("e", employee);
		
		request.setAttribute("empInfo", empMap);
		
		//3-1 배열
		int[] intArray = {1,2,3,5};
		
		request.setAttribute("iArray", intArray);
		
		//3-2 객체배열
		Employee emp01 = new Employee();
		emp01.setId(2);
		emp01.setName("어돌이");
		emp01.setAddress(address);
		
		Employee emp02 = new Employee();
		emp02.setId(3);
		emp02.setName("삼순이");
		emp02.setAddress(address);
		
		Employee[] empArray = {emp01, emp02};
		
		request.setAttribute("eArray", empArray);
		
		//4-1 리스트
		List<String> stringList = new ArrayList<>();
		stringList.add("a");
		stringList.add("b");
		stringList.add("c");
		
		request.setAttribute("strList", stringList);
		
		//4-2 객체리스트
		List<Employee> empList = new ArrayList<>();
		empList.add(emp01);
		empList.add(emp02);
		
		request.setAttribute("empList", empList);
		
		
		
		
		RequestDispatcher dispatcher = request.getRequestDispatcher("/01-employee.jsp");
		dispatcher.forward(request, response);
		
		
	}
	
}
