package service;

import static db.JdbcUtil.*;

import java.sql.Connection;

import dao.LoginDAO;
import valueObject.Member;

public class LoginService {

  public Member getLoginMember(String id, String passwd) {
    // TODO Auto-generated method stub
    LoginDAO loginDAO = LoginDAO.getInstance();
    Connection con = getConnection();
    loginDAO.setConnection(con);
    Member loginMember = loginDAO.selectLoginMember(id, passwd);
    close(con);
    return loginMember;
  }

}