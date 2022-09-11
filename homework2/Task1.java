import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Objects;

import static java.util.stream.Collectors.groupingBy;

public class Task1 {
    static class Person {
        final int id;

        final String name;

        Person(int id, String name) {
            this.id = id;
            this.name = name;
        }

        public int getId() {
            return id;
        }

        public String getName() {
            return name;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (!(o instanceof Person person)) return false;
            return getId() == person.getId() && getName().equals(person.getName());
        }

        @Override
        public int hashCode() {
            return Objects.hash(getId(), getName());
        }
    }

    private static Person[] RAW_DATA = new Person[]{
            new Person(0, "Harry"),
            new Person(0, "Harry"), // дубликат
            new Person(1, "Harry"), // тёзка
            new Person(2, "Harry"),
            new Person(3, "Emily"),
            new Person(4, "Jack"),
            new Person(4, "Jack"),
            new Person(5, "Amelia"),
            new Person(5, "Amelia"),
            new Person(6, "Amelia"),
            new Person(7, "Amelia"),
            new Person(8, "Amelia"),
    };

    public static void main(String[] args) {
        System.out.println("Raw data:");
        System.out.println();

        for (Person person : RAW_DATA) {
            System.out.println(person.id + " - " + person.name);
        }

        System.out.println();
        System.out.println("**************************************************");
        System.out.println();
        System.out.println("Duplicate filtered, grouped by name, sorted by name and id:");
        System.out.println();

        solutionTask1();
    }

    /**
     * Task1
     * Убрать дубликаты, отсортировать по идентификатору, сгруппировать по имени
     *
     * Что должно получиться
     * Key:Amelia
     * Value:4
     * Key: Emily
     * Value:1
     * Key: Harry
     * Value:3
     * Key: Jack
     * Value:1
     */

    public static void solutionTask1() {
        Map<String, List<Person>> result = Arrays.stream(RAW_DATA)
                .distinct()
                .sorted((a, b) -> a.getId() - b.getId())
                .collect(groupingBy(Person::getName));

        result.forEach((key, value) -> System.out.printf("Key:%s\nValue:%d\n", key, value.size()));
    }
}
