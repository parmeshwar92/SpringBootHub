package com.spring.crud.EmployeeManagement.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.spring.crud.EmployeeManagement.model.SubscriptionEntity;

@Repository
public interface SubscriptionEntityRepository extends JpaRepository<SubscriptionEntity, Long> {

}
