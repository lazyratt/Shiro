package me.ly.test;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.config.IniSecurityManagerFactory;
import org.apache.shiro.mgt.SecurityManager;
import org.apache.shiro.subject.Subject;
import org.junit.Test;

public class MyTest {

   @Test
    public void test(){
        //1.创建工厂类加载配置文件
        IniSecurityManagerFactory factory = new IniSecurityManagerFactory("classpath:myshiro.ini");
        //2.通过工厂类创建SecurityManager类
        SecurityManager securityManager = factory.getInstance();
        //3.将SecurityManager加载到当前环境中
        SecurityUtils.setSecurityManager(securityManager);
        //4.获取Subject 登录对象
        Subject subject = SecurityUtils.getSubject();
        //5.创建用于收集登录对象的信息(参数：用户名、密码)
        UsernamePasswordToken token = new UsernamePasswordToken("admin","admin");
        //6.登录
        subject.login(token);
        System.out.println("登录名："+subject.getPrincipal());
        //7.注销
        subject.logout();
    }
}
