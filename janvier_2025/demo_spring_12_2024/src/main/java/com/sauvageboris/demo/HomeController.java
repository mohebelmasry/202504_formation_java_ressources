package com.sauvageboris.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;
import java.util.Optional;

@Controller
public class HomeController {

    @Autowired
    UserRepository userRepository;

    @GetMapping("/save")
    public void save(){
        User user = new User("B", "S", "email");
        userRepository.save(user);
    }

    @GetMapping("/")
    public String displayHomePage(Model model){
        List<User> userList = (List<User>) userRepository.findAll();
        Optional<User> uOpt = userList.stream().findFirst();
        if(uOpt.isPresent()){
            User user = uOpt.get();
            model.addAttribute("name", user.getFirstName());
        }
        return "home.html";
    }


}
