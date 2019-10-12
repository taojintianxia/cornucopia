package com.github.taojintianxia.vault.springbootexample.config;

/**
 * @author Nianjun Sun
 * @date 2019/10/12 11:05
 */
import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * @author Mark Paluch
 */
@ConfigurationProperties("example")
public class MyConfiguration {

    private String username;

    private String password;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}