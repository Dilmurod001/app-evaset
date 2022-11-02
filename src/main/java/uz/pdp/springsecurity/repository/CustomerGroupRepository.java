package uz.pdp.springsecurity.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import uz.pdp.springsecurity.entity.CustomerGroup;

public interface CustomerGroupRepository extends JpaRepository<CustomerGroup,Integer> {
}
