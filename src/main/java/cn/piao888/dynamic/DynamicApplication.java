package cn.piao888.dynamic;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
//https://blog.csdn.net/u012881904/article/details/77449710?depth_1-utm_source=distribute.pc_relevant.none-task-blog-BlogCommendFromBaidu-2&utm_source=distribute.pc_relevant.none-task-blog-BlogCommendFromBaidu-2
//参考文章
@SpringBootApplication(exclude = { DataSourceAutoConfiguration.class })
public class DynamicApplication {

    public static void main(String[] args) {
        SpringApplication.run(DynamicApplication.class, args);
    }

}
