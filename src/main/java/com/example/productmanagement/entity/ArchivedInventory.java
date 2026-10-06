package com.example.productmanagement.entity;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

/**
 * UNUSED ENTITY FOR TESTING SCENARIOS.
 * This table 'archived_inventory' is created in DB and has a repository,
 * but is never invoked or included in any functional flow.
 */
@Entity
@Table(name = "archived_inventory")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ArchivedInventory {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long originalProductId;

    private String productName;

    private Integer finalQuantity;

    private String archiveReason;

    private LocalDateTime archivedAt;
}
