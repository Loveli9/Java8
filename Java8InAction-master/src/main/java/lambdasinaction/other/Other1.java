package lambdasinaction.other;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class Other1 {

    @Test
    public void oldRunable() {
        new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("The old runable now is using!");
            }
        }).start();
    }

    @Test
    public void runable() {
        new Thread(() -> System.out.println("It's a lambda function!")).start();
    }

    /**
     * 如果熟悉scala的同学，肯定对forEach不陌生。
     * 它可以迭代集合中所有的对象，并且将lambda表达式带入其中。
     * */
    @Test
    public void iterTest() {
        List<String> languages = Arrays.asList("java","scala","python");
        //before java8
        for(String each:languages) {
            System.out.println(each);
        }
        //after java8
        languages.forEach(x -> System.out.println(x));
        languages.forEach(System.out::println);
    }

    @Test
    public void mapTest() {
        List<Double> cost = Arrays.asList(10.0, 20.0,30.0);
        cost.stream().map(x -> x + x*0.05).forEach(
                x -> System.out.println(x));
    }

    //map + reduce 聚合
    //map的作用是将一个对象变为另外一个，而reduce实现的则是将所有值合并为一个
    @Test
    public void mapReduceTest() {
        List<Double> cost = Arrays.asList(10.0, 20.0,30.0);
        double allCost = cost.stream().
                map(x -> x+x*0.05).
                reduce((sum,x) -> sum + x).get();
        System.out.println(allCost);
    }

    //filter也是我们经常使用的一个操作。在操作集合的时候，
    //经常需要从原始的集合中过滤掉一部分元素。
    @Test
    public void filterTest() {
        List<Double> cost = Arrays.asList(10.0, 20.0,30.0,40.0);
        List<Double> filteredCost = cost.stream().
                filter(x -> x > 25.0).
                collect(Collectors.toList());
//        filteredCost.forEach(x -> System.out.println(x));
        filteredCost.forEach(System.out::println);

    }

    public static void filterTest(List<String> languages,
                                  Predicate<String> condition) {
        languages.stream().
                filter(x -> condition.test(x)).
                forEach(x -> System.out.println(x + " "));
    }

    public static void main(String[] args) {
        List<String> languages = Arrays.asList(
                "Java","Python","scala","Shell","R");
        System.out.println("Language starts with J: ");
        filterTest(languages,x -> x.startsWith("J"));
        System.out.println("\nLanguage ends with a: ");
        filterTest(languages,x -> x.endsWith("a"));
        System.out.println("\nAll languages: ");
        filterTest(languages,x -> true);
        System.out.println("\nNo languages: ");
        filterTest(languages,x -> false);
        System.out.println("\nLanguage length bigger three: ");
        filterTest(languages,x -> x.length() > 4);
    }

}
