package lambdasinaction.other.sort;

import org.junit.Before;
import org.junit.Test;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class UserTest {

    private static List<User> userList = new ArrayList<>();

    @Before
    public void init() {
        userList.add(new User(1L,"",1,"","nan",new Date(),new BigDecimal(1)));
    }

    @Test
    public void test1() {
        //分组
        Map<String, List<User>> groupBySex = userList.stream().collect(Collectors.groupingBy(User::getSex));
        //遍历分组
        for (Map.Entry<String, List<User>> entryUser : groupBySex.entrySet()) {
            String key = entryUser.getKey();
            List<User> entryUserList = entryUser.getValue();
        }

    }
}
