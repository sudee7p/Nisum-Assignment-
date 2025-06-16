@RestController
@RequestMapping("/products")
public class productdashboard {
    private List<Product> products = new ArrayList<>();

    @GetMapping
    public List<Product> getAll(@RequestParam(required = false) String category,
                                @RequestParam(required = false) Double minPrice,
                                @RequestParam(required = false) Double maxPrice,
                                @RequestParam(required = false, defaultValue = "price") String sort,
                                @RequestParam(required = false, defaultValue = "asc") String order) {

        Stream<Product> stream = products.stream();

        if (category != null)
            stream = stream.filter(p -> p.getCategory().equalsIgnoreCase(category));
        if (minPrice != null)
            stream = stream.filter(p -> p.getPrice() >= minPrice);
        if (maxPrice != null)
            stream = stream.filter(p -> p.getPrice() <= maxPrice);

        Comparator<Product> comparator = Comparator.comparing(Product::getPrice);
        if ("desc".equalsIgnoreCase(order))
            comparator = comparator.reversed();

        return stream.sorted(comparator).collect(Collectors.toList());
    }

    @GetMapping("/{id}")
    public Product getById(@PathVariable int id) {
        return products.stream().filter(p -> p.getId() == id).findFirst()
                .orElseThrow(() -> new NoSuchElementException("Product not found"));
    }

    @PostMapping
    public ResponseEntity<String> add(@Valid @RequestBody Product product) {
        products.add(product);
        return ResponseEntity.status(HttpStatus.CREATED).body("Product added.");
    }

    @PutMapping("/{id}")
    public ResponseEntity<String> update(@PathVariable int id, @Valid @RequestBody Product updated) {
        for (int i = 0; i < products.size(); i++) {
            if (products.get(i).getId() == id) {
                products.set(i, updated);
                return ResponseEntity.ok("Product updated.");
            }
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Product not found.");
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> delete(@PathVariable int id) {
        products.removeIf(p -> p.getId() == id);
        return ResponseEntity.ok("Product deleted.");
    }
}
