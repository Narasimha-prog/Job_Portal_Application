package lnr.Job_Portal_Application.job.domain.user.vo;

import lnr.Job_Portal_Application.shared.error.domain.Assert;

public record AuthorityName(String value) {
    public AuthorityName {
        Assert.notNull("AuthorityName",value);
    }
}
