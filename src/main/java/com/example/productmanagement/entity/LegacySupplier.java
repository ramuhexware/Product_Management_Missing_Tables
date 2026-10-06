package com.example.productmanagement.entity;

import jakarta.persistence.*;
import lombok.*;

/**
 * UNUSED ENTITY FOR TESTING SCENARIOS.
 * This table 'legacy_suppliers' is created in the database via JPA Hibernate,
 * but no Repository, Service, or Controller in the project uses this entity.
 */
@Entity
@Table(name = "legacy_suppliers")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class LegacySupplier {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String supplierCode;

    private String companyName;

    private String contactPerson;

    private String phone;

    private boolean isDeprecated;
}
