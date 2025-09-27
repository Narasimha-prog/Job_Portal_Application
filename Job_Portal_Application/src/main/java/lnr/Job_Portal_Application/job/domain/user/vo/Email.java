package lnr.Job_Portal_Application.job.domain.user.vo;

import lnr.Job_Portal_Application.shared.error.domain.Assert;
import org.jilt.Builder;

@Builder
public record Email(String value) {
    public Email {
        Assert.field("UserEmail",value).maxLength(75);
    }
}