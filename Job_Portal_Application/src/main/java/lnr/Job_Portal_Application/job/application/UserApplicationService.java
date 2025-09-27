package lnr.Job_Portal_Application.job.application;

import lnr.Job_Portal_Application.job.domain.user.service.UserReader;
import lnr.Job_Portal_Application.job.domain.user.service.UserRegistration;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserApplicationService {
    private final UserReader userReader;
    private final UserRegistration userRegistration;

}
