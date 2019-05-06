package com.targa.labs.web;

import com.targa.labs.common.Web;
import com.targa.labs.service.PaymentService;
import com.targa.labs.web.dto.PaymentDto;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping(Web.API + "/payments")
public class PaymentResource {
    private final PaymentService paymentService;
    @GetMapping
    public List<PaymentDto> findAll() {
        return this.paymentService.findAll();
    }
    @GetMapping("/{id}")
    public PaymentDto findById(@PathVariable Long id) {
        return this.paymentService.findById(id);
    }
    @PostMapping
    public PaymentDto create(@RequestBody PaymentDto orderItemDto) {
        return this.paymentService.create(orderItemDto);
    }
    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        this.paymentService.delete(id);
    }
}