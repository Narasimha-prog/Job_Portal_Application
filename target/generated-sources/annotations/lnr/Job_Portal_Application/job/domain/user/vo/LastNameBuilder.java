package lnr.Job_Portal_Application.job.domain.user.vo;

import java.lang.String;
import javax.annotation.processing.Generated;
import org.jilt.JiltGenerated;

@Generated("Jilt-1.8.3")
@JiltGenerated
public class LastNameBuilder {
  private String value;

  public static LastNameBuilder lastName() {
    return new LastNameBuilder();
  }

  public LastNameBuilder value(String value) {
    this.value = value;
    return this;
  }

  public LastName build() {
    return new LastName(value);
  }
}
