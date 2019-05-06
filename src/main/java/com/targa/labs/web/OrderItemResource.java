package com.targa.labs.web;

import com.targa.labs.common.Web;
import com.targa.labs.service.OrderItemService;
import com.targa.labs.web.dto.OrderItemDto;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping(Web.API + "/order-items")
public class OrderItemResource {
    private final OrderItemService itemService;
    @GetMapping
    public List<OrderItemDto> findAll() {
        return this.itemService.findAll();
    }
    @GetMapping("/{id}")
    public OrderItemDto findById(@PathVariable Long id) {
        return this.itemService.findById(id);
    }
    @PostMapping
    public OrderItemDto create(@RequestBody OrderItemDto orderItemDto) {
        return this.itemService.create(orderItemDto);
    }
    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        this.itemService.delete(id);
    }
}