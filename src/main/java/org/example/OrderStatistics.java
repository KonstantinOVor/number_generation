package org.example;

import java.util.Comparator;
import java.util.DoubleSummaryStatistics;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class OrderStatistics {
    public static Map<String, DoubleSummaryStatistics> groupAndSummarizeOrders(List<Order> orders) {
        return orders.stream()
                .collect(Collectors.groupingBy(Order::getProduct, Collectors.summarizingDouble(Order::getCost)));
    }

    public static void printProductCostSummary(Map<String, DoubleSummaryStatistics> totalCostPerProduct) {
        totalCostPerProduct.forEach((product, stats) -> {
            System.out.println(product + ": " + stats.getSum());
        });
    }

    public static List<Order> sortProductsByCost(List<Order> orders) {
        return orders.stream()
                .sorted(Comparator.comparingDouble(Order::getCost).reversed())
                .toList();
    }

    public static void printList(List<Order> orders) {
        orders.forEach(System.out::println);
        System.out.println("---------------------------------------------------------");
    }

    public static void printMap(Map<String, DoubleSummaryStatistics> totalCostPerProduct){
        totalCostPerProduct.forEach((product, stats) -> {
            System.out.println(product + ": " + stats.getSum());
        });
        System.out.println("---------------------------------------------------------");
    }

    public static List<Order> findTopThreeExpensiveProducts(List<Order> orders) {
        return orders.stream()
                .sorted(Comparator.comparingDouble(Order::getCost).reversed())
                .limit(3)
                .collect(Collectors.toList());
    }

    public static void printTopThreeProducts(List<Order> topThreeExpensiveProducts) {
        System.out.println("Топ 3 самых дорогих продукта:");
        double totalCost = 0.0;
        for (Order order : topThreeExpensiveProducts) {
            System.out.println(order.getProduct());
            totalCost = topThreeExpensiveProducts.stream()
                    .mapToDouble(Order::getCost)
                    .sum();
        }
        System.out.println("Общая стоимость: " + totalCost);
    }
}
