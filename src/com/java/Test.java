package com.java;

import com.sun.deploy.util.StringUtils;

import javax.print.attribute.standard.DateTimeAtCompleted;
import java.math.BigDecimal;
import java.security.PrivateKey;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Date;
import java.util.List;

/**
 * @Description:
 * @Author yupengfei
 * @date 2019/12/24
 */

public class Test {
    public static void main(String[] args) {
        method4();
    }

    public static void method4(){
        String domainsInfo = "";
        String[] domains = domainsInfo.split(",");
        System.out.println(domains);
    }

    public static void method1(){
        Date curdate = new Date();
        List<DCouponDTO> dtoList = new ArrayList<DCouponDTO>();
        DCouponDTO dto1 = new DCouponDTO();
        dto1.setValue(BigDecimal.ZERO);
        dto1.setExpiredTime(new Date(4));

        DCouponDTO dto2 = new DCouponDTO();
        dto2.setValue(BigDecimal.ONE);
        dto2.setExpiredTime(new Date(3));

        DCouponDTO dto3 = new DCouponDTO();
        dto3.setValue(new BigDecimal("20"));
        dto3.setExpiredTime(new Date(2));

        DCouponDTO dto4 = new DCouponDTO();
        dto4.setValue(new BigDecimal("20"));
        dto4.setExpiredTime(new Date(1));


        dtoList.add(dto1);
        dtoList.add(dto2);
        dtoList.add(dto3);
        dtoList.add(dto4);


        DCouponDTO cur = dtoList.stream().filter(x-> x.getValue()!=null)
                .max(Comparator.comparing(DCouponDTO::getValue).thenComparing(DCouponDTO::getExpiredTime,Comparator.reverseOrder()))
                .orElse(null);
        System.out.println(cur.getValue()+","+cur.getExpiredTime().getTime());
    }

    public static void method2(){
        String addressBookName = "";
        String mobileNum = "15176776411";
        char[] mobileNumChar = mobileNum.toCharArray();
        addressBookName = String.copyValueOf(mobileNumChar,0,3)+"****"+String.copyValueOf(mobileNumChar,7,4);
        System.out.println(addressBookName);
    }

    public static void method3(){
        B b = new B();
        b.setId("B");
        b.setName("bbbbbb");

        A a = b;

        b = (B)a;

        System.out.println(b.getName());

    }

}

class A {
    private String id;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
}
class B extends  A{
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}

class C {

}

class DCouponDTO{
    private BigDecimal value;

    private Date expiredTime;

    public BigDecimal getValue() {
        return value;
    }

    public void setValue(BigDecimal value) {
        this.value = value;
    }

    public Date getExpiredTime() {
        return expiredTime;
    }

    public void setExpiredTime(Date expiredTime) {
        this.expiredTime = expiredTime;
    }
}