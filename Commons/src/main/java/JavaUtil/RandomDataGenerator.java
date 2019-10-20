package JavaUtil;

import org.apache.commons.lang3.RandomStringUtils;

import java.util.Random;

public class RandomDataGenerator {

    private final String[] syllables = {"the","ren","ina","ona","co","he","be","rea","ha","wa","fo","whe","ma","wi","mark",
            "john","stay","sill","of", "di","al","ar","li","wo","fry","pa","me","at","su","bu","ta","da","ab","ti","ro",
            "mu","ea","na","sca","ad","ge","bye","afa","aga","up","my","ob","ke","ef","ph","ci","ki","ni","ty"};

    public String newPassword(int minLength, int maxLength) {
        Random random = new Random();
        int length = random.nextInt(maxLength - minLength) + minLength;
        return RandomStringUtils.randomAlphanumeric(length);
    }

    private String newWord(int syllablesCount) {
        StringBuilder word = new StringBuilder();

        for(int i = 0; i < syllablesCount; i++) {
            word.append(randomSyllable());
        }

        return Character.toUpperCase(word.charAt(0)) + word.substring(1);
    }

    private String randomSyllable() {
        Random random = new Random();
        int max = syllables.length;

        return syllables[random.nextInt(max)];
    }

    public String newWord() {
        Random random = new Random();
        int syllablesCount = random.nextInt(2) + 2;

        return newWord(syllablesCount);
    }

    public String newPhone(int digitCount) {
        return "+" + newNumber(digitCount);
    }

    public String newNumber(int digitCount) {
        return RandomStringUtils.randomNumeric(digitCount);
    }

    private String newNumber() {
        Random random = new Random();
        int digitCount = random.nextInt(8) + 1;

        return newNumber(digitCount);
    }

    public String newEmail() {
        return newWord() + newNumber() + "@" + newWord() + "." + randomSyllable();
    }

}
