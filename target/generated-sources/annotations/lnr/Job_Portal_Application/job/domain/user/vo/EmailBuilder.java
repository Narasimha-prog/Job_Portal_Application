package lnr.Job_Portal_Application.job.domain.user.vo;

import java.lang.String;
import javax.annotation.processing.Generated;
import org.jilt.JiltGenerated;

@Generated("Jilt-1.8.3")
@JiltGenerated
public class EmailBuilder {
  private String value;

  public static EmailBuilder email() {
    return new EmailBuilder();
  }

  public EmailBuilder value(String value) {
    this.value = value;
    return this;
  }

  public Email build() {
    return new Email(value);
  }
}
