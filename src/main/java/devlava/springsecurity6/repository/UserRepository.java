package devlava.springsecurity6.repository;

import devlava.springsecurity6.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {
    @Query("""
        SELECT u FROM User u
        WHERE u.skid = :skid    
    """)
    Optional<User> findBySkid(String skid);

    boolean existsByUsername(String username);
}