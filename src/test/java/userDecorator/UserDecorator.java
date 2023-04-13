package userDecorator;

public class UserDecorator implements User {
  private final User wrapper;

  UserDecorator(User user) {
    this.wrapper = user;
  }

  @Override
  public String getUsername() {
    return wrapper.getUsername();
  }

  @Override
  public String getPassword() {
    return wrapper.getPassword();
  }

  @Override
  public void setPassword(String password) {
    wrapper.setPassword(password);
  }
}
