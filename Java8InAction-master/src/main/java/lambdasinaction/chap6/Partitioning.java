package lambdasinaction.chap6;

import java.util.*;

import static java.util.Comparator.comparingInt;
import static java.util.stream.Collectors.*;
import static lambdasinaction.chap6.Dish.menu;

public class Partitioning {

    public static void main(String ... args) {
        /**
         * 分区统计
         * */
        //按照是否素食者分区
        System.out.println("Dishes partitioned by vegetarian: " + partitionByVegeterian());
        //按照是否素食者分区，里面再按照类型分组
        System.out.println("Vegetarian Dishes by type: " + vegetarianDishesByType());
        //按照是否素食者分区，计算最大的卡路里
        System.out.println("Most caloric dishes by vegetarian: " + mostCaloricPartitionedByVegetarian());
    }

    private static Map<Boolean, List<Dish>> partitionByVegeterian() {
        return menu.stream().collect(partitioningBy(Dish::isVegetarian));
    }

    private static Map<Boolean, Map<Dish.Type, List<Dish>>> vegetarianDishesByType() {
        return menu.stream().collect(partitioningBy(Dish::isVegetarian, groupingBy(Dish::getType)));
    }

    private static Object mostCaloricPartitionedByVegetarian() {
        return menu.stream().collect(
                partitioningBy(Dish::isVegetarian,
                        collectingAndThen(
                                maxBy(comparingInt(Dish::getCalories)),
                                Optional::get)));
    }
}

