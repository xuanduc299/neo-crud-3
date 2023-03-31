package com.CRUD.demoCRUD.repository;

import com.CRUD.demoCRUD.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface ProductRepository extends JpaRepository<Product, UUID> {
    Product getProductById(UUID id);
    boolean existsByName(String name);

    @Query("SELECT p FROM tb_product_2 p WHERE p.name LIKE %:name%")
    List<Product> search(@Param("name") String name);
}
