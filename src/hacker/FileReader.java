package hacker;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

public class FileReader {

    public static List<Address> readFile(Path path) {
        List<Address> addresses = new ArrayList<>();
        try {
            List<String> data = Files.readAllLines(path);
            data.stream().forEach(rowData -> {
                String[] columns = rowData.split(";");
                Address address = getAddress(columns);
                Person person = getPerson(columns);

                addresses.stream().filter(a -> a.equals(address)).findAny()
                        .ifPresentOrElse(a -> a.addResident(person), () -> {
                            address.addResident(person);
                            addresses.add(address);
                        });
            });
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return addresses;
    }

    private static Person getPerson(String[] columns) {
        String pesel = !"".equals(columns[0]) ? columns[0] : DataGenerator.generatePesel();
        String name = !"".equals(columns[1]) ? columns[1] : DataGenerator.getRandomName();
        String surname = !"".equals(columns[2]) ? columns[2] : DataGenerator.getRandomSurname();
        return new Person(pesel, name, surname);
    }

    private static Address getAddress(String[] columns) {
        String city = !"".equals(columns[5]) ? columns[5] : ResidentDataGenerator.getRandomCity();
        String postalCode = !"".equals(columns[4]) ? columns[4] : ResidentDataGenerator.getRandomPostal();
        String street = !"".equals(columns[3]) ? columns[3] : ResidentDataGenerator.getRandomStreet();
        return new Address(city, street, postalCode);
    }

}
