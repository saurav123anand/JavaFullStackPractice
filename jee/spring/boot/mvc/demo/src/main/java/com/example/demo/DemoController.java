package com.example.demo;

import jdk.internal.icu.text.NormalizerBase;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

@Controller
public class DemoController {
    Map<Integer, User> store = new HashMap<>();

    public DemoController() {

    }

    private int generateId;

    private int getGenerateId() {
        return ++generateId;
    }


    //complete method
    //http://localhost:8585/greet
    @GetMapping("/greet")
    public ModelAndView greeting() {
        String message = "welcome to spring mvc";
        ModelAndView modelAndView = new ModelAndView("welcome", "msg", message);
        return modelAndView;
    }

    //http://localhost:8585/getuser?id
    @GetMapping("/getuser")
    public ModelAndView getUser() {
        ModelAndView modelAndView = new ModelAndView("getuser");
        return modelAndView;
    }
    @GetMapping("/userdetails")
    public ModelAndView userDetails(@RequestParam int id) {
        User user = store.get(id);
        ModelAndView modelAndView = new ModelAndView("userprofile", "user", user);
        return modelAndView;
    }

    @GetMapping("/add")
    public ModelAndView addUserPage() {
         ModelAndView modelAndView=new ModelAndView("adduser");
         return modelAndView;
    }
    @GetMapping("/processeduser")
    public RedirectView addUser(@RequestParam String name,@RequestParam int age){
        int id=getGenerateId();
        User user=new User(name,age);
        user.setId(id);
        store.put(id,user);
        String url="/userdetails?id="+id;
        RedirectView redirectView=new RedirectView(url);
        return redirectView;
    }
    @GetMapping("/findall")
    public ModelAndView getUserList(){
        Collection<User> users=store.values();
        ModelAndView modelAndView=new ModelAndView("userslist","users",users);
        return modelAndView;
    }


}
