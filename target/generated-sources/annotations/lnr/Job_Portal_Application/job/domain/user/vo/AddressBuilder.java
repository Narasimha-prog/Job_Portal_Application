package lnr.Job_Portal_Application.job.domain.user.vo;

import java.lang.String;
import javax.annotation.processing.Generated;
import org.jilt.JiltGenerated;

@Generated("Jilt-1.8.3")
@JiltGenerated
public class AddressBuilder {
  private String street;

  private String city;

  private String zipCode;

  private String cuntry;

  public static AddressBuilder address() {
    return new AddressBuilder();
  }

  public AddressBuilder street(String street) {
    this.street = street;
    return this;
  }

  public AddressBuilder city(String city) {
    this.city = city;
    return this;
  }

  public AddressBuilder zipCode(String zipCode) {
    this.zipCode = zipCode;
    return this;
  }

  public AddressBuilder cuntry(String cuntry) {
    this.cuntry = cuntry;
    return this;
  }

  public Address build() {
    return new Address(street, city, zipCode, cuntry);
  }
}
