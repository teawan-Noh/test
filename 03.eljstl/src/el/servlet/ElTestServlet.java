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
		
		//1-1 ��ü����
		Address address = new Address();
		address.setStreetName("���ַ�");
		address.setStreetNumber("5090B");
		address.setCity("������");
		address.setState("����Ư����");
		address.setZipcode("12345");
		address.setCountry("���ѹα�");
		
		request.setAttribute("addr", address);
		
		//1-2 �ٸ� ��ü�� �����ϴ� ��ü����
		Employee employee = new Employee();
		employee.setId(1);
		employee.setName("�ϼ���");
		employee.setAddress(address);

		request.setAttribute("emp", employee);
		
		//2-1
		Map<String, String> capitals = new HashMap<String, String>();
		capitals.put("china", "����¡");
		capitals.put("korea", "����");
		
		request.setAttribute("cap", capitals);
		
		//2-2
		Map<String, Employee> empMap = new HashMap();
		empMap.put("e", employee);
		
		request.setAttribute("empInfo", empMap);
		
		//3-1 �迭
		int[] intArray = {1,2,3,5};
		
		request.setAttribute("iArray", intArray);
		
		//3-2 ��ü�迭
		Employee emp01 = new Employee();
		emp01.setId(2);
		emp01.setName("���");
		emp01.setAddress(address);
		
		Employee emp02 = new Employee();
		emp02.setId(3);
		emp02.setName("�����");
		emp02.setAddress(address);
		
		Employee[] empArray = {emp01, emp02};
		
		request.setAttribute("eArray", empArray);
		
		//4-1 ����Ʈ
		List<String> stringList = new ArrayList<>();
		stringList.add("a");
		stringList.add("b");
		stringList.add("c");
		
		request.setAttribute("strList", stringList);
		
		//4-2 ��ü����Ʈ
		List<Employee> empList = new ArrayList<>();
		empList.add(emp01);
		empList.add(emp02);
		
		request.setAttribute("empList", empList);
		
		
		
		
		RequestDispatcher dispatcher = request.getRequestDispatcher("/01-employee.jsp");
		dispatcher.forward(request, response);
		
		
	}
	
}
