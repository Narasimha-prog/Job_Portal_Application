package lnr.Job_Portal_Application.job.domain.user.service;

import lnr.Job_Portal_Application.job.domain.user.aggrigate.User;
import lnr.Job_Portal_Application.job.domain.user.repository.IUserRepository;
import lnr.Job_Portal_Application.job.domain.user.vo.Email;
import lnr.Job_Portal_Application.job.domain.user.vo.PublicId;

import java.util.Optional;

public class UserReader{

    private final IUserRepository userRepository;

    public UserReader(IUserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public Optional<User> getByEmail(Email userEmail) {
        return userRepository.getOneByEmail(userEmail);
    }

    public Optional<User> getByPublicId(PublicId userPublicId) {
        return userRepository.get(userPublicId);
    }
}
