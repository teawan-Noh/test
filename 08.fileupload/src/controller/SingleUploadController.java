package controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

@WebServlet(urlPatterns= {"/singleUpload"})
@MultipartConfig
public class SingleUploadController extends HttpServlet {

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("UTF-8");
		
		Part part = req.getPart("filename");
		String fileName = getFileName(part);
		
		if(fileName != null && !fileName.isEmpty()) {
//		part.write(getServletContext().getRealPath("/WEB-INF")+ "/" + fileName);
//		System.out.println(getServletContext().getRealPath("/WEB-INF"));
		//1.������ �����̸��� �����.
		//2.������ �̸����� fileserver�� ������ �����Ѵ�.
		part.write("C:/fileserver/" + fileName);
		//3.DB�� �Ʒ��� ���� ������ �����Ѵ�.
		System.out.println(part.getSize());
		
		}
		//DB: �ۼ���, �ۼ���, �������� �����̸�, ������ �����̸�("AFAFDF9873FDSDFAFSD.png"), ���ϻ����� �� ����
		//���ϼ����� ������ ����Ǿ� �־�� �Ѵ�. AFAFDF9873FDSDFAFSD.png
	}

	private String getFileName(Part part) {
		String contentDispositionHeader = part.getHeader("content-disposition");
//		System.out.println(contentDispositionHeader); //form-data; name="filename"; filename="ĸó22222.JPG"
//		������Ʈ part header�� content-disposition�� ���ε�� �����̸��� ������ �ִ� 
//		�����̸� ������
		String[] elements = contentDispositionHeader.split(";");
		
		for (String element : elements) {
			if(element.trim().startsWith("filename")) {
//				filename="ĸó22222.JPG"
				System.out.println(element.substring(element.indexOf("=")+2, element.length()-1));
				return element.substring(element.indexOf("=")+2, element.length()-1);
			}
			
		}
		return null;
	}
}
