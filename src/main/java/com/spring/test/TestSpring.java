package main.java.com.spring.test;

import main.java.com.spring.javabean.User;
import main.java.com.spring.javabean.UserInfo;
import main.java.com.spring.service.ProduceService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author luying
 * @date 2018/11/12
 */
public class TestSpring {

    public void test(){

    }


    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext(new String[]{"main/res/applicationContext.xml"});
        User user = (User) context.getBean("user");
        System.out.println(user.getName());
        System.out.println(user.getAge());
        System.out.println(user.getGender());
        System.out.println(user.getHeight());
        UserInfo userInfo = (UserInfo) context.getBean("userInfo");
        System.out.println(userInfo.userInfo());

        ProduceService produceService = (ProduceService) context.getBean("productService");
        produceService.doSth();
    }
}
