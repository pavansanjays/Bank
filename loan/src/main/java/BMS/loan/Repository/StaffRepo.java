package BMS.loan.Repository;

import BMS.loan.Entity.StaffEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface StaffRepo extends JpaRepository<StaffEntity,Integer> {

    public Optional<StaffEntity> findByUserName(String username);
}
