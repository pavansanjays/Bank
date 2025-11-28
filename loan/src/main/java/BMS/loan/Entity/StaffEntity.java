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
public class StaffEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int staffId;

    @Column(length = 100)
    private String userName;

    @Column(length = 100)
    private String password;

    @Column(length = 100)
    private String role;

}
