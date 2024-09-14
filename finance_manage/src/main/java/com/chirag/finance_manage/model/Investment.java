package com.chirag.finance_manage.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import java.math.BigDecimal;
import java.time.LocalDate;

@Entity
@Table(name = "investment") // Ensure this table name matches your DB table
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Investment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "symbol", nullable = false)
    private String symbol;

    @Column(name = "amount_invested", nullable = false)
    private BigDecimal amountInvested;

    @Column(name = "purchase_date", nullable = false)
    private LocalDate purchaseDate;

    @Column(name = "current_value")
    private BigDecimal currentValue;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id", nullable = false)  // This references 'user_id' in the 'users' table
    private User user;
}
