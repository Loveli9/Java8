package lambdasinaction.other.sort;

import org.junit.Test;

public class Java8Test {

    @Test
    public void test1() {
        //行为参数化
        Runnable r1 = () -> System.out.println("Hello World11");
        process(r1);
        process(() -> System.out.println("Hello World11"));
    }

    private static void process(Runnable r) {
        r.run();
    }

}
