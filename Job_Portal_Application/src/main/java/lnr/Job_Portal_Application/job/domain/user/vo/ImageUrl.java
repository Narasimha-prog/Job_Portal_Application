package lnr.Job_Portal_Application.job.domain.user.vo;

import lnr.Job_Portal_Application.shared.error.domain.Assert;

public record ImageUrl(String value) {
    public ImageUrl {
        Assert.field("ImageUrl",value).maxLength(1000);
    }
}
