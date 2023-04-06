package models.enums;

import java.util.Random;

public enum Option {
    ROCK,
    PAPER,
    SCISSORS;

    private static final Random random = new Random();


    // Essa função vai sortear um atributo aleatório, será usado pela IA
    public static Option getRandomOption(){
        int index = random.nextInt(values().length);
        return values()[index];
    }
}
