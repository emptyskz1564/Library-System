package com.liu.library.config;

import org.apache.shiro.spring.web.ShiroFilterFactoryBean;
import org.apache.shiro.web.mgt.DefaultWebSecurityManager;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class shiroConfig {

    //shiroFilterFactoryBean : 3
    @Bean
    public ShiroFilterFactoryBean getShiroFilterFactoryBean(@Qualifier("getDefaultWebSecurityManager") DefaultWebSecurityManager WebSecurityManager ){
        ShiroFilterFactoryBean shiroFilterFactoryBean = new ShiroFilterFactoryBean();
        //设置安全管理器
        shiroFilterFactoryBean.setSecurityManager(WebSecurityManager);
        return shiroFilterFactoryBean;
    }

    //DefaultWebSecurityManager : 2
    @Bean
    public DefaultWebSecurityManager getDefaultWebSecurityManager(@Qualifier("getUserRealm") userRealm UserRealm){
        DefaultWebSecurityManager SecurityManager = new DefaultWebSecurityManager();
        //关联Realm
        SecurityManager.setRealm(UserRealm);
        return SecurityManager;
    }

    //创建Realm对象 需要自定义类 : 1
    @Bean
    public userRealm getUserRealm(){
        return new userRealm();
    }
}
