package controller;

import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import service.LoginService;
import valueObject.Member;

@WebServlet("/login")
public class LoginServlet extends HttpServlet {
  private static final long serialVersionUID = 1L;

  public LoginServlet() {
    super();
    // TODO Auto-generated constructor stub
  }

  protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    // TODO Auto-generated method stub
    String id = request.getParameter("id");
    String passwd = request.getParameter("passwd");
    LoginService loginService = new LoginService();
    Member loginMember = loginService.getLoginMember(id, passwd);
    //로그인이 성공되면 Member객체가 넘어오고 실패하면 null이 넘어옴

    if (loginMember != null) {
      HttpSession session = request.getSession();
      session.setAttribute("id", id);
      response.sendRedirect("index.jsp");
    } else {
      response.setContentType("text/html;charset=UTF-8");
      PrintWriter out = response.getWriter();
      out.println("<script>");
      out.println("alert('로그인실패')");
      out.println("history.back()");
      out.println("</script>");
    }
  }

}









