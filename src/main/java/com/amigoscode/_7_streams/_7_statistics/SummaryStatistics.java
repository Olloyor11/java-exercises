package com.amigoscode._7_streams._7_statistics;

import java.util.DoubleSummaryStatistics;
import java.util.IntSummaryStatistics;
import java.util.List;
import java.util.SortedMap;
import java.util.stream.Collectors;

/**
 * Exercise: Summary Statistics
 *
 * Learn how to use IntSummaryStatistics, DoubleSummaryStatistics,
 * and LongSummaryStatistics to compute multiple aggregate values
 * (count, sum, min, max, average) in a single pass.
 */
public class SummaryStatistics {

    record Sale(String product, double amount, int unitsSold) {}

    public static void main(String[] args) {
        List<Integer> scores = List.of(85, 92, 78, 95, 88, 73, 91, 82, 97, 76);

        List<Sale> sales = List.of(
                new Sale("Product A", 150.0, 10),
                new Sale("Product B", 200.0, 5),
                new Sale("Product C", 75.0, 20),
                new Sale("Product D", 300.0, 3),
                new Sale("Product E", 125.0, 12)
        );

        List<Integer> batch1 = List.of(10, 20, 30, 40, 50);
        List<Integer> batch2 = List.of(60, 70, 80, 90, 100);

        // TODO: 1 - Get IntSummaryStatistics from the 'scores' list
        //           Use mapToInt and summaryStatistics()
        //           Store the result in a variable
        System.out.println("TODO: 1 ");
        IntSummaryStatistics  scor = scores.stream().mapToInt(score -> score).summaryStatistics();
        System.out.println();


        // TODO: 2 - Print the count, sum, min, max, and average from the
        //           IntSummaryStatistics obtained in TODO 1
        //           Use getCount(), getSum(), getMin(), getMax(), getAverage()
        System.out.println("TODO: 2 ");
        System.out.println(scor.getCount());
        System.out.println(scor.getSum());
        System.out.println(scor.getMin());
        System.out.println(scor.getMax());
        System.out.println(scor.getAverage());
        System.out.println();


        // TODO: 3 - Use the Collectors.summarizingInt() collector to get
        //           IntSummaryStatistics for unitsSold from 'sales'
        //           Print the result
        System.out.println("TODO: 3 ");
        IntSummaryStatistics collector = sales.stream().collect(Collectors.summarizingInt(s -> s.unitsSold()));
        System.out.println(collector);
        System.out.println();

        // TODO: 4 - Create DoubleSummaryStatistics for the sale amounts from 'sales'
        //           Use mapToDouble and summaryStatistics()
        //           Print all the statistics
        System.out.println("TODO: 4 ");
        DoubleSummaryStatistics amountsFromSales = sales.stream().mapToDouble(s -> s.amount()).summaryStatistics();
        System.out.println(amountsFromSales);
        System.out.println();

        // TODO: 5 - Combine two IntSummaryStatistics:
        //           Create stats for 'batch1' and 'batch2' separately,
        //           then use the combine() method to merge them
        //           Print the combined statistics
        System.out.println("TODO: 5 ");
        IntSummaryStatistics statistics1 = batch1.stream().mapToInt(b -> b).summaryStatistics();
        IntSummaryStatistics statistics2 = batch2.stream().mapToInt(b -> b).summaryStatistics();
        statistics1.combine(statistics2);
        System.out.println(statistics1);

    }
}
