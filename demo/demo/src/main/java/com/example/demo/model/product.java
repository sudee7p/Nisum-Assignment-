public class product {
    @NotNull(message = "Id is required")
    private Integer id;

    @NotBlank(message = "Name cannot be empty")
    @Size(min = 2, message = "Name must have at least 2 characters")
    private String name;

    @Positive(message = "Price must be positive")
    private double price;
    // Getters & Setters
}
public class ProductValidator implements Validator {
    @Override
    public boolean supports(Class<?> clazz) {
        return Product.class.isAssignableFrom(clazz);
    }

    @Override
    public void validate(Object target, Errors errors) {
        Product product = (Product) target;
        if (product.getPrice() < 0) {
            errors.rejectValue("price", "negative", "Price cannot be negative");
        }
    }
}
