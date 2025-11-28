package BMS.loan.Service;

import BMS.loan.Entity.StaffEntity;
import BMS.loan.Repository.StaffRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Objects;

@Service
public class StaffService {

    @Autowired
    private StaffRepo staffRepo;

    public StaffEntity login(String username,String password,String role)
    {
        StaffEntity staffEntity=staffRepo.findByUserName(username).orElse(null);
         if(staffEntity==null)return null;
         if(staffEntity.getPassword().equals(password) && staffEntity.getRole().equals(role))
         {
             return staffEntity;
         }
         return null;
    }
}
