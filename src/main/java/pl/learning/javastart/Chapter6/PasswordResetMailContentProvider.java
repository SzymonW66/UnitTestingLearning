package pl.learning.javastart.Chapter6;

public class PasswordResetMailContentProvider {
    private RandomProvider randomProvider;

    public PasswordResetMailContentProvider(RandomProvider randomProvider) {
        this.randomProvider = randomProvider;
    }

    public String createResetMailContent(){
        String template = "Cześć co tam";
        String randomKey = randomProvider.generateRandom();
        return String.format(template, randomKey);
    }
}
