package userDecorator;

import java.util.Base64;

public class UserWithEncodedPasswordDecorator extends UserDecorator {

  public UserWithEncodedPasswordDecorator(User user) {
    super(user);
    setPassword(user.getPassword());
  }

  public static String encodeBase64(String input) {
    byte[] bytes = input.getBytes();
    byte[] encoded = Base64.getEncoder().encode(bytes);
    return new String(encoded);
  }

  @Override
  public void setPassword(String password) {
    super.setPassword(encodeBase64(password));
  }
}
