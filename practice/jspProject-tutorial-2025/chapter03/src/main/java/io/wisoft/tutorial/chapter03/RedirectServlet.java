package io.wisoft.tutorial.chapter03;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet("/RedirectServlet")
public class RedirectServlet extends HttpServlet {

  public RedirectServlet() {
    super();
  }

  protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    // TODO: 요청 속성 "request"에 데이터를 저장하세요. (예: "requestValue") (1줄)
    request.setAttribute("request", "requestValue");
    RequestDispatcher dispatcher = request.getRequestDispatcher("/redirect.jsp");
    dispatcher.forward(request, response);

    // TODO: 클라이언트를 "redirect.jsp"로 리다이렉트하세요. (1줄)
    response.sendRedirect("redirect.jsp");

  }

}
