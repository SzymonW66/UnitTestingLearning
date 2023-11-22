package pl.learning.javastart.Chapter8.ex1;

import java.time.ZonedDateTime;
import java.util.Optional;
import java.util.Set;

public class SignupService {
    private final SignupRepository signupRepository;
    private final DateTimeProvider dateTimeProvider;

    public SignupService(SignupRepository signupRepository, DateTimeProvider dateTimeProvider) {
        this.signupRepository = signupRepository;
        this.dateTimeProvider = dateTimeProvider;
    }

    public void createSignup(Long userId, long courseId){

        Set<Signup> signups = signupRepository.findUserById(userId);

        Optional<Signup> existingSignupOptional = signups.stream()
                .filter(s -> s.getCourseId().equals(courseId))
                .findFirst();
        Signup signup = new Signup();

        if (existingSignupOptional.isPresent()) {
            Signup existingSignup = existingSignupOptional.get();
            signup.setFrom(existingSignup.getTo());
            signup.setTo(existingSignup.getTo().plusYears(1));
        } else {
            ZonedDateTime now = dateTimeProvider.now();
            signup.setFrom(now);
            signup.setTo(now.plusYears(1));
        }
        signup.setUserId(userId);
        signup.setCourseId(courseId);
        signupRepository.save(signup);
    }
}
