package com.targa.labs.order.service;

import com.targa.labs.order.domain.Order;
import com.targa.labs.order.domain.OrderItem;
import com.targa.labs.product.domain.Product;
import com.targa.labs.order.repository.OrderItemRepository;
import com.targa.labs.order.repository.OrderRepository;
import com.targa.labs.product.repository.ProductRepository;
import com.targa.labs.commons.dto.OrderItemDto;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Slf4j
@Service
@Transactional
public class OrderItemService {

    private final OrderItemRepository orderItemRepository;
    private final OrderRepository orderRepository;
    private final ProductRepository productRepository;
    public List<OrderItemDto> findAll() {
        log.debug("Request to get all OrderItems");
        return this.orderItemRepository.findAll()
                .stream()
                .map(OrderItemService::mapToDto)
                .collect(Collectors.toList());
    }
    @Transactional(readOnly = true)
    public OrderItemDto findById(Long id) {
        log.debug("Request to get OrderItem : {}", id);
        return this.orderItemRepository.findById(id).map(OrderItemService::mapToDto).orElse(null);
    }
    public OrderItemDto create(OrderItemDto orderItemDto) {
        log.debug("Request to create OrderItem : {}", orderItemDto);

        Order order = this.orderRepository.findById(orderItemDto.getOrderId()).orElseThrow(() -> new IllegalStateException("The Order does not exist!"));

        Product product = this.productRepository.findById(orderItemDto.getProductId()).orElseThrow(() -> new IllegalStateException("The Product does not exist!"));

        return mapToDto(
                this.orderItemRepository.save(
                        new OrderItem(
                                orderItemDto.getQuantity(),
                                product.getId(),
                                order
                        )));
    }

    public void delete(Long id) {
        log.debug("Request to delete OrderItem : {}", id);
        this.orderItemRepository.deleteById(id);
    }
    public static OrderItemDto mapToDto(OrderItem orderItem) {
        if (orderItem != null) {
            return new OrderItemDto(
                    orderItem.getId(),
                    orderItem.getQuantity(),
                    orderItem.getProductId(),
                    orderItem.getOrder().getId()
            );
        }
        return null;
    }
}
