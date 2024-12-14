package webapp.model;

import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.query.Procedure;
import org.springframework.data.repository.CrudRepository;
import java.util.*;

public interface CartRepository extends CrudRepository<Cart, Integer> {
    @Modifying
    @Procedure
    void saveCart(String code, long productId, short quantity);
    List<Cart> findAllByCode(String code);

    @Transactional
    @Modifying
    @Query(value="UPDATE cart SET quantity = :quantity WHERE cart_id = :id", nativeQuery = true)
    void update(int id, short quantity);
}
