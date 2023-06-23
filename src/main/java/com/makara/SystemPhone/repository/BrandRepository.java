package com.makara.SystemPhone.repository;

import com.makara.SystemPhone.entity.Brand;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

//This one repository focus on brands
@Repository
public interface BrandRepository extends JpaRepository<Brand ,Integer> {
    List<Brand> findByNameLike(String name);
    List<Brand> findByNameContaining(String name);

}
