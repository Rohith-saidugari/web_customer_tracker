package com.webcustomertracker.controller;


import com.webcustomertracker.model.Customer;
import com.webcustomertracker.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;

import javax.validation.Valid;
import java.util.LinkedList;
import java.util.List;

@Controller
@RequestMapping("/customer")
public class CustomerController {


    @Autowired
    private CustomerService customerService;

    @GetMapping("/list")
    public String listCustomers(Model model) {
        Customer newCustomer = new Customer();
        // For adding employee setting up model attribute
        model.addAttribute("newCustomer", newCustomer);
        model.addAttribute("customers", customerService.getCustomers());
        return "customer-list";
    }

    @PostMapping("/saveCustomer")
    public String saveCustomer(@Valid @ModelAttribute("newCustomer") Customer customer, BindingResult result, Model model) {
        if (result.hasErrors()) {
            List<String> fieldErrors = new LinkedList<>();
            for (FieldError err : result.getFieldErrors()) {
                fieldErrors.add(err.getDefaultMessage());
            }
            model.addAttribute("FieldErrors", fieldErrors);
            return "redirect:/customer/list";
        }
        customerService.saveCustomer(customer);
        return "redirect:/customer/list";
    }

}