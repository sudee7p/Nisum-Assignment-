@RestController
@RequestMapping("/products")
public class product {
    private List<Product> products = new ArrayList<>();

    @GetMapping
    public List<Product> getAll() {
        return products;
    }

    @PostMapping
    public ResponseEntity<String> addProduct(@RequestBody Product product) {
        products.add(product);
        return ResponseEntity.status(HttpStatus.CREATED).body("Product added.");
    }

    @PutMapping("/{id}")
    public ResponseEntity<String> updateProduct(@PathVariable int id, @RequestBody Product updated) {
        for (int i = 0; i < products.size(); i++) {
            if (products.get(i).getId() == id) {
                products.set(i, updated);
                return ResponseEntity.ok("Product updated.");
            }
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Product not found.");
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteProduct(@PathVariable int id) {
        products.removeIf(p -> p.getId() == id);
        return ResponseEntity.ok("Product deleted.");
    }
}
