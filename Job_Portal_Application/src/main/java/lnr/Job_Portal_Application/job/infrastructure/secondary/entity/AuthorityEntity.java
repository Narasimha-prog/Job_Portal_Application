package lnr.Job_Portal_Application.job.infrastructure.secondary.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lnr.Job_Portal_Application.job.domain.user.aggrigate.Authority;
import lnr.Job_Portal_Application.job.domain.user.aggrigate.AuthorityBuilder;
import lnr.Job_Portal_Application.job.domain.user.vo.AuthorityName;
import lnr.Job_Portal_Application.job.infrastructure.secondary.entity.AuthorityEntityBuilder;
import lombok.*;
import org.jilt.Builder;

import java.io.Serializable;
import java.util.Set;
import java.util.stream.Collectors;

@Entity
@Table(name = "authority")
@Getter
@ToString
@EqualsAndHashCode
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class AuthorityEntity implements Serializable {

    @Id
    @Column(name = "name",length = 50)
    @Size(max = 50)
    private String name;

    //mapper for set
    public static Set<AuthorityEntity> fromAuthoritySet(Set<Authority> authorities) {
        return authorities.stream()
                .map(authority -> lnr.Job_Portal_Application.job.infrastructure.secondary.entity.AuthorityEntityBuilder.authorityEntity().
                        name(authority.getName().value()).build()).collect(Collectors.toSet());
    }


    public static Set<Authority> toDomainSet(Set<AuthorityEntity> authorityEntities) {
        return authorityEntities.stream()
                .map(AuthorityEntity::toDomain)
                .collect(Collectors.toSet());
    }

    //mapper for single value
    public static Authority toDomain(AuthorityEntity authorityEntity){
        return AuthorityBuilder.authority().name(new AuthorityName(authorityEntity.getName())).build();

    }

    public static AuthorityEntity toEntity(Authority authority){
        return AuthorityEntityBuilder.authorityEntity().name(authority.getName().value()).build();
    }

    public void setName(@NotNull @Size(max = 50) String name) {
        this.name = name;
    }
}
