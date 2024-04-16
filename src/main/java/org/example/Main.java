package org.example;

import java.util.Comparator;
import java.util.DoubleSummaryStatistics;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {

        List<Order> orders = List.of(
                new Order("Laptop", 1200.0),
                new Order("Smartphone", 800.0),
                new Order("Laptop", 1500.0),
                new Order("Tablet", 500.0),
                new Order("Smartphone", 900.0)
        );
        System.out.println();

        // Группируем заказы по продуктам
        Map<String, DoubleSummaryStatistics> groupedOrders = OrderStatistics.groupAndSummarizeOrders(orders);
        OrderStatistics.printMap(groupedOrders);

        // Сортируем продукты по убыванию общей стоимости
        List<Order> sortedByCost = OrderStatistics.sortProductsByCost(orders);
        OrderStatistics.printList(sortedByCost);


        // Выбираем три самых дорогих продукта
        List<Order> topThreeExpensiveProducts = OrderStatistics.findTopThreeExpensiveProducts(orders);
        OrderStatistics.printList(topThreeExpensiveProducts);

        // Выводим результат: список трех самых дорогих продуктов и их общая стоимость
        OrderStatistics.printTopThreeProducts(topThreeExpensiveProducts);
    }
}