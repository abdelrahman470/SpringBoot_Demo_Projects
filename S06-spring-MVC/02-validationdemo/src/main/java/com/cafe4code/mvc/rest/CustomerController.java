package com.cafe4code.mvc.rest;
import com.cafe4code.mvc.model.Customer;
import jakarta.validation.Valid;
import org.springframework.beans.propertyeditors.StringTrimmerEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class CustomerController {

    // trim white spaces
    @InitBinder
    public void initBinder(WebDataBinder dataBinder){
        StringTrimmerEditor stringTrimmerEditor = new StringTrimmerEditor(true);
        dataBinder.registerCustomEditor(String.class, stringTrimmerEditor);
    }

    @GetMapping("/")
    public String showForm(Model model){
        model.addAttribute("customer", new Customer());

        return "customer-form";
    }

    @PostMapping("/form-validation")
    public String validation(@Valid @ModelAttribute("customer") Customer customerObj ,
                             BindingResult theBindingResult,
                             RedirectAttributes redirectAttributes) {

        System.out.println("\n" + "=============================");
        System.out.println("binding results:  = " + theBindingResult.toString());
        System.out.println("\n" + "=============================");

        if(theBindingResult.hasErrors()){
            return "customer-form";
        }
        redirectAttributes.addFlashAttribute("customer", customerObj);
        return "redirect:/confirm";


    }

    @GetMapping("/confirm")
    public String confirmPage(Model model) {

        if (!model.containsAttribute("customer")) {
            return "redirect:/";
        }
        return "confirm-page";
    }

}
