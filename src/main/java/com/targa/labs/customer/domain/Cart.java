package com.targa.labs.customer.domain;

import com.targa.labs.commons.domain.AbstractEntity;
import com.targa.labs.customer.domain.enumeration.CartStatus;
import com.targa.labs.order.domain.Order;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = false)
@Entity
@Table(name = "cart")
public class Cart extends AbstractEntity {

    private static final long serialVersionUID = 1L;

//    @OneToOne
//    @JoinColumn(unique = true)
//    private Order order;

    private Long orderId;

    @ManyToOne
    private Customer customer;

    @NotNull
    @Enumerated(EnumType.STRING)
    private CartStatus status;

    public Cart(Customer customer) {
        this.customer = customer;
        this.status = CartStatus.NEW;
    }
}
