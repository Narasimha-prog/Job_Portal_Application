package lnr.Job_Portal_Application.job.infrastructure.secondary.repository;

import lnr.Job_Portal_Application.job.domain.user.aggrigate.User;
import lnr.Job_Portal_Application.job.domain.user.repository.IUserRepository;
import lnr.Job_Portal_Application.job.domain.user.vo.AddressToUpdate;
import lnr.Job_Portal_Application.job.domain.user.vo.Email;
import lnr.Job_Portal_Application.job.domain.user.vo.PublicId;
import lnr.Job_Portal_Application.job.infrastructure.secondary.entity.UserEntity;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
@RequiredArgsConstructor
public class SpringDataUserRepository implements IUserRepository {

    private final IJpaUserRepository jpaUserRepository;

    @Override
    public void save(User user) {
        if (user.getDbId() != null) {
            Optional<UserEntity> userToUpdateOpt = jpaUserRepository.findById(user.getDbId());

            if (userToUpdateOpt.isPresent()) {
                UserEntity userToUpdate = userToUpdateOpt.get();
                userToUpdate.updateFromUser(user);
                jpaUserRepository.saveAndFlush(userToUpdate);
            }
        } else {
            jpaUserRepository.save(UserEntity.toEntity(user));
        }
    }

    @Override
    public Optional<User> get(PublicId userPublicId) {
        return jpaUserRepository.findOneByPublicId(userPublicId.value())
                .map(UserEntity::toDomain);
    }

    @Override
    public Optional<User> getOneByEmail(Email userEmail) {
        return jpaUserRepository.findByEmail(userEmail.value())
                .map(UserEntity::toDomain);
    }

    @Override
    public void updateAddress(AddressToUpdate userAddress) {
        jpaUserRepository.updateAddress(userAddress.userPublicId().value(),
                userAddress.userAddress().street(),
                userAddress.userAddress().city(),
                userAddress.userAddress().country(),
                userAddress.userAddress().zipCode());
    }
}
