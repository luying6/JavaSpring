package main.java.com.spring.test;

import main.java.com.spring.javabean.User;
import main.java.com.spring.javabean.UserInfo;
import main.java.com.spring.service.ProduceService;
import main.java.com.spring.service.UserService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author luying
 * @date 2018/11/12
 */
public class TestSpring {
    public static void main(String[] args) {

        //初始化
        ApplicationContext context = new ClassPathXmlApplicationContext(new String[]{"main/res/applicationContext.xml"});

        //实例化user
        User user = (User) context.getBean("user");
        System.out.println(user.getName());
        System.out.println(user.getAge());
        System.out.println(user.getGender());
        System.out.println(user.getHeight());

        //引用实例化
        UserInfo userInfo = (UserInfo) context.getBean("userInfo");
        System.out.println(userInfo.userInfo());

        //cglib 三方动态代理(不需要接口)
        ProduceService produceService = (ProduceService) context.getBean("productService");
        produceService.doSth();

        //jdk自带动态代理方式(需接口)  （配置和注解2中方式调用不变）
        UserService userService = (UserService) context.getBean("userService");
        userService.find();
        System.out.println("---------------------------");
        userService.save();

    }
}
