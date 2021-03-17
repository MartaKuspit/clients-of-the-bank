package my.project.product.mortgage;

import org.springframework.data.jpa.repository.JpaRepository;

public interface MortgageRepository extends JpaRepository<Mortgage, Long> {
}
