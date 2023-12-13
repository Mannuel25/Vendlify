# Vendlify - Vendor Management App

Vendlify is a Java GUI-based Vendor Management Application designed to streamline the process of vendor registration, profile management, and inventory control. The application prioritizes security, convenience, and efficient management for both vendors and administrators.

## Features

### Secure Registration

User passwords are securely hashed during registration, ensuring the confidentiality of vendor credentials.

### Dual Authentication

The application supports two login credentials - admin and vendor - providing distinct access levels and functionalities.

### Vendor Dashboard

Vendors can create accounts, log in, and easily update their profiles. Additionally, they can manage their inventory by adding, updating, and deleting items they sell.

### Product Categories

Vendlify organizes products into six categories: food, drinks, snacks, stationaries, perfumes & deodorant, and toiletries. This categorization facilitates a structured and user-friendly experience.

### Admin Dashboard

Administrators can log in to access a comprehensive view of all registered vendors. This dashboard allows administrators to update, delete, and search for vendors efficiently.

### Inventory Management

Vendors can update, delete, and search for any item they sell, providing them with control over their product listings.

### Vendor Management

Administrators have the capability to update, delete, and search for any vendor, ensuring robust management and oversight.

## Getting Started

1. Clone the repository to your local machine.
2. Open the project in your preferred Java development environment.
3. Run the `Vendlify.java` file to launch the application.

## Setting Up the Database

1. Create a MySQL database named `vendlify`.

2. Inside the `vendlify` database, create the `vendors` and `vendor_items` tables using the following SQL statements:

```sql
CREATE TABLE vendors (
    id INT AUTO_INCREMENT PRIMARY KEY,
    full_name VARCHAR(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci,
    email VARCHAR(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci,
    phone_no VARCHAR(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci,
    password VARCHAR(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci,
    user_role VARCHAR(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT 'vendor',
    location VARCHAR(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci,
    item_categories VARCHAR(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci
);

CREATE TABLE vendor_items (
    id INT AUTO_INCREMENT PRIMARY KEY,
    vendor_id INT NOT NULL,
    name VARCHAR(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci,
    category VARCHAR(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci,
    price VARCHAR(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci,
    in_stock INT NOT NULL,
    FOREIGN KEY (vendor_id) REFERENCES vendors(id)
);
```

3. Update the `DBConnector` class in the project with your MySQL database connection details.

## Dependencies

- Java 8 or higher
- MySQL

## Usage

1. Launch the application.
2. Log in as either a vendor or an administrator.
3. Follow the on-screen prompts to manage profiles, inventory, and vendors.

## License

This project is licensed under the [MIT License](LICENSE).

