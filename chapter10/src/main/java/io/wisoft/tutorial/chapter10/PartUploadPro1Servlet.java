package io.wisoft.tutorial.chapter10;

import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.MultipartConfig;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.Part;

/**
 * Servlet implementation class PartUploadPro1Servlet
 */

@WebServlet("/partUploadPro1")
@MultipartConfig(fileSizeThreshold = 0, location = "/Users/moon/Developments/graduate-school/mvc/chapter10/src/upload")
public class PartUploadPro1Servlet extends HttpServlet {
  private static final long serialVersionUID = 1L;

  /**
   * @see HttpServlet#HttpServlet()
   */
  public PartUploadPro1Servlet() {
    super();
    // TODO Auto-generated constructor stub
  }

  /**
   * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
   * response)
   */
  protected void doPost(HttpServletRequest request, HttpServletResponse response)
          throws ServletException, IOException {
    // TODO Auto-generated method stub
    request.setCharacterEncoding("UTF-8");
    String writer = request.getParameter("writer");
    Part part = request.getPart("partFile1");
    response.setContentType("text/html;charset=UTF-8");
    PrintWriter out = response.getWriter();
    String contentDisposition = part.getHeader("content-disposition");
    String uploadFileName = getUploadFileName(contentDisposition);
    part.write(uploadFileName);
    out.println("작성자  " + writer + "님이 " + uploadFileName + " 파일을 업로드 하였습니다.");
  }

  private String getUploadFileName(String contentDisposition) {
    // TODO Auto-generated method stub
    String uploadFileName = null;
    String[] contentSplitStr = contentDisposition.split(";");
    int firstQutosIndex = contentSplitStr[2].indexOf("\"");
    int lastQutosIndex = contentSplitStr[2].lastIndexOf("\"");
    uploadFileName = contentSplitStr[2].substring(firstQutosIndex + 1, lastQutosIndex);
    return uploadFileName;
  }

}
