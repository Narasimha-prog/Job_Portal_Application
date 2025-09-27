package lnr.Job_Portal_Application.job.domain.user.vo;

import lnr.Job_Portal_Application.shared.error.domain.Assert;
import org.jilt.Builder;


@Builder
public record LastName(String value) {
    public LastName {
        Assert.field("LastName",value).maxLength(60);

    }
}
