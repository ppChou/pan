package com.lhx;

import com.lhx.model.User;
import com.lhx.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.List;

@SpringBootApplication
public class SpringbootApplication {

    @Autowired
    private UserRepository userRepository;

    public static void main(String[] args) {
        SpringApplication.run(SpringbootApplication.class, args);
    }

//    @Override
//    public void run(String... args) throws Exception {
//        try {
//            User user = new User();
//            user.setName("张三");
//            user.setAge(2);
//            userRepository.save(user);
//            List<User> u = userRepository.findByNameLike("%张三%");
//            System.out.println(u.size());
//            User  us =  userRepository.findByAge(2);
//            System.out.println(us.getAge());
//            us =  userRepository.findByName("这是你干");
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//    }
}