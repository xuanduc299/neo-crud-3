package com.CRUD.demoCRUD.repository;

import com.CRUD.demoCRUD.entity.Province;
import com.CRUD.demoCRUD.entity.Ward;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface WardRepository extends JpaRepository<Ward,Integer> {
    @Query("SELECT p FROM tb_ward p WHERE p.ward_id = :ward_id")
    List<Ward> searchId(@Param("ward_id") Integer ward_id);
}
