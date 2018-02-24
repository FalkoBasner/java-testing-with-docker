package com.your.biz.app.customer.repository;

import static org.assertj.core.api.Assertions.assertThat;

import com.your.biz.IntegrationTest;
import com.your.biz.app.customer.domain.Customer;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest()
public class CustomerRepositoryTest extends IntegrationTest {

  @Autowired
  private CustomerRepository repository;

  @Before
  public void deleteAll() {
    repository.deleteAll();
  }

  @Test
  public void save_and_findOne() {
    assertThat(repository.findAll()).isEmpty();

    Customer customer = repository.save(new Customer("John", "Doe"));

    assertThat(repository.findOne(customer.getId())).isEqualTo(customer);
  }

  @Test
  public void save_and_findByLastName() {
    assertThat(repository.findAll()).isEmpty();

    Customer persistentCustomer = repository.save(new Customer("Jane", "Doe"));

    assertThat(repository.findByLastName("Doe")).contains(persistentCustomer);
  }
}