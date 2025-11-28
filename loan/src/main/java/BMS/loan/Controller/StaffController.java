package BMS.loan.Controller;

import BMS.loan.Entity.StaffEntity;
import BMS.loan.Service.StaffService;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/OneBank")
public class StaffController {

    @Autowired
    private StaffService staffService;

    @PostMapping("/staff/login")
    public String postStaffLogin(@RequestParam String username, @RequestParam String password, @RequestParam String role, HttpSession httpSession)
    {
        StaffEntity staffEntity=staffService.login(username, password, role);
        if(staffEntity!=null)
        {
            httpSession.setAttribute("staff",staffEntity);
        }
        return "redirect:/OneBank";
    }
}
