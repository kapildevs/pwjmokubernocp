package com.targa.labs.repository;

import com.targa.labs.domain.Cart;
import com.targa.labs.domain.enumeration.CartStatus;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CartRepository extends JpaRepository<Cart, Long> {

    List<Cart> findByStatus(CartStatus status);
    List<Cart> findByStatusAndCustomerId(CartStatus status, Long customerId);
}
