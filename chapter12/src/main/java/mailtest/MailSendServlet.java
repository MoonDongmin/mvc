package mailtest;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Properties;
import jakarta.mail.Address;
import jakarta.mail.Authenticator;
import jakarta.mail.Message;
import jakarta.mail.Session;
import jakarta.mail.Transport;
import jakarta.mail.internet.InternetAddress;
import jakarta.mail.internet.MimeMessage;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class MailSendServlet
 */
@WebServlet("/mailSend")
public class MailSendServlet extends HttpServlet {
  private static final long serialVersionUID = 1L;

  /**
   * @see HttpServlet#HttpServlet()
   */
  public MailSendServlet() {
    super();
    // TODO Auto-generated constructor stub
  }

  /**
   * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
   */
  protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    request.setCharacterEncoding("UTF-8");
    String sender = request.getParameter("sender");
    String receiver = request.getParameter("receiver");
    String subject = request.getParameter("subject");
    String content = request.getParameter("content");
    response.setContentType("text/html;charset=UTF-8");
    PrintWriter out = response.getWriter();
    try {
      Properties properties = System.getProperties();
      properties.put("mail.smtp.starttls.enable", "true"); //use TLS
      //전송계층 보안 프로토콜
      properties.put("mail.smtp.host", "smtp.gmail.com");
      properties.put("mail.smtp.auth", "true"); //SMTP 인증기능 사용 시
      properties.put("mail.smtp.port", "587"); // gmail 포트
      // TLS 오류 해결을 위해 아래 코드 추가
      properties.put("mail.smtp.ssl.protocols", "TLSv1.2");
      Authenticator auth = new GoogleAuthentication();
      Session s = Session.getDefaultInstance(properties, auth);
      Message message = new MimeMessage(s);
      Address sender_address = new InternetAddress(sender);
      Address receiver_address = new InternetAddress(receiver);
      message.setHeader("content-type", "text/html;charset=UTF-8");
      message.setFrom(sender_address);
      message.addRecipient(Message.RecipientType.TO, receiver_address); //TO : 직접 받는 사람 설정, CC 등 설정 가능
      message.setSubject(subject);
      message.setContent(content, "text/html;charset=UTF-8");
      message.setSentDate(new java.util.Date());
      Transport.send(message);
      out.println("<h3>메일이 정상적으로 전송되었습니다.</h3>");
    } catch (Exception e) {
      out.println("SMTP 서버가 잘못 설정되었거나, 서비스에 문제가 있습니다.");
      e.printStackTrace();
    }
  }

}
