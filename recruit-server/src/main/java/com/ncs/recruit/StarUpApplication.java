package com.ncs.recruit;

import java.net.InetAddress;
import java.net.UnknownHostException;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.core.env.Environment;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import lombok.extern.slf4j.Slf4j;
import tk.mybatis.spring.annotation.MapperScan;

/**
 * 主程序入口
 *
 * @author nanfeng
 * @date 2019年10月7日
 */
@Slf4j
@SpringBootApplication(scanBasePackages = { "com.github.skunk", "com.ncs.recruit" })
@EnableTransactionManagement
@MapperScan(basePackages = { "com.ncs.recruit.context.*.mapper" })
public class StarUpApplication implements CommandLineRunner {

    public static void main(String[] args) throws UnknownHostException {
        SpringApplication app = new SpringApplication(StarUpApplication.class);
        Environment env = app.run(args).getEnvironment();
        String protocol = "http";
        if (env.getProperty("server.ssl.key-store") != null) {
            protocol = "https";
        }

        log.info("\n----------------------------------------------------------\n\t"
                + "Application '{}' is running! Access URLs:\n\t"
                + "Local: \t\t{}://localhost:{}\n\t"
                + "External: \t{}://{}:{}\n\t"
                + "Version: \t{}\n\t"
                + "Profile(s): \t{}\n----------------------------------------------------------",
            env.getProperty("spring.application.name"),
            protocol, env.getProperty("server.port"),
            protocol,
            InetAddress.getLocalHost().getHostAddress(),
            env.getProperty("server.port"),
            env.getProperty("spring.application.version"),
            env.getActiveProfiles());
    }

    @Override
    public void run(String... args) throws Exception {

    }
}
