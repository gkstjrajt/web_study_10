package web_study_10.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

@WebServlet("/upload2.do")
public class uploadServlet2 extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		process(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		process(request, response);
	}

	private void process(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		if (request.getMethod().equalsIgnoreCase("POST")) {
			System.out.println("POST");
			response.setContentType("text/html; charset=UTF-8");
			PrintWriter out = response.getWriter();
			
			// 여기를 바꿔주면 다운받는 경로가 바뀜
			String savePath = "upload";
			// 최대 업로드 파일 크리 5MB로 제한
			int uploadFileSizeLimit = 5 * 1024 * 1024;
			String encType = "UTF-8";
			
			ServletContext context = getServletContext();
			String uploadFilePath = context.getRealPath(savePath);
			System.out.println("서버상의 실제 디렉토리 : ");
			System.out.println(uploadFilePath);
			
			try {
				MultipartRequest multi = new MultipartRequest(
						request, 						// request 객체
						uploadFilePath, 				// 서버상의 실제 디렉토리
						uploadFileSizeLimit, 			// 최대 업로드 파일 크기
						encType, 						// 인코딩 방법
						new DefaultFileRenamePolicy()	// 업로드 된 파일의 이름 얻기
					);
				Enumeration files = multi.getFileNames();
				while(files.hasMoreElements()) {
					String file = (String)files.nextElement();
					String file_name = multi.getFilesystemName(file);
					// 중복된 파일을 업로드 할 경우 파일명이 바뀐다.
					String ori_file_name = multi.getOriginalFileName(file);
					out.println("<br> 업로드 된 파일명 : " + file_name);
					out.println("<br> 원본 파일명 : " + ori_file_name);
					out.println("<hr>");
				}
				out.println("<br><button onclick=\"window.location.href = '02_upload.jsp'\">돌아가기</button>");
			} catch (Exception e) {
				System.out.println("예외발생 : " + e);
			}
		} else {
			System.out.println("GET");
		}
	}

}
