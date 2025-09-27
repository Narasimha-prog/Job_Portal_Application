package lnr.Job_Portal_Application.job.domain.user.aggrigate;

import lnr.Job_Portal_Application.job.domain.user.vo.*;
import lnr.Job_Portal_Application.job.infrastructure.secondary.entity.UserEntity;
import lnr.Job_Portal_Application.shared.error.domain.Assert;
import lombok.*;
import org.jilt.Builder;

import java.time.Instant;
import java.util.*;
@Getter
public class User {

    private Long dbId; // database id
    private FirstName firstName;
    private LastName lastName;
    private Email email;
    private Set<Authority> authorities;
    private final Instant createdInstant;
    private PublicId publicId;
    private ImageUrl imageUrl;
    private Instant lastModifiedInstant;
    private Address address;
    private Instant lastSeenDate;

    private User(Long dbId, FirstName firstName, LastName lastName, Email email, PublicId publicId, ImageUrl imageUrl,
                 Address address, Instant lastSeenDate, Instant createdInstant, Instant lastModifiedInstant) {

        //Set<Authority> authorities
        Assert.notNull("FirstName", firstName);
        Assert.notNull("LastName", lastName);
        Assert.notNull("Email", email);
       // Assert.notNull("Authorities", authorities);

        this.dbId = dbId;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
       // this.authorities = new HashSet<>(authorities);
        this.publicId = publicId;
        this.imageUrl = imageUrl;
        this.address = address;
        this.lastSeenDate = lastSeenDate;
        this.createdInstant = createdInstant != null ? createdInstant : Instant.now();
        this.lastModifiedInstant = lastModifiedInstant;
    }

    // Factory for creating new user
    public static User create(FirstName firstName, LastName lastName, Email email,
                              Set<Authority> authorities, PublicId publicId,
                              ImageUrl imageUrl, Address address, Instant lastSeenDate) {
        return new User(null, firstName, lastName, email, publicId, imageUrl, address, lastSeenDate, Instant.now(), null);
    }
    //authorities

    // Factory for rehydration from entity
    public static User fromEntity(UserEntity entity) {
        return new User(
                entity.getId(),
                new FirstName(entity.getFirstName()),
                new LastName(entity.getLastName()),
                new Email(entity.getEmail()),
//                new HashSet<>(entity.getAuthorities()),
                new PublicId(entity.getPublicId()),
                new ImageUrl(entity.getImageUrl()),
                new Address(entity.getAddressStreet(),entity.getAddressCity(),entity.getAddressZipCode(),entity.getAddressCountry()),
                entity.getLastSeen(),
                entity.getCreatedDate(),
                entity.getLastModifiedDate()
        );
    }


    // Domain behavior
    public void updateName(FirstName firstName, LastName lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.lastModifiedInstant = Instant.now();
    }

    public void updateEmail(Email newEmail) {
        this.email = newEmail;
        this.lastModifiedInstant = Instant.now();
    }

    public void grantAuthority(Authority authority) {
        this.authorities.add(authority);
        this.lastModifiedInstant = Instant.now();
    }

    public void revokeAuthority(Authority authority) {
        this.authorities.remove(authority);
        this.lastModifiedInstant = Instant.now();
    }
}
