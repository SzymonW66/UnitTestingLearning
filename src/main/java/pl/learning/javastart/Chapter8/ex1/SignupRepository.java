package pl.learning.javastart.Chapter8.ex1;

import java.util.Set;

public interface SignupRepository {
    Set<Signup> findUserById(Long userId);
    void save (Signup signup);
}
