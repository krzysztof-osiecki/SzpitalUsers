package szpital.users.beans;

import szpital.users.services.AuthService;
import szpital.users.util.SessionUtils;
import lombok.Getter;
import lombok.Setter;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpSession;
import java.io.Serializable;

@ManagedBean
@SessionScoped
@Getter
@Setter
public class LoginView implements Serializable {

  private String pass;
  private String msg;
  private String user;

  //validate login
  public String validateUsernamePassword() {
    boolean valid = AuthService.validate(user, pass);
    if (valid) {
      HttpSession session = SessionUtils.getSession();
      session.setAttribute("username", user);
      return "admin";
    } else {
      FacesContext.getCurrentInstance().addMessage(
          null,
          new FacesMessage(FacesMessage.SEVERITY_WARN,
              "Incorrect Username and Password",
              "Please enter correct username and Password"));
      return "login";
    }
  }

  //logout event, invalidate session
  public String logout() {
    HttpSession session = SessionUtils.getSession();
    session.invalidate();
    return "login";
  }
}
