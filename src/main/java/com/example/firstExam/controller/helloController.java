package com.example.firstExam.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class helloController {

    @GetMapping("hello")
    public String hello (Model model){
        model.addAttribute("data","taeyoung") ;
        return "hello" ;
    }

    @GetMapping("hello-mvc")// url 도메인
    public String helloMapping(@RequestParam("data") String name ,Model model){
        model.addAttribute("data",name) ;
        return "hello-template" ;
    }

    @GetMapping("hello-spring")
    @ResponseBody
    public String helloSpring(@RequestParam("name") String name){
        return "hello "+ name ;
    }

    @GetMapping("hello-api")
    @ResponseBody
    public Hello helloApi(@RequestParam("name") String name){
        Hello hello = new Hello();
        hello.setName(name);
        return hello;
    }

    static class Hello{
        private String name;

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }
    }
}
