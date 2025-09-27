package lnr.Job_Portal_Application.job.domain.user.vo;

import java.lang.String;
import javax.annotation.processing.Generated;
import org.jilt.JiltGenerated;

@Generated("Jilt-1.8.3")
@JiltGenerated
public class AuthorityNameBuilder {
  private String value;

  public static AuthorityNameBuilder authorityName() {
    return new AuthorityNameBuilder();
  }

  public AuthorityNameBuilder value(String value) {
    this.value = value;
    return this;
  }

  public AuthorityName build() {
    return new AuthorityName(value);
  }
}
