package pers.zhaoqi.solstice;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;


@MapperScan("pers.zhaoqi.solstice.*.mapper")
@SpringBootApplication
public class SolsticeApplication {

    public static void main(String[] args) {
        SpringApplication.run(SolsticeApplication.class, args);
    }

}
