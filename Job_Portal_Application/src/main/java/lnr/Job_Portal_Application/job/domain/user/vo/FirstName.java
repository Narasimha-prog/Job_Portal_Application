package lnr.Job_Portal_Application.job.domain.user.vo;

import lnr.Job_Portal_Application.shared.error.domain.Assert;

public record FirstName(String value) {
    public FirstName {
        Assert.field("FirstName",value).maxLength(60);
    }
}
