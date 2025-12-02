package BMS.loan.Controller;

import BMS.loan.Entity.CustomerEntity;
import BMS.loan.Service.CustomerService;
import jakarta.servlet.http.HttpSession;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/OneBank")
public class CustomerController {

    @Autowired
    private CustomerService customerService;

    @GetMapping("")
    public String ShowHome(HttpSession httpSession,Model model) {
        Object customer= httpSession.getAttribute("customer");
        if(customer!=null)
        {
            model.addAttribute("customer",customer);
        }
        return "CustomerUI/Home"; // Corrected to match "CustomerUI"
    }

    @GetMapping("/register")
    public String registerCustomer(Model model)
    {
        model.addAttribute("customerEntity",new CustomerEntity());
        return "CustomerUI/registerForm";
    }

    @PostMapping("/register")
    public String postregisterCustomer(@Valid @ModelAttribute("customerEntity")CustomerEntity customerEntity, BindingResult bindingResult, HttpSession httpSession)
    {
        if(bindingResult.hasErrors())
        {
            return "CustomerUI/registerForm";

        }
        customerEntity.setKycStatus(CustomerEntity.KycStatus.valueOf("VERIFIED"));
        customerService.registerCustomer(customerEntity);

        httpSession.setAttribute("customer",customerEntity);
        return "redirect:/OneBank";
    }

    @GetMapping("/getProfile/{id}")
    public String getCustomerDetails(@PathVariable int id,Model model)
    {
        CustomerEntity customerEntity=customerService.getCustomerDetails(id);
        model.addAttribute("customerProfile",customerEntity);
        return "CustomerUI/showProfile";
    }

    @GetMapping("updateProfile/{id}")
    public String updateCustomerProfile(HttpSession httpSession,Model model)
    {
        CustomerEntity customerEntity= (CustomerEntity) httpSession.getAttribute("customer");

        if(customerEntity!=null)
        {
            model.addAttribute("customerEntity",customerEntity);
            return "CustomerUI/updateProfile";
        }
        return "redirect:/OneBank";
    }

    @PostMapping("/updateProfile")
    public String postUpdateProfile(@Valid@ModelAttribute("customerEntity")CustomerEntity customerEntity,BindingResult bindingResult,HttpSession httpSession)
    {

        if(!bindingResult.hasErrors())
        {
            customerService.registerCustomer(customerEntity);
            httpSession.setAttribute("customerEntity",customerEntity);
            return "redirect:/OneBank";
        }
        return "CustomerUI/updateProfile";
    }

    @GetMapping("/logout")
    public String logout(HttpSession httpSession)
    {
        httpSession.invalidate();
        return "redirect:/OneBank";
    }

}
