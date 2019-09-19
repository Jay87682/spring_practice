package prac.my.demo1.mydemo1.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import prac.my.demo1.mydemo1.model.service.IUserService;
import prac.my.demo1.mydemo1.model.dao.UserDO;


@Controller
@RequestMapping("/test/app")
public class TestController {

    @Autowired
    private IUserService userService;

    Logger logger = LoggerFactory.getLogger(TestController.class);

    @GetMapping("/{id}")
    @ResponseBody
    public UserDO getUserById(@PathVariable("id") Integer id){
        return userService.search(id);
    }

    @PostMapping
    @ResponseBody
    public String addUser(@RequestBody UserDO userData){
        // logger.info("----------");
        // logger.info("name: " + userData.getName() + ", age: " + userData.getAge());
        // logger.info("----------");
        if(userService.add(userData)) {
            return "OK";
        }else {
            return "Not ok";
        }
    }

    @PutMapping("/{id}")
    @ResponseBody
    public String putUserById(@PathVariable("id") Integer id, @RequestBody UserDO userData){
        // logger.info("----------");
        // logger.info("idx: " + id + ", name: " + userData.getName() + ", age: " + userData.getAge());
        // logger.info("----------");
        if(userService.update(id, userData)) {
            return "OK";
        }else {
            return "Not ok";
        }
    }

    @DeleteMapping("/{id}")
    @ResponseBody
    public String delUserById(@PathVariable("id") Integer id){
        // logger.info("----------");
        // logger.info("idx: " + id);
        // logger.info("----------");
        if(userService.delete(id)) {
            return "OK";
        }else {
            return "Not ok";
        }
    }

    
}