package com.cafe4code.thymeleafdemo.controller;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class DemoController {


//    @GetMapping("/hello")
//    public String sayHello(Model theModel){
//
//        theModel.addAttribute("theDate",java.time.LocalDateTime.now());
//        return "helloworld";
//    }

    @RequestMapping("/showform")
    public String showForm(){
        return "helloworld-form";
    }

    @RequestMapping("/processform")
    public String processForm(){
        return "helloworld";
    }

    @RequestMapping("/convertuppercase")
    public String convertUpperCase(HttpServletRequest request, Model model){
        String name = request.getParameter("studentName");

        name = name.toUpperCase();
        String result = "yeh! " + name;

        model.addAttribute("massage",result);

        return "helloworld";
    }

    @RequestMapping("/convertuppercaseversion2")
    public String convertUpperCaseVersion2(@RequestParam("studentName") String name, Model model){
        name = name.toUpperCase();
        String result = name + " : we can all live together ! ";

        model.addAttribute("massage",result);

        return "helloworld";
    }




}
