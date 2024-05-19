package com.company.repository_spring_data;

import com.company.dto.OrderedProduct;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderedRepository extends JpaRepository<OrderedProduct, Integer> {


}
