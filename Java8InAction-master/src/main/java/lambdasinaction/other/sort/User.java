package lambdasinaction.other.sort;

import lombok.Data;
import lombok.Generated;
import java.math.BigDecimal;
import java.util.Date;

@Generated
@Data
public class User {

    private Long id;

    //姓名
    private String name;

    //年龄
    private int age;

    //工号
    private String jobNumber;

    //性别
    private String sex;

    //入职日期
    private Date entryDate;

    //家庭成员数量
    private BigDecimal familyMemberQuantity;

    public User(Long id, String name, int age, String jobNumber, String sex, Date entryDate, BigDecimal familyMemberQuantity) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.jobNumber = jobNumber;
        this.sex = sex;
        this.entryDate = entryDate;
        this.familyMemberQuantity = familyMemberQuantity;
    }

    public void setFamilyMemberQuantity(BigDecimal familyMemberQuantity) {
        this.familyMemberQuantity = familyMemberQuantity;
    }
}
