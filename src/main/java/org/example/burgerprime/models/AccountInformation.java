package org.example.burgerprime.models;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "accounts_info")
@Data
public class AccountInformation {
    @Id
    @GeneratedValue
    private Integer id;
    private String displayed_name;
    private String address;
    private String phone_number;
    @OneToOne
    @JoinColumn(name = "avatar_id")
    private Image avatar;
    @OneToOne
    @JoinColumn(name = "account_id")
    private Account account;
}
