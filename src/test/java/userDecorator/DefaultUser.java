package userDecorator;

public class DefaultUser implements User {
  private final String username;
  private String password;

  public DefaultUser(String username, String password) {
    this.username = username;
    this.password = password;
  }
  public DefaultUser(String username) {
    this.username = username;
  }

  @Override
  public String getUsername() {
    return username;
  }

  @Override
  public String getPassword() {
    return password;
  }

  @Override
  public void setPassword(String password) {
    this.password = password;
  }
}
