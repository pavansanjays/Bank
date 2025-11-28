package BMS.loan.Service;

import BMS.loan.Entity.CustomerEntity;
import BMS.loan.Repository.CustomerRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CustomerService {

    @Autowired
    public CustomerRepo customerRepo;

    public void registerCustomer(CustomerEntity customerEntity)
    {
        customerRepo.save(customerEntity);
    }

    public CustomerEntity getCustomerDetails(int id)
    {
        return customerRepo.getReferenceById(id);
    }

    public boolean updateCustomerProfile()
    {
        return true;
    }
}
