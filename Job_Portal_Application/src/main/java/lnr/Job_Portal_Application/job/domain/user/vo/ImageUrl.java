package lnr.Job_Portal_Application.job.domain.user.vo;

import lnr.Job_Portal_Application.shared.error.domain.Assert;
import org.jilt.Builder;


@Builder
public record ImageUrl(String value) {
    public ImageUrl {
        Assert.field("ImageUrl",value).maxLength(1000);
    }
}
