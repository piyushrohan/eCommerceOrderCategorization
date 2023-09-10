import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.*;

import static org.junit.jupiter.api.Assertions.*;

public class CustomersByCategoryTest {

    private List<Order> sampleOrders;

    @BeforeEach
    void setUp() {
        // Create sample categories
        Category electronics = new Category(1, "Electronics");
        Category clothing = new Category(2, "Clothing");
        Category books = new Category(3, "Books");

        // Create sample customers
        Customer alice = new Customer(101, "Alice");
        Customer bob = new Customer(102, "Bob");
        Customer charlie = new Customer(103, "Charlie");
        Customer dave = new Customer(104, "Dave");

        // Create sample products
        Product laptop = new Product(1001, "Laptop", electronics);
        Product shirt = new Product(1002, "T-Shirt", clothing);
        Product phone = new Product(1003, "Phone", electronics);
        Product jeans = new Product(1004, "Jeans", clothing);
        Product javaBook = new Product(1005, "Java Book", books);

        // Create sample orders
        sampleOrders = Arrays.asList(
                new Order(2001, alice, Arrays.asList(laptop, shirt, javaBook), new Date()),
                new Order(2002, bob, Arrays.asList(phone, jeans), new Date()),
                new Order(2003, charlie, Arrays.asList(shirt, phone),new Date()),
                new Order(2004, dave, List.of(laptop), new Date())
        );
    }

    @Test
    void testGroupCustomersByCategory() {
        Map<Category, List<String>> result = CustomersByCategory.groupCustomersByCategory(sampleOrders);

        assertNotNull(result);
        assertEquals(3, result.size());

        // Assertions for Electronics category
        List<String> electronicsCustomers = result.get(new Category(1, "Electronics"));
        assertNotNull(electronicsCustomers);
        assertEquals(4, electronicsCustomers.size());
        assertTrue(electronicsCustomers.contains("Alice"));
        assertTrue(electronicsCustomers.contains("Bob"));
        assertTrue(electronicsCustomers.contains("Charlie"));
        assertTrue(electronicsCustomers.contains("Dave"));

        // Assertions for Clothing category
        List<String> clothingCustomers = result.get(new Category(2, "Clothing"));
        assertNotNull(clothingCustomers);
        assertEquals(3, clothingCustomers.size());
        assertTrue(clothingCustomers.contains("Alice"));
        assertTrue(clothingCustomers.contains("Bob"));
        assertTrue(clothingCustomers.contains("Charlie"));

        // Assertions for Books category
        List<String> booksCustomers = result.get(new Category(3, "Books"));
        assertNotNull(booksCustomers);
        assertEquals(1, booksCustomers.size());
        assertTrue(booksCustomers.contains("Alice"));
    }
}
