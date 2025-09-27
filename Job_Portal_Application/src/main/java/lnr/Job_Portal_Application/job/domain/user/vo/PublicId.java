package lnr.Job_Portal_Application.job.domain.user.vo;

import lnr.Job_Portal_Application.shared.error.domain.Assert;

import java.util.UUID;

public record PublicId(UUID value) {

    public PublicId {
        Assert.notNull("PublicId",value);
    }
}
