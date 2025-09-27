package lnr.Job_Portal_Application.job.domain.user.vo;


import lnr.Job_Portal_Application.shared.error.domain.Assert;
import org.jilt.Builder;

@Builder
public record Address(String street, String city, String  zipCode, String cuntry) {
    public Address{

        Assert.field("street",street).notNull();
        Assert.field("zipCode",zipCode).notNull();
        Assert.field("city",city).notNull();
        Assert.field("cuntry",cuntry).notNull();


    }
}

