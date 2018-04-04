package hello;

import static org.assertj.core.api.Assertions.assertThat;

import hello.controller.BrandController;
import hello.controller.CategoryController;
import hello.controller.ProductController;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ControllerSmokeTest {

    @Autowired
    private ProductController productController;
    @Autowired
    private CategoryController categoryController;
    @Autowired
    private BrandController brandController;

    @Test
    public void contexLoads() {
        assertThat(productController).isNotNull();
        assertThat(categoryController).isNotNull();
        assertThat(brandController).isNotNull();
    }
}