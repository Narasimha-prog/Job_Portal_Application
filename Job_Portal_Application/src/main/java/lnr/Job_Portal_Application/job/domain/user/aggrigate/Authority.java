package lnr.Job_Portal_Application.job.domain.user.aggrigate;

import lnr.Job_Portal_Application.job.domain.user.vo.AuthorityName;
import lnr.Job_Portal_Application.shared.error.domain.Assert;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;
import org.jilt.Builder;


@Getter
@Builder
@ToString
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class Authority {

    @EqualsAndHashCode.Include
    private AuthorityName name;

    public Authority(AuthorityName authorityName) {
        Assert.notNull("AuthorityName",authorityName);
        this.name = authorityName;
    }


}
