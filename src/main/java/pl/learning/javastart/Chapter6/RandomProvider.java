package pl.learning.javastart.Chapter6;

import java.util.UUID;

public class RandomProvider {

    public String generateRandom(){
        return UUID.randomUUID().toString();
    }
}
