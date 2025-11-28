package BMS.loan.Entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import lombok.*;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class CustomerEntity {

    public enum KycStatus {
        PENDING,
        VERIFIED
    }
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int customerId;

    @Column(length = 100)
    @NotBlank(message = "Give full name")
    private String name;

    @Column(length = 100)
    @NotBlank(message = "give correct email")
    @Pattern(regexp = "^[A-Za-z0-9._%+-]+@[A-Za-z0-9.-]+\\.[A-Za-z]{2,6}$", message = "Invalid email format")
    private String email;

    @Column(length = 10)
    @NotBlank(message = "give correct phone number")
    @Pattern(regexp = "^\\d{10}$", message = "Phone number must be exactly 10 digits")
    private String phone;

    @Column(length = 100)
    @NotBlank(message = "give permanent address")
    private String address;

    @Enumerated(EnumType.STRING)
    @Column(columnDefinition = "ENUM('PENDING', 'VERIFIED')")
    private KycStatus kycStatus;

}
