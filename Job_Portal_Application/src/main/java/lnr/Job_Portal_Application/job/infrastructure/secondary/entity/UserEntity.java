package lnr.Job_Portal_Application.job.infrastructure.secondary.entity;

import jakarta.persistence.*;
import lnr.Job_Portal_Application.job.domain.user.aggrigate.User;
import lnr.Job_Portal_Application.shared.jpa.AbstractAuditingEntity;
import lombok.*;

import java.time.Instant;
import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

@EqualsAndHashCode(onlyExplicitlyIncluded = true, callSuper = false)
@Entity
@Table(name = "users")
@Data
@AllArgsConstructor
@RequiredArgsConstructor
@Builder
public class UserEntity extends AbstractAuditingEntity<Long> {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
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

    @ManyToMany(cascade = CascadeType.REMOVE)
    @JoinTable(
            name = "user_authority",
            joinColumns = {@JoinColumn(name = "user_id",referencedColumnName = "id")},
            inverseJoinColumns = {@JoinColumn(name = "authority_name",referencedColumnName = "name")}
    )
    private Set<AuthorityEntity> authorities=new HashSet<>();


    public void updateFromUser(User user){

//        this.firstName=user.getFirstName().userFirstName();
//        this.lastName=user.getLastName().userLastName();
//        this.email=user.getEmail().email();
//        this.imageUrl=user.getImageUrl().imageUrl();
//        this.lastSeen=user.getLastSeenDate();

    }



}
