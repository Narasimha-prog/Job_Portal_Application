package lnr.Job_Portal_Application.job.domain.user.vo;

import java.util.UUID;
import javax.annotation.processing.Generated;
import org.jilt.JiltGenerated;

@Generated("Jilt-1.8.3")
@JiltGenerated
public class PublicIdBuilder {
  private UUID value;

  public static PublicIdBuilder publicId() {
    return new PublicIdBuilder();
  }

  public PublicIdBuilder value(UUID value) {
    this.value = value;
    return this;
  }

  public PublicId build() {
    return new PublicId(value);
  }
}
