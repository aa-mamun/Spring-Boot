package com.me.springrestservicedemo.repository;

import com.me.springrestservicedemo.domain.entity.Order;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository<Order, Long> {
}