/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rest;

import domain.User;
import java.util.stream.Stream;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Bean;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

/**
 *
 * @author Maciek
 */
@SpringBootApplication
@EnableJpaRepositories(basePackageClasses= {UserRepository.class})
@EntityScan("domain")
public class Application {
 
    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }
 
    @Bean
    CommandLineRunner init(UserRepository userRepository) {
        return args -> {
            Stream.of("John","Julie","Jennifer","Helen","Rachel").forEach(name->{
                User user = new User(name, name.toLowerCase() + "@domain.com");
                userRepository.save(user);
                System.out.println(user.getName());
            });
            userRepository.findAll().forEach(System.out::println);
        };
    }
}
