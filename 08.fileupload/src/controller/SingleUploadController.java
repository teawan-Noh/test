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
		//1.우일한 파일이름을 만든다.
		//2.유일한 이름으로 fileserver에 파일을 저장한다.
		part.write("C:/fileserver/" + fileName);
		//3.DB에 아래와 같은 정보를 저장한다.
		System.out.println(part.getSize());
		
		}
		//DB: 작성자, 작성일, 오리지널 파일이름, 유일한 파일이름("AFAFDF9873FDSDFAFSD.png"), 파일사이즈 등 저장
		//파일서버에 파일이 저장되어 있어야 한다. AFAFDF9873FDSDFAFSD.png
	}

	private String getFileName(Part part) {
		String contentDispositionHeader = part.getHeader("content-disposition");
//		System.out.println(contentDispositionHeader); //form-data; name="filename"; filename="캡처22222.JPG"
//		웹사이트 part header의 content-disposition에 업로드된 파일이름을 가지고 있다 
//		파일이름 가져와
		String[] elements = contentDispositionHeader.split(";");
		
		for (String element : elements) {
			if(element.trim().startsWith("filename")) {
//				filename="캡처22222.JPG"
				System.out.println(element.substring(element.indexOf("=")+2, element.length()-1));
				return element.substring(element.indexOf("=")+2, element.length()-1);
			}
			
		}
		return null;
	}
}
