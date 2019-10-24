package lambdasinaction.chap5;
import lambdasinaction.chap4.*;

import java.util.stream.*;
import java.util.*;
import static java.util.stream.Collectors.toList;

import static lambdasinaction.chap4.Dish.menu;

public class Filtering{

    public static void main(String...args){

        // Filtering with predicate
        List<Dish> vegetarianMenu =
            menu.stream()
                .filter(Dish::isVegetarian)
                .collect(toList());
        System.out.println("过滤收集");
        vegetarianMenu.forEach(System.out::println);

        // Filtering unique elements
        System.out.println("元素去重");
        List<Integer> numbers = Arrays.asList(1, 2, 1, 3, 3, 2, 4);
        numbers.stream()
               .filter(i -> i % 2 == 0)
               .distinct()
               .forEach(System.out::println);

        // Truncating a stream
        List<Dish> dishesLimit3 =
            menu.stream()
                .filter(d -> d.getCalories() > 300)
                .limit(3)
                .collect(toList());
        System.out.println("前三个元素");
        dishesLimit3.forEach(System.out::println);

        // Skipping elements 跳过前两个元素
        List<Dish> dishesSkip2 =
            menu.stream()
                .filter(d -> d.getCalories() > 300)
                .skip(2)
                .collect(toList());
        System.out.println("跳过前两个元素");
        dishesSkip2.forEach(System.out::println);
    }
}
