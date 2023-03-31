package com.CRUD.demoCRUD.repository;

import com.CRUD.demoCRUD.entity.District;
import com.CRUD.demoCRUD.entity.Province;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProvinceRepository extends JpaRepository<Province,Integer> {

    @Query("SELECT p FROM tb_province p WHERE p.province_id = :province_id")
    List<Province> searchId(@Param("province_id") Integer province_id);
}
