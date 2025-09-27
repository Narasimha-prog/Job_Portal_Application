package lnr.Job_Portal_Application.job.domain.user.vo;

import lnr.Job_Portal_Application.shared.error.domain.Assert;
import org.jilt.Builder;

import java.util.UUID;

@Builder
public record PublicId(UUID value) {

    public PublicId {
        Assert.notNull("PublicId",value);
    }
}
