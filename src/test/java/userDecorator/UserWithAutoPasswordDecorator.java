package userDecorator;

import org.apache.commons.lang.RandomStringUtils;

public class UserWithAutoPasswordDecorator extends DefaultUser {
  private final static int LENGTH = 8;

  public UserWithAutoPasswordDecorator(String username) {
    super(username, null);
    setPassword(generatePassword(LENGTH));
  }

  public static String generatePassword(int length) {
   return RandomStringUtils.randomAlphanumeric(length);
  }

  @Override
  public void setPassword(String password) {
    super.setPassword(password);
  }
}
