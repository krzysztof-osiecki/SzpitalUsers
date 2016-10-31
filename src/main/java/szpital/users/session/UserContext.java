package szpital.users.session;

import lombok.Getter;
import lombok.Setter;

import javax.enterprise.context.SessionScoped;
import java.io.Serializable;

@SessionScoped
@Getter
@Setter
public class UserContext implements Serializable {
  private String userName;
  private boolean authenticated;
}
