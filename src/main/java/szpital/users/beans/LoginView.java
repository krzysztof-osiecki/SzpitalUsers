package szpital.users.beans;

import szpital.users.services.AuthService;
import szpital.users.session.UserContext;
import szpital.users.util.SessionUtils;
import lombok.Getter;
import lombok.Setter;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.servlet.http.HttpSession;
import java.io.Serializable;

@ManagedBean
@SessionScoped
@Getter
@Setter
public class LoginView implements Serializable {

  @Inject
  private UserContext userContext;
  private String pass;
  private String msg;
  private String user;

  //validate login
  public String validateUsernamePassword() {
    boolean valid = AuthService.validate(user, pass);
    if (valid) {
      userContext.setAuthenticated(true);
      userContext.setUserName(user);
      HttpSession session = SessionUtils.getSession();
      session.setAttribute("user", userContext);
      return "admin?faces-redirect=true";
    } else {
      FacesContext.getCurrentInstance().addMessage(
          null,
          new FacesMessage(FacesMessage.SEVERITY_WARN,
              "Incorrect Username and Password",
              "Please enter correct username and Password"));
      return null;
    }
  }

  //logout event, invalidate session
  public String logout() {
    HttpSession session = SessionUtils.getSession();
    userContext.setAuthenticated(false);
    session.invalidate();
    return "login?faces-redirect=true";
  }
}
