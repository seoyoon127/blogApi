package me.leeseoyoon.springbootdeveloper;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import io.github.cdimascio.dotenv.Dotenv;

@SpringBootApplication
@EnableJpaAuditing
public class SpringBootDeveloperApplication {
    public static void main(String[] args) {
        // .env 파일 읽기
        Dotenv dotenv = Dotenv.load();
        // 환경변수로 등록 (시스템 프로퍼티로 설정)
        System.setProperty("CLIENT_ID", dotenv.get("CLIENT_ID"));
        System.setProperty("CLIENT_SECRET", dotenv.get("CLIENT_SECRET"));
        SpringApplication.run(SpringBootDeveloperApplication.class, args);
    }
}