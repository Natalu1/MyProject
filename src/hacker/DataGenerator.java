package hacker;

import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

public final class DataGenerator {

    private static final List<String> NAMES = List.of("Adam", "Agata", "Basia", "Konrad", "Kamil", "Marcin", "Ania",
            "Kasia", "Basia", "Alicja", "Marta", "Julia", "Viola", "Michał", "Aleksander", "Tatiana", "Bogumił", "Ben");

    private static final List<String> SURNAMES = List.of("Kowal", "Dadel", "Berek", "Grzeszek", "Madonna", "Krowa",
            "Guma", "Apaka", "Wójtowicz", "Nowak", "Dodora", "Lach", "Krzyk", "Felga", "Wiadro");


    public static List<String> generateNPesels(int n) {
        Random random = new Random();

        return random.longs(70000000000L, 99999999999L)
                .limit(n)
                .mapToObj(String::valueOf)
                .collect(Collectors.toList());
    }

    public static String generatePesel() {
        Random random = new Random();
        return random.longs(70000000000L, 99999999999L)
                .limit(1)
                .mapToObj(String::valueOf)
                .findAny().get();
    }

    public static String getRandomName() {
        return NAMES.get(new Random().nextInt(NAMES.size() - 1));
    }

    public static String getRandomSurname() {
        return SURNAMES.get(new Random().nextInt(SURNAMES.size() - 1));
    }
}
