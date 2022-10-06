package hacker;

import java.util.List;
import java.util.Random;

public final class ResidentDataGenerator {

    private static final List<String> CITIES = List.of("Wrocław", "Warszawa", "Poznań", "Kraków", "Gdańsk", "Katowice");

    private static final List<String> STREETS = List.of("Malarska", "Kocia", "Ciepła", "Chrobrego", "Michalczyka", "Pełczyńska",
            "Borowska", "Wyszyńskiego", "Grunwaldzka");

    public static String getRandomStreet() {
        Random random = new Random();
        return STREETS.get(random.nextInt(STREETS.size() - 1)) + " " + random.nextInt(1, 150);
    }

    public static String getRandomCity() {
        Random random = new Random();
        return CITIES.get(random.nextInt(CITIES.size() - 1));
    }

    public static String getRandomPostal() {
        Random random = new Random();
        return "5" + random.nextInt(9) + "-" + random.nextInt(100, 999);
    }
}
