package webapp.model;

import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;

import java.util.List;

public interface ProductRepository extends CrudRepository<Product, Integer>, PagingAndSortingRepository<Product, Integer> {
    List<Product> findAllBySubCategory(SubCategory obj, Pageable pageable);

    List<Product> findAllBySubCategoryAndIdNot(SubCategory obj, int id, Pageable pageable);

    @Query(value= "SELECT Product.* FROM Product JOIN sub_category ON Product.sub_category_id = sub_category.sub_category_id AND category_id = :id", nativeQuery = true)

    List<Product> findAllByCategory(int id, Pageable pageable);

}
