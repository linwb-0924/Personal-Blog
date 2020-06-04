package org.fjnu;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @author wb_Lin
 * @create 2020-04-03 14:00
 */
//标记本类为springboot的主程序类，说明是一个springboot应用

@SpringBootApplication
public class SpringbootMain {
    public static void main(String[] args) {
        SpringApplication.run(SpringbootMain.class,args);
    }
}
