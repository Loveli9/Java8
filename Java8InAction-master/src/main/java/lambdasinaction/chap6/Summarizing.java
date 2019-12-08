package lambdasinaction.chap6;

import java.util.*;
import java.util.function.*;

import static java.util.stream.Collectors.*;
import static lambdasinaction.chap6.Dish.menu;

public class Summarizing {

    public static void main(String ... args) {
        //记录总数
        System.out.println("Nr. of dishes: " + howManyDishes());
        //卡路里最多
        System.out.println("The most caloric dish is: " + findMostCaloricDish());
        //卡路里最多
        System.out.println("The most caloric dish is: " + findMostCaloricDishUsingComparator());
        //卡路里总数
        System.out.println("Total calories in menu: " + calculateTotalCalories());
        //卡路里平均值
        System.out.println("Average calories in menu: " + calculateAverageCalories());
        //卡路里汇总：总数，max，min，sum，平均值
        System.out.println("Menu statistics: " + calculateMenuStatistics());
        //记录总数
        System.out.println("Short menu: " + getShortMenu());
        //记录总数
        System.out.println("Short menu comma separated: " + getShortMenuCommaSeparated());
    }


    private static long howManyDishes() {
        return menu.stream().collect(counting());
    }

    private static Dish findMostCaloricDish() {
        return menu.stream().collect(reducing((d1, d2) -> d1.getCalories() > d2.getCalories() ? d1 : d2)).get();
    }

    private static Dish findMostCaloricDishUsingComparator() {
        Comparator<Dish> dishCaloriesComparator = Comparator.comparingInt(Dish::getCalories);
        BinaryOperator<Dish> moreCaloricOf = BinaryOperator.maxBy(dishCaloriesComparator);
        return menu.stream().collect(reducing(moreCaloricOf)).get();
    }

    private static int calculateTotalCalories() {
        return menu.stream().collect(summingInt(Dish::getCalories));
    }

    private static Double calculateAverageCalories() {
        return menu.stream().collect(averagingInt(Dish::getCalories));
    }

    private static IntSummaryStatistics calculateMenuStatistics() {
        return menu.stream().collect(summarizingInt(Dish::getCalories));
    }

    private static String getShortMenu() {
        return menu.stream().map(Dish::getName).collect(joining(","));
    }

    private static String getShortMenuCommaSeparated() {
        return menu.stream().map(Dish::getName).collect(joining(", "));
    }
}
