@RestController
@RequestMapping("/books")
public class bookController{
    private Map<Integer, Book> books = new HashMap<>();

    @GetMapping
    public List<Book> getAll(@RequestParam(required = false) String author,
                             @RequestParam(required = false) Integer year) {
        return books.values().stream()
                .filter(b -> (author == null || b.getAuthor().equalsIgnoreCase(author)) &&
                        (year == null || b.getPublishedYear() == year))
                .collect(Collectors.toList());
    }

    @GetMapping("/{id}")
    public Book getBook(@PathVariable int id) {
        return books.get(id);
    }

    @PostMapping
    public ResponseEntity<String> addBook(@Valid @RequestBody Book book) {
        books.put(book.getId(), book);
        return ResponseEntity.status(HttpStatus.CREATED).body("Book added.");
    }

    @PutMapping("/{id}")
    public ResponseEntity<String> updateBook(@PathVariable int id, @Valid @RequestBody Book updated) {
        books.put(id, updated);
        return ResponseEntity.ok("Book updated.");
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteBook(@PathVariable int id) {
        books.remove(id);
        return ResponseEntity.ok("Book deleted.");
    }
}
