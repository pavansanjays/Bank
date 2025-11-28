package BMS.loan.Repository;

import BMS.loan.Entity.LoanProductEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LoanProductRepo extends JpaRepository<LoanProductEntity,Integer> {
}
