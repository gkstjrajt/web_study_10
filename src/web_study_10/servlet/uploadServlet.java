package web_study_10.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

@WebServlet("/upload.do")
public class uploadServlet extends HttpServlet {
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
				String fileName = multi.getFilesystemName("uploadFile");
				
				if(fileName == null) { 					// 파일이 업로드 되지 않았을때
					System.out.println("파일이 업로드 되지 않았음.");
				} else {								// 파일이 업로드 되었을 떄
					out.println("<br> 글쓴이 : " + multi.getParameter("name"));
					out.println("<br> 제 &nbsp; 목 : " + multi.getParameter("title"));
					out.println("<br> 파일명 : " + fileName);
					out.println("<br><button onclick=\"window.location.href = '01_upload.jsp'\">돌아가기</button>");
				}
			} catch (Exception e) {
				System.out.println("예외발생 : " + e);
			}
		} else {
			System.out.println("GET");
		}
	}

}
