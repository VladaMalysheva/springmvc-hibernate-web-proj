package com.example.webproject.testdb;

import com.example.webproject.dao.CustomerDAO;
import com.example.webproject.entity.Customer;
import com.example.webproject.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/customer")
public class CustomerController {

    @Autowired
    private CustomerService customerService;

    @GetMapping("/list")
    public String listCustomers(Model model){
        List<Customer> customerList = customerService.getCustomers();
        model.addAttribute("customers", customerList);
        return "list-customers";
    }


    @GetMapping("/showFormForAdd")
    public String showForm(Model model){

        model.addAttribute("customer", new Customer());
        return "add-form";
    }

    @PostMapping("/saveCustomer")
    public String saveCustomer(@ModelAttribute("customer") Customer customer){
        customerService.saveCustomer(customer);
        return "redirect:/customer/list";
    }

    @GetMapping("/showFormUpdate")
    public String showFormUpdate(@RequestParam("id") int id, Model model){
        System.out.println("Reached method");
        Customer customer = customerService.getCustomer(id);
        System.out.println("Got customer");
        model.addAttribute("customer", customer);
        return "add-form";
    }

    @GetMapping("/delete")
    public String delete(@RequestParam("id") int id, Model model){
        customerService.deleteCustomer(id);
        return "redirect:/customer/list";
    }
}
