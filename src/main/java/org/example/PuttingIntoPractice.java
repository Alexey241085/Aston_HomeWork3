package org.example;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class PuttingIntoPractice {

    public static void main(String... args) {
        Trader raoul = new Trader("Raoul", "Cambridge");
        Trader mario = new Trader("Mario", "Milan");
        Trader alan = new Trader("Alan", "Cambridge");
        Trader brian = new Trader("Brian", "Cambridge");

        List<Transaction> transactions = Arrays.asList(
                new Transaction(brian, 2011, 300),
                new Transaction(raoul, 2012, 1000),
                new Transaction(raoul, 2011, 400),
                new Transaction(mario, 2012, 710),
                new Transaction(mario, 2012, 700),
                new Transaction(alan, 2012, 950)
        );
//1. Найти все транзакции за 2011 год и отсортировать их по сумме (от меньшей
//к большей).

        System.out.println("список транзакций за 2011 год. ");
        transactions.stream().filter(t -> t.getYear() == 2011).toList()
                .stream().sorted(Comparator.comparing(Transaction::getValue))
                .forEach(System.out::println);

// Вывести список неповторяющихся городов, в которых работают трейдеры.
        System.out.println();

        transactions.stream().map(e -> e.getTrader().getCity()).toList()
                .stream()
                .distinct().forEach(System.out::println);

//3. Найти всех трейдеров из Кембриджа и отсортировать их по именам.
        System.out.println();

        System.out.println("все трейдеры из Кембриджа и отсортированные по имени.");

        transactions.stream()
                .filter(e -> e.getTrader().getCity().equals("Cambridge")).toList()
                .stream().sorted((o1, o2) -> o1.getTrader().getName().compareTo(o2.getTrader().getName()))
                .toList().forEach(System.out::println);

// 4. Вернуть строку со всеми именами трейдеров, отсортированными в алфавитном
//порядке.
        System.out.println();

        System.out.println(String.join(", ", transactions.stream().map(e -> e.getTrader().getName()).toList()
                .stream().sorted().toList()));

// 5. Выяснить, существует ли хоть один трейдер из Милана.
        System.out.println();
        System.out.println("Выяснить, существует ли хоть один трейдер из Милана.");

        System.out.println(transactions.stream().anyMatch(e -> e.getTrader().getCity().equalsIgnoreCase("milan")));



//6. Вывести суммы всех транзакций трейдеров из Кембриджа.
        System.out.println();
        System.out.println("Cумма всех трейдеров из Кембриджа " + transactions.stream().filter(e -> e.getTrader().getCity().equalsIgnoreCase("Cambridge")).toList().
                stream().map(Transaction::getValue).reduce(0, Integer::sum));


// 7. Какова максимальная сумма среди всех транзакций?
//
        System.out.println("сумма всех транзакций " + transactions.stream().mapToInt(Transaction::getValue).sum());

//8. Найти транзакцию с минимальной суммой.

        System.out.println("Транзакция с минимальной суммой " + transactions.stream().mapToInt(Transaction::getValue).min());


    }
}
