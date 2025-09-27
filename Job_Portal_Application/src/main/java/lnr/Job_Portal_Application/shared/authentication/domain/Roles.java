package lnr.Job_Portal_Application.shared.authentication.domain;
import lnr.Job_Portal_Application.shared.error.domain.Assert;
import java.util.Collections;
import java.util.Set;
import java.util.stream.Stream;
public record Roles(Set<Role> roles) {

        public static final Roles EMPTY = new Roles(null);

        //create one unmodifiable set of roles
        public Roles(Set<Role> roles) {
            this.roles = Collections.unmodifiableSet(roles);
        }

        //chack has any role
        public boolean hasRole() {
            return !roles.isEmpty();
        }

        //find specific role
        public boolean hasRole(Role role) {
            Assert.notNull("role", role);

            return roles.contains(role);
        }

        //get stream of roles
        public Stream<Role> stream() {
            return get().stream();
        }

        //get total roles
        public Set<Role> get() {
            return roles();
        }
    }

