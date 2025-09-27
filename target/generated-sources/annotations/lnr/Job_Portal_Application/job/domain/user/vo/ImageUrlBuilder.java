package lnr.Job_Portal_Application.job.domain.user.vo;

import java.lang.String;
import javax.annotation.processing.Generated;
import org.jilt.JiltGenerated;

@Generated("Jilt-1.8.3")
@JiltGenerated
public class ImageUrlBuilder {
  private String value;

  public static ImageUrlBuilder imageUrl() {
    return new ImageUrlBuilder();
  }

  public ImageUrlBuilder value(String value) {
    this.value = value;
    return this;
  }

  public ImageUrl build() {
    return new ImageUrl(value);
  }
}
