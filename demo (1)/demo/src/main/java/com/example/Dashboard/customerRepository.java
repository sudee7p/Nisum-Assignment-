import org.springframework.data.jpa.repository.*;
import org.springframework.data.repository.query.Param;
import java.time.LocalDate;
import java.util.List;

public interface customerRepository extends JpaRepository<Customer, Long> {
    List<Customer> findByEmailContaining(String keyword);
    List<Customer> findByRegisteredDateAfter(LocalDate date);

    @Query("SELECT c FROM Customer c WHERE c.name = :name")
    List<Customer> findByName(@Param("name") String name);
}
