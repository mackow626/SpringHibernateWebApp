package app.controller;

import app.entity.Customer;
import app.service.CustomerService;
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
    public String listCustomers(Model theModel) {

        List<Customer> customers = customerService.getCustomers();

        theModel.addAttribute("customers", customers);

        return "list";
    }

    @GetMapping("/addCustomer")
    public String showAddCustomerForm(Model theModel){

        Customer customer = new Customer();
        theModel.addAttribute("customer",customer);

        return "addCustomer";
    }

    @PostMapping("/saveCustomer")
    public String saveCustomer(@ModelAttribute("customer") Customer customer){

        customerService.saveCustomer(customer);

    return "redirect:/customer/list";
    }

    @GetMapping("/Delete")
    public String deleteCustomer(@RequestParam("customerId") int Id){

        customerService.deleteCustomer(Id);

        return "redirect:/customer/list";
    }

    @GetMapping("/Update")
    public String showUpdateCustomer(@RequestParam("customerId") int Id, Model theModel){

        Customer customer= customerService.getCostumer(Id);

        theModel.addAttribute("customer",customer);

        return "addCustomer";
    }

    @PostMapping("/search")
    public String searchCustomers(@RequestParam("theSearchName") String theSearch, Model theModel){

        List<Customer> customers = customerService.getCustomersBySearch(theSearch);

        theModel.addAttribute("customers", customers);


        return "list";
    }

}