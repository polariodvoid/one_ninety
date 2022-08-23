package com.polariodvoid.one_eighty;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.stereotype.Repository;
import com.polariodvoid.one_eighty.Product;
import javax.swing.text.html.Option;
import java.util.Optional;
@Repository
public interface ProductRepository {

    @Query("SELECT p FROM Product p WHERE p.enabled = true "
            + "AND (p.category = ?1 OR p.category LIKE %?2%)"
            + " ORDER BY p.name ASC")
    public Page<Product> listByCategory(Integer categoryId, String categoryIDMatch, Pageable pageable);

    public Product findByAlias(String alias);

    public Product findById(Integer id);

    @Query(value = "SELECT * FROM products WHERE enabled = true AND "
            + "MATCH(name, short_description, full_description) AGAINST (?1)",
            nativeQuery = true)
    public Page<Product> search(String keyword, Pageable pageable);
}
