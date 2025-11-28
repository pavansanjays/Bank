package BMS.loan.Controller;

import BMS.loan.Service.LoanProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

@Controller
public class LoanProductController {

    @Autowired
    private LoanProductService loanProductService;

    public String addLoanProduct(){
        return null;
    }

    public String updateLoanProduct(){
        return null;
    }

    public String getLoanProductDetails(){
        return null;
    }
}
