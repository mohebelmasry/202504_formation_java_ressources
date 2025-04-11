package com.training.revision.service;

import com.training.revision.model.User;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {
//    @Autowired
//    private RestTemplate restTemplate;

    public List<User> findAll() {
        //String url = "https://jsonplaceholder.typicode.com/users";
        //return restTemplate.getForObject(url, String.class);
        User u1 = new User("B", "S");
        User u2 = new User("A", "D");
        return List.of(u1, u2);
    }
}
