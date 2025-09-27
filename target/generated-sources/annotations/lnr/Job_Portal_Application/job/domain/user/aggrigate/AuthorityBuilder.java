package lnr.Job_Portal_Application.job.domain.user.aggrigate;

import javax.annotation.processing.Generated;
import lnr.Job_Portal_Application.job.domain.user.vo.AuthorityName;
import org.jilt.JiltGenerated;

@Generated("Jilt-1.8.3")
@JiltGenerated
public class AuthorityBuilder {
  private AuthorityName name;

  public static AuthorityBuilder authority() {
    return new AuthorityBuilder();
  }

  public AuthorityBuilder name(AuthorityName name) {
    this.name = name;
    return this;
  }

  public Authority build() {
    return new Authority(name);
  }
}
