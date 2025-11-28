package BMS.loan.Service;

import BMS.loan.Repository.LoanProductRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LoanProductService {

    @Autowired
    private LoanProductRepo loanProductRepo;
}
