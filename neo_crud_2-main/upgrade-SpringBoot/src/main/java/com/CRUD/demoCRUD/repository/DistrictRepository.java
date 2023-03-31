package com.CRUD.demoCRUD.repository;

import com.CRUD.demoCRUD.entity.District;
import com.CRUD.demoCRUD.entity.Province;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DistrictRepository extends JpaRepository<District, Integer> {
//    List<District> findByProvinceId(int province_id);
@Query("SELECT p FROM tb_district p WHERE p.district_id = :district_id")
List<District> searchId(@Param("district_id") Integer district_id);
}
