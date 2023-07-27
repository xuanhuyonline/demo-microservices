package s3.corp.stockservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import s3.corp.stockservice.entity.Order;

@Repository
public interface OrderRepository extends JpaRepository<Order, Long> {
}
