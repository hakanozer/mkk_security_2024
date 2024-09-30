package com.works.controllers;

import com.works.entities.Customer;
import com.works.services.CustomerService;
import com.works.services.TinkEncDec;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
@RequiredArgsConstructor
public class LoginController {

    final CustomerService customerService;

    @GetMapping("")
    public String login() {
        return "login";
    }

    @PostMapping("/login")
    public String loginPost(@Valid Customer customer, BindingResult bindingResult, Model model){
        if (bindingResult.hasErrors()){
            model.addAttribute("error",bindingResult.getFieldErrors());
            return "login";
        }
        boolean loginStatus = customerService.customerLogin(customer);
        if (loginStatus){
            return "redirect:/dashboard";
        }
        return "login";
    }

}
