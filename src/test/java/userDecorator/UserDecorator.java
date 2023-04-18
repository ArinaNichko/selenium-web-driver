package userDecorator;

public class UserDecorator implements User {
  private final User user;

  UserDecorator(User user) {
    this.user = user;
  }

  @Override
  public String getUsername() {
    return user.getUsername();
  }

  @Override
  public String getPassword() {
    return user.getPassword();
  }

  @Override
  public void setPassword(String password) {
    user.setPassword(password);
  }
}
