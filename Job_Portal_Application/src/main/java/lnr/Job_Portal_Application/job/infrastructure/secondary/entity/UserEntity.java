package lnr.Job_Portal_Application.job.infrastructure.secondary.entity;

import jakarta.persistence.*;
import lnr.Job_Portal_Application.job.domain.user.aggrigate.User;

import lnr.Job_Portal_Application.job.domain.user.aggrigate.UserBuilder;
import lnr.Job_Portal_Application.job.domain.user.vo.*;
import lnr.Job_Portal_Application.job.domain.user.vo.AddressBuilder;
import lnr.Job_Portal_Application.shared.jpa.AbstractAuditingEntity;
import   lnr.Job_Portal_Application.job.infrastructure.secondary.entity.UserEntityBuilder;
import lombok.*;
import org.jilt.Builder;

import java.io.Serializable;
import java.time.Instant;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.UUID;
import java.util.stream.Collectors;

@EqualsAndHashCode(onlyExplicitlyIncluded = true, callSuper = false)
@Entity
@Table(name = "job_user")
@Getter
@Setter
@ToString(exclude = "authorities")
@AllArgsConstructor
@Builder
public class UserEntity extends AbstractAuditingEntity<Long> implements Serializable {

    @Id
    @SequenceGenerator(name = "sequence",sequenceName = "user_sequence",allocationSize = 1,initialValue = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "sequence")
    @Column(name = "id")
    private Long id;

    @Column(name = "first_name")
    private String firstName;

    @Column(name = "last_name")
    private String lastName;

    @Column(name = "email")
    private String email;

    @Column(name = "image_url")
    private String imageUrl;


    @Column(name = "public_id")
    @EqualsAndHashCode.Include
    private UUID publicId;


    @Column(name = "address_street")
    private String addressStreet;

    @Column(name = "address_city")
    private String addressCity;

    @Column(name="address_zip_code")
    private String addressZipCode;

    @Column(name = "address_country")
    private String addressCountry;

    @Column(name = "last_seen")
    private Instant lastSeen;

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(
            name = "user_authority",
            joinColumns = {@JoinColumn(name = "user_id",referencedColumnName = "id")},
            inverseJoinColumns = {@JoinColumn(name = "authority_name",referencedColumnName = "name")}
    )
    private Set<AuthorityEntity> authorities=new HashSet<>();



    //mapper for single value
    public static UserEntity toEntity(User user) {
      UserEntityBuilder userEntityBuilder = UserEntityBuilder.userEntity();

        //image check
        if (user.getImageUrl() != null) {
            userEntityBuilder.imageUrl(user.getImageUrl().value());
        }

        //public id check
        if (user.getPublicId() != null) {
            userEntityBuilder.publicId(user.getPublicId().value());
        }

        //update check
        if (user.getAddress() != null) {
            userEntityBuilder.addressCity(user.getAddress().city());
            userEntityBuilder.addressCountry(user.getAddress().country());
            userEntityBuilder.addressZipCode(user.getAddress().zipCode());
            userEntityBuilder.addressStreet(user.getAddress().street());
        }

        return userEntityBuilder
                .authorities(AuthorityEntity.fromAuthoritySet(user.getAuthorities()))
                .email(user.getEmail().value())
                .firstName(user.getFirstName().value())
                .lastName(user.getLastName().value())
                .lastSeen(user.getLastSeenDate())
                .id(user.getDbId())
                .build();
    }

    public static User toDomain(UserEntity userEntity) {
        UserBuilder userBuilder = UserBuilder.user();

        if(userEntity.getImageUrl() != null) {
            userBuilder.imageUrl(new ImageUrl(userEntity.getImageUrl()));
        }

        if(userEntity.getAddressStreet() != null) {
            userBuilder.address(
                    AddressBuilder.address()
                            .city(userEntity.getAddressCity())
                            .cuntry(userEntity.getAddressCountry())
                            .zipCode(userEntity.getAddressZipCode())
                            .street(userEntity.getAddressStreet())
                            .build());
        }

        return userBuilder
                .email(new Email(userEntity.getEmail()))
                .lastName(new LastName(userEntity.getLastName()))
                .firstName(new FirstName(userEntity.getFirstName()))
                .authorities(AuthorityEntity.toDomainSet(userEntity.getAuthorities()))
                .publicId(new PublicId(userEntity.getPublicId()))
                .lastModifiedInstant(userEntity.getLastModifiedDate())
                .createdInstant(userEntity.getCreatedDate())
                .dbId(userEntity.getId())
                .build();
    }
//mapper for set
    public static Set<UserEntity> fromUserSet(List<User> users) {
        return users.stream().map(UserEntity::toEntity).collect(Collectors.toSet());
    }

    public static Set<User> toDomainSet(List<UserEntity> users) {
        return users.stream().map(UserEntity::toDomain).collect(Collectors.toSet());
    }


}
