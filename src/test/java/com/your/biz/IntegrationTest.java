package com.your.biz;


import org.testcontainers.containers.MySQLContainer;

public abstract class IntegrationTest {

  private static final String SPRING_DATASOURCE_URL = "spring.datasource.url";
  private static final String SPRING_DATASOURCE_USERNAME = "spring.datasource.username";
  private static final String SPRING_DATASOURCE_PASSWORD = "spring.datasource.password";

  /**
   * can't use JUnit ClassRule due to race condition
   *
   * see https://github.com/testcontainers/testcontainers-java/issues/417
   */
  private static final MySQLContainer MY_SQL_CONTAINER = new MySQLContainer("mysql:5.7");

  static {
    MY_SQL_CONTAINER.start();

    System.setProperty(SPRING_DATASOURCE_URL, MY_SQL_CONTAINER.getJdbcUrl());
    System.setProperty(SPRING_DATASOURCE_USERNAME, MY_SQL_CONTAINER.getUsername());
    System.setProperty(SPRING_DATASOURCE_PASSWORD, MY_SQL_CONTAINER.getPassword());
  }
}
