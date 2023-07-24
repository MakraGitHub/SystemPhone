package com.makara.SystemPhone.service;

import com.makara.SystemPhone.entity.Brand;
import com.makara.SystemPhone.exception.ResourceNotFoundException;
import com.makara.SystemPhone.repository.BrandRepository;
import com.makara.SystemPhone.service.impl.BrandServiceImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import java.util.Optional;

import static org.mockito.ArgumentMatchers.any;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class BrandServiceTest {

    @Mock
    private BrandRepository brandRepository;

    private BrandService brandService;

    @BeforeEach
    public void setUp(){
        brandService = new BrandServiceImpl(brandRepository);
    }

   /* @Test
    public void testCreate(){

        //given
        Brand brand = new Brand();
        //This brand is a object create Mock
        brand.setName("Apple");
        brand.setId(1);

        Brand brand2 = new Brand();
        brand2.setName("Apple");

        //when

       // when(brandRepository.save(any(Brand.class))).thenReturn(brand);
        when(brandRepository.save(brand2)).thenReturn(brand);
        //Brand  brandReturn = brandService.create(new Brand());
        Brand  brandReturn = brandService.create(brand2);
        //then

        assertEquals(1,brandReturn.getId());
        assertEquals("Apple",brandReturn.getName());

    }*/
    @Test
    public void testCreate(){
        //given
        Brand brand = new Brand();
        brand.setName("Apple");
        //When
        brandService.create(brand);
        //then
        verify(brandRepository, times(1)).save(brand);
    }
    @Test
    public void testGetById(){
        //given
        Brand brand = new Brand();
        brand.setName("Apple");
        brand.setId(1);
        //when
        when(brandRepository.findById(1)).thenReturn(Optional.of(brand));//one function is return to optional..........!
        Brand brandReturn = brandService.getById(1);

        //then
        assertEquals(1,brandReturn.getId());
        assertEquals("Apple",brandReturn.getName());

    }
    @Test
    public void testGetByIdThrow(){
        //given

        //when
        when(brandRepository.findById(2)).thenReturn(Optional.empty());
       // brandService.getById(2);
        assertThatThrownBy(()-> brandService.getById(2))
                .isInstanceOf(ResourceNotFoundException.class)
                .hasMessage(String.format("%s With id = %d nof found ","Brand",2));
              //  .hasMessage("Brand With id = 2 nof found ");

        //then

    }

}
