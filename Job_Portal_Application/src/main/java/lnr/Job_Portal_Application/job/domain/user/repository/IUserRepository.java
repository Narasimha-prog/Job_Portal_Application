package lnr.Job_Portal_Application.job.domain.user.repository;

import lnr.Job_Portal_Application.job.domain.user.aggrigate.User;
import lnr.Job_Portal_Application.job.domain.user.vo.AddressToUpdate;
import lnr.Job_Portal_Application.job.domain.user.vo.Email;
import lnr.Job_Portal_Application.job.domain.user.vo.PublicId;

import java.util.Optional;

public interface IUserRepository {

    void save(User user);

    Optional<User> get(PublicId userPublicId);

    Optional<User> getOneByEmail(Email userEmail);

    void updateAddress( AddressToUpdate userAddress);
}
