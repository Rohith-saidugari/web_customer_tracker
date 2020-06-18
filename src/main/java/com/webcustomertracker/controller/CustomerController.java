package com.webcustomertracker.controller;


import com.webcustomertracker.model.Customer;
import com.webcustomertracker.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.*;

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
        model.addAttribute("updateCustomer", newCustomer);
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

    //TODO Exception Handling
    //If customer Id is wrong??
    @PostMapping("/update/{id}")
    public String updateCustomer(@PathVariable("id") int id, @Valid @ModelAttribute("updateCustomer") Customer customer,
                                 BindingResult result, Model Model) {
        if (result.hasErrors()) {
            // Add coundnot update model
            return "redirect:/customer/list";
        }
        Customer customerTobeUpdated = customerService.getCustoemr(id);
        customerTobeUpdated.setFirstName(customer.getFirstName());
        customerTobeUpdated.setLastName(customer.getLastName());
        customerTobeUpdated.setEmailId(customer.getEmailId());
        customerService.updateCustomer(customerTobeUpdated);
        return "redirect:/customer/list";
    }


    @PostMapping("/delete/{id}")
    public String deleteCustomer(@PathVariable("id") int id) {
        customerService.deleteCustomer(id);
        return "redirect:/customer/list";
    }

}