package com.makara.SystemPhone.repository;

import com.makara.SystemPhone.entity.Brand;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.List;
import static org.junit.jupiter.api.Assertions.assertEquals;

@DataJpaTest
public class BrandRepositoryTest {

    @Autowired
    private BrandRepository brandRepository;

    @Test
    public void testFindByNameLike(){
        //Given
        Brand brand = new Brand();
        brand.setName("Apple");
        brandRepository.save(brand);

        Brand brand2 = new Brand();
        brand2.setName("Samsung");

        //when
        List<Brand> brands = brandRepository.findByNameLike("%A%");

        //Then
        assertEquals(1, brands.size());
        assertEquals("Apple", brands.get(0).getName());
        assertEquals(1, brands.get(0).getId());

    }

}
