# Implementation Plan - Spring Boot Product Management Repository (with Unused/Missing Tables)

Create a lightweight, functional Spring Boot project for Product Management with Spring Data JPA and H2 database. To support testing scenarios (such as identifying dead/unused database tables or unreferenced JPA entities), the repository will explicitly include tables and entities that are not part of any active functional flow.

## User Review Required

> [!NOTE]
> The database setup uses H2 In-Memory DB by default with `schema.sql` and Hibernate DDL generation so it runs standalone out of the box with zero external DB setup.

> [!IMPORTANT]
> The repository will contain two categories of unused tables:
> 1. **Unused JPA Entities**: Mapped `@Entity` classes (`LegacySupplier`, `ArchivedInventory`) with database tables created, but no Repository, Service, or Controller interaction in functional flows.
> 2. **Unmapped DB Tables**: Raw tables defined via `schema.sql` (`deprecated_user_logs`, `temp_promotions`, `vendor_discount_rates`) that have no corresponding Java entities or application usage.

## Proposed Changes

### Project Setup & Build Configuration

#### [NEW] [pom.xml](file:///c:/ramu/Project_Assignment/RapidX/FreddeMac_Project_RapidX/Work/SimpleRepos_For_Testing_Scenarios/ProductManagement_Repo_Missing_tabels/pom.xml)
- Maven POM defining Spring Boot 3.x dependencies: `spring-boot-starter-web`, `spring-boot-starter-data-jpa`, `h2`, `lombok` (optional/provided), and standard compiler plugins (Java 17).

#### [NEW] [application.properties](file:///c:/ramu/Project_Assignment/RapidX/FreddeMac_Project_RapidX/Work/SimpleRepos_For_Testing_Scenarios/ProductManagement_Repo_Missing_tabels/src/main/resources/application.properties)
- Configure H2 datasource, H2 Console (`/h2-console`), JPA Hibernate properties (`spring.jpa.hibernate.ddl-auto=update`), SQL script initialization settings (`spring.sql.init.mode=always`).

#### [NEW] [schema.sql](file:///c:/ramu/Project_Assignment/RapidX/FreddeMac_Project_RapidX/Work/SimpleRepos_For_Testing_Scenarios/ProductManagement_Repo_Missing_tabels/src/main/resources/schema.sql)
- Defines raw unused tables (`deprecated_user_logs`, `temp_promotions`, `vendor_discount_rates`) directly in SQL.

#### [NEW] [data.sql](file:///c:/ramu/Project_Assignment/RapidX/FreddeMac_Project_RapidX/Work/SimpleRepos_For_Testing_Scenarios/ProductManagement_Repo_Missing_tabels/src/main/resources/data.sql)
- Seed sample data for functional tables (Categories, Products) and seed rows into unused tables.

---

### Core Application & Functional Flow

#### [NEW] [ProductManagementApplication.java](file:///c:/ramu/Project_Assignment/RapidX/FreddeMac_Project_RapidX/Work/SimpleRepos_For_Testing_Scenarios/ProductManagement_Repo_Missing_tabels/src/main/java/com/example/productmanagement/ProductManagementApplication.java)
- Main `@SpringBootApplication` entry point.

#### [NEW] [Category.java](file:///c:/ramu/Project_Assignment/RapidX/FreddeMac_Project_RapidX/Work/SimpleRepos_For_Testing_Scenarios/ProductManagement_Repo_Missing_tabels/src/main/java/com/example/productmanagement/entity/Category.java)
- Active `@Entity` for category management.

#### [NEW] [Product.java](file:///c:/ramu/Project_Assignment/RapidX/FreddeMac_Project_RapidX/Work/SimpleRepos_For_Testing_Scenarios/ProductManagement_Repo_Missing_tabels/src/main/java/com/example/productmanagement/entity/Product.java)
- Active `@Entity` for product inventory management (linked to Category).

#### [NEW] [CustomerOrder.java](file:///c:/ramu/Project_Assignment/RapidX/FreddeMac_Project_RapidX/Work/SimpleRepos_For_Testing_Scenarios/ProductManagement_Repo_Missing_tabels/src/main/java/com/example/productmanagement/entity/CustomerOrder.java)
- Active `@Entity` for orders (`customer_orders` table).

#### [NEW] Repositories (`CategoryRepository.java`, `ProductRepository.java`, `CustomerOrderRepository.java`)
- `Spring Data JPA` repositories for active entities.

#### [NEW] Services (`ProductService.java`, `CategoryService.java`)
- Business logic for product creation, searching, category assignments, stock updates.

#### [NEW] Controllers (`ProductController.java`, `CategoryController.java`)
- REST Endpoints (`/api/products`, `/api/categories`).

---

### Unused / Missing Tables & Entities (Testing Target)

#### [NEW] [LegacySupplier.java](file:///c:/ramu/Project_Assignment/RapidX/FreddeMac_Project_RapidX/Work/SimpleRepos_For_Testing_Scenarios/ProductManagement_Repo_Missing_tabels/src/main/java/com/example/productmanagement/entity/LegacySupplier.java)
- `@Entity` mapped to table `legacy_suppliers`. Dead code: entity exists but no JPA repository, service, or controller interacts with it.

#### [NEW] [ArchivedInventory.java](file:///c:/ramu/Project_Assignment/RapidX/FreddeMac_Project_RapidX/Work/SimpleRepos_For_Testing_Scenarios/ProductManagement_Repo_Missing_tabels/src/main/java/com/example/productmanagement/entity/ArchivedInventory.java)
- `@Entity` mapped to table `archived_inventory`. Dead entity with repository created but never injected or called anywhere in application flow.

#### [NEW] Tables in [schema.sql](file:///c:/ramu/Project_Assignment/RapidX/FreddeMac_Project_RapidX/Work/SimpleRepos_For_Testing_Scenarios/ProductManagement_Repo_Missing_tabels/src/main/resources/schema.sql)
- Raw tables `deprecated_user_logs`, `temp_promotions`, `vendor_discount_rates` created directly in SQL schema, completely unused by Java code.

---

## Verification Plan

### Automated Tests
- Run `mvn clean test-compile` / `mvn test` (or wrapper if generated) to ensure project builds cleanly.
- Add unit/integration tests in `ProductManagementApplicationTests.java` testing the functional REST endpoints.

### Manual Verification
- Verify table existence in H2 database (functional + unused tables).
- Verify REST APIs `/api/products` and `/api/categories` operate properly.
