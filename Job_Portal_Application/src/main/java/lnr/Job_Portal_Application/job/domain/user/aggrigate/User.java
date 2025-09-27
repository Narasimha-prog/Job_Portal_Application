package lnr.Job_Portal_Application.job.domain.user.aggrigate;
import lnr.Job_Portal_Application.job.domain.user.vo.*;
import lnr.Job_Portal_Application.shared.error.domain.Assert;
import lombok.*;
import org.jilt.Builder;
import  lnr.Job_Portal_Application.job.domain.user.aggrigate.UserBuilder;
import  lnr.Job_Portal_Application.job.domain.user.aggrigate.AuthorityBuilder;

import java.time.Instant;
import java.util.*;
import java.util.stream.Collectors;

@Getter
@Builder
@ToString
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class User {

    private Long dbId; // database id
    private FirstName firstName;
    private LastName lastName;
    private Email email;
    private Set<Authority> authorities;
    @EqualsAndHashCode.Include
    private PublicId publicId;
    private ImageUrl imageUrl;
    private Address address;
    private Instant lastSeenDate;
    private  Instant createdInstant;
    private Instant lastModifiedInstant;


    public User(Long dbId, FirstName firstName, LastName lastName, Email email, Set<Authority> authorities,PublicId publicId, ImageUrl imageUrl,
                 Address address, Instant lastSeenDate, Instant createdInstant, Instant lastModifiedInstant) {

      //check null while inserting objects
        Assert.notNull("FirstName", firstName);
        Assert.notNull("LastName", lastName);
        Assert.notNull("Email", email);
        Assert.notNull("Authorities", authorities);

        this.dbId = dbId;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.authorities = new HashSet<>(authorities);
        this.publicId = publicId;
        this.imageUrl = imageUrl;
        this.address = address;
        this.lastSeenDate = lastSeenDate;
        this.createdInstant = createdInstant != null ? createdInstant : Instant.now();
        this.lastModifiedInstant = lastModifiedInstant;
    }
    public void initFieldForSignup() {
        this.publicId = new PublicId(UUID.randomUUID());
    }
    public static User fromTokenAttributes(Map<String, Object> attributes, List<String> rolesFromAccessToken) {

       UserBuilder userBuilder = UserBuilder.user();

        if(attributes.containsKey("preferred_email")) {
            userBuilder.email(new Email(attributes.get("preferred_email").toString()));
        }

        if(attributes.containsKey("last_name")) {
            userBuilder.lastName(new LastName(attributes.get("last_name").toString()));
        }

        if(attributes.containsKey("first_name")) {
            userBuilder.firstName(new FirstName(attributes.get("first_name").toString()));
        }

        if(attributes.containsKey("picture")) {
            userBuilder.imageUrl(new ImageUrl(attributes.get("picture").toString()));
        }

        if(attributes.containsKey("last_signed_in")) {
            userBuilder.lastSeenDate(Instant.parse(attributes.get("last_signed_in").toString()));
        }

        Set<Authority> authorities = rolesFromAccessToken
                .stream()
                .map(authority ->AuthorityBuilder.authority().name(new AuthorityName(authority)).build())
                .collect(Collectors.toSet());

        userBuilder.authorities(authorities);

        return userBuilder.build();
    }

}
