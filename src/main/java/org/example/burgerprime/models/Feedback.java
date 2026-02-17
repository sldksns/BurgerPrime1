package org.example.burgerprime.models;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "feedbacks")
@Data
@NoArgsConstructor
public class Feedback {
    @Id
    @GeneratedValue
    private Integer id;
    private String feedback;
    private Integer rating;
    @ManyToOne
    @JoinColumn(name = "account_id")
    private Account account;
}
