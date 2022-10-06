package hacker;

import java.nio.file.Path;
import java.util.List;
import java.util.function.Predicate;

public class MainApp {
    public static void main(String[] args) {

        List<Address> addresses = FileReader.readFile(Path.of("resources/data_base.txt"));

        System.out.println("Restored database:");
        addresses.stream().forEach(System.out::println);

        addresses.stream().filter(addressPredicat()).map(Address::getResidents)
                .filter(checkPesel()).findAny()
                .ifPresent(residents -> residents.stream()
                        .filter(person -> person.getPesel().startsWith("72"))
                        .findAny()
                        .ifPresent(p -> System.out.println("Hacker is: " + p.getName() + " " + p.getSurname())));
    }

    private static Predicate<Address> addressPredicat() {
        return address -> address.getCity().contains("k")
                && getPostalSum(address.getPostalCode()) == 23;
    }

    private static Predicate<List<Person>> checkPesel() {
        return residents -> residents.stream().anyMatch(p -> p.getPesel().startsWith("72"));
    }

    private static int getPostalSum(String postalCod) {
        char[] chars = postalCod.toCharArray();
        return getInt(chars[0]) + getInt(chars[1]) + getInt(chars[3])
                + getInt(chars[4]) + getInt(chars[5]);
    }

    private static Integer getInt(char charr) {
        String num = String.valueOf(charr);
        return Integer.valueOf(num);
    }
}
