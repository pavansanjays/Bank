package BMS.loan.Entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class LoanProductEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int loanProductId;

    @Column
    private String productName;

    @Column
    private double interestRate;

    @Column
    private double minAmount;

    @Column
    private double maxAmount;

    @Column
    int tenure;
}
