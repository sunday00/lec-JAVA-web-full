package lec.sunday00.reservation.repository;

import lec.sunday00.reservation.model.Product;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

import static org.junit.Assert.*;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {lec.sunday00.reservation.config.ApplicationConfig.class})
public class ProductRepositoryTest {

    @Autowired
    ProductRepository productRepository;

    @Test
    public void select() {
        if ( productRepository.selectCount("all") > 8 ){
            List<Product> list = productRepository.select("all", 1);
            for( Product item: list ){
                System.out.println(item.toString());
            }

            Assert.assertTrue(list.size() == 4);
        }
    }
}