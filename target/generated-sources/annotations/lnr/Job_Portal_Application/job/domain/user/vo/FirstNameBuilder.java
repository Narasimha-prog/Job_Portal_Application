package lnr.Job_Portal_Application.job.domain.user.vo;

import java.lang.String;
import javax.annotation.processing.Generated;
import org.jilt.JiltGenerated;

@Generated("Jilt-1.8.3")
@JiltGenerated
public class FirstNameBuilder {
  private String value;

  public static FirstNameBuilder firstName() {
    return new FirstNameBuilder();
  }

  public FirstNameBuilder value(String value) {
    this.value = value;
    return this;
  }

  public FirstName build() {
    return new FirstName(value);
  }
}
