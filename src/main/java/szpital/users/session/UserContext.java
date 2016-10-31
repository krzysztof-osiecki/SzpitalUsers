package szpital.users.session;

import lombok.Getter;
import lombok.Setter;

import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import java.util.Date;

@SessionScoped
@Getter
@Setter
public class UserContext implements Serializable {
  private String userLogin;
  private String userName;
  private String userLastName;
  private String userCity;
  private int userAge;
  private Date userBirthDate;
  private boolean authenticated;

  public void initialize(String userLogin) {
    this.userLogin = userLogin;
    this.userName = "Karolina";
    this.userLastName = "Cieślik";
    this.userCity = "Lublin";
    this.userBirthDate = new Date();
    this.userAge = 23;
    this.authenticated = true;
  }
}
