package lnr.Job_Portal_Application.job.domain.user.vo;

import lnr.Job_Portal_Application.shared.error.domain.Assert;

public record UserFirstName(String value) {
    public UserFirstName {
        Assert.field();
    }
}
