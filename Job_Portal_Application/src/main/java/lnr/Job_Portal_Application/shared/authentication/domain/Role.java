package lnr.Job_Portal_Application.shared.authentication.domain;

import lnr.Job_Portal_Application.shared.error.domain.Assert;

import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public enum Role {
    ADMIN,
    USER,
    ANONYMOUS,
    UNKNOWN;

    // for spring boot security check
    private static final String PREFIX = "ROLE_";

    //  ROLE_ADMIN ,ADMIN
    private static final Map<String, Role> ROLES = buildRoles();

    private static Map<String, Role> buildRoles() {
        return Stream.of(values()).collect(Collectors.toUnmodifiableMap(Role::key, Function.identity()));
    }

    //get as ROLE_ADMIN
    public String key() {
        return PREFIX + name();
    }

  //if that role is not there we need to take UNKNOWN
    public static Role from(String role) {
        Assert.notBlank("role", role);

        return ROLES.getOrDefault(role, UNKNOWN);
    }
}