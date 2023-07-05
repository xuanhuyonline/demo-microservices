package s3.corp.userdetailservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import s3.corp.userdetailservice.entity.Address;

@Repository
public interface AddressRepository extends JpaRepository<Address, Long> {
}
