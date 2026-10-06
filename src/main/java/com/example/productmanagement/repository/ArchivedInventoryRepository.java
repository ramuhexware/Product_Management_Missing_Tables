package com.example.productmanagement.repository;

import com.example.productmanagement.entity.ArchivedInventory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * UNUSED REPOSITORY FOR TESTING SCENARIOS.
 * Never injected into any service or controller.
 */
@Repository
public interface ArchivedInventoryRepository extends JpaRepository<ArchivedInventory, Long> {
}
