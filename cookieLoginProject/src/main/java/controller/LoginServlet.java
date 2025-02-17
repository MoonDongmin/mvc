package controller;

import java.io.IOException;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import service.LoginService;
import valueObject.Member;

@WebServlet("/login")
public class LoginServlet extends HttpServlet {
  private static final long serialVersionUID = 1L;

  public LoginServlet() {
    super();
    // TODO Auto-generated constructor stub
  }

  @Override
  protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    // TODO Auto-generated method stub

    Cookie[] cookieArray = request.getCookies();
    String id = "";
    String passwd = "";

    if (cookieArray != null) {

      for (int i = 0; i < cookieArray.length; i++) {
        if (cookieArray[i].getName().equals("id")) {
          id = cookieArray[i].getValue();
        } else if (cookieArray[i].getName().equals("passwd")) {
          passwd = cookieArray[i].getValue();
        }
      }

      LoginService loginService = new LoginService();
      Member loginMember = loginService.getLoginMember(id, passwd);

      if (loginMember != null) {
        RequestDispatcher dispatcher = request.getRequestDispatcher("loginSuccess.jsp");
        request.setAttribute("loginMember", loginMember);
        dispatcher.forward(request, response);
      } else {
        RequestDispatcher dispatcher =
                request.getRequestDispatcher("loginForm.html");
        dispatcher.forward(request, response);
      }
    }
  }

  protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    // TODO Auto-generated method stub

    String id = request.getParameter("id");
    String passwd = request.getParameter("passwd");
    String useCookie = request.getParameter("useCookie");
    LoginService loginService = new LoginService();
    Member loginMember = loginService.getLoginMember(id, passwd);

    if (useCookie != null) {

      Cookie idCookie = new Cookie("id", id);

      idCookie.setMaxAge(60 * 60 * 24);
      Cookie passwdCookie = new Cookie("passwd", passwd);

      passwdCookie.setMaxAge(60 * 60 * 24);


      response.addCookie(idCookie);
      response.addCookie(passwdCookie);

    }

    if (loginMember != null) {

      RequestDispatcher dispatcher = request.getRequestDispatcher("loginSuccess.jsp");
      request.setAttribute("loginMember", loginMember);
      dispatcher.forward(request, response);

    } else {

      RequestDispatcher dispatcher = request.getRequestDispatcher("loginFail.jsp");
      dispatcher.forward(request, response);

    }
  }

}