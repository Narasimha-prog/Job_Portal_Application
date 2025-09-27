package lnr.Job_Portal_Application.job.domain.user.vo;

import lnr.Job_Portal_Application.shared.error.domain.Assert;
import org.jilt.Builder;

@Builder
public record AddressToUpdate(PublicId userPublicId, Address userAddress) {

    public AddressToUpdate {
        Assert.notNull("userPublicId", userPublicId);
        Assert.notNull("userAddress", userAddress);
    }
}