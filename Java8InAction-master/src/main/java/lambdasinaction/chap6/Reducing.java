package lambdasinaction.chap6;

import static java.util.stream.Collectors.*;
import static lambdasinaction.chap6.Dish.menu;

public class Reducing {

    public static void main(String ... args) {
        //计算总共的卡路里
        System.out.println("Total calories in menu: " + calculateTotalCalories());
        //计算总共的卡路里
        System.out.println("Total calories in menu: " + calculateTotalCaloriesWithMethodReference());
        //计算总共的卡路里
        System.out.println("Total calories in menu: " + calculateTotalCaloriesWithoutCollectors());
        //计算总共的卡路里
        System.out.println("Total calories in menu: " + calculateTotalCaloriesUsingSum());
    }

    private static int calculateTotalCalories() {
        return menu.stream().collect(reducing(0,
                Dish::getCalories, (Integer i, Integer j) -> i + j));
    }

    private static int calculateTotalCaloriesWithMethodReference() {
        return menu.stream().collect(reducing(0, Dish::getCalories, Integer::sum));
    }

    private static int calculateTotalCaloriesWithoutCollectors() {
        int max = menu.stream().map(Dish::getCalories).reduce(Integer::max).get();
        System.out.println("max = " + max);
        return menu.stream().map(Dish::getCalories).reduce(Integer::sum).get();
    }

    private static int calculateTotalCaloriesUsingSum() {
        return menu.stream().mapToInt(Dish::getCalories).sum();
    }
}