package mailtest;

import jakarta.mail.Authenticator;
import jakarta.mail.PasswordAuthentication;

public class GoogleAuthentication extends Authenticator {
  PasswordAuthentication passAuth;

  public GoogleAuthentication() {
    passAuth = new PasswordAuthentication("gardenfi3847", "");
  } 

  public PasswordAuthentication getPasswordAuthentication() {
    return passAuth;
  }
}
