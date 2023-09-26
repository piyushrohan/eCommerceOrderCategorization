```markdown
# eCommerce Order Categorization

This Java project demonstrates a solution for categorizing e-commerce orders by product categories 
and grouping customers by those categories. It provides a Java method that takes a list of orders and returns a map, 
where each category key is mapped to a list of customer names who ordered products from that category.
The project also includes comprehensive JUnit tests.

## Method

The core functionality of this project is implemented in the `groupCustomersByCategory` method within the `CustomersByCategory` class:

```java
public static Map<Category, List<String>> groupCustomersByCategory(List<Order> orders) {
    // Java Streams-based implementation
}
```

- `Category`, `Customer`, `Product`, and `Order` classes define the essential entities of the e-commerce system.

## Getting Started

### Prerequisites

Before running the project, ensure you have the following prerequisites installed:

- Java 17
- [Maven](https://maven.apache.org/)

### Usage

1. Clone this repository to your local machine:

   ```bash
   git clone https://github.com/piyushrohan/eCommerceOrderCategorization.git
   ```

2. Navigate to the project directory:

   ```bash
   cd eCommerceOrderCategorization
   ```

3. Build the project using Maven:

   ```bash
   mvn clean install
   ```

## Testing

The project includes a comprehensive set of JUnit tests within the `CustomersByCategoryTest` class. These tests cover various scenarios to ensure the correctness of the `groupCustomersByCategory` method.

## Contributions

Contributions to this project are welcome! If you have any improvements, suggestions, or bug fixes, please open an issue or submit a pull request.
