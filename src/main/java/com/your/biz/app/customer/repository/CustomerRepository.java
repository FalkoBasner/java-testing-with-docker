package com.your.biz.app.customer.repository;

import com.your.biz.app.customer.domain.Customer;
import java.util.List;
import org.springframework.data.repository.CrudRepository;

public interface CustomerRepository extends CrudRepository<Customer, Long> {

  List<Customer> findByLastName(String lastName);
}
