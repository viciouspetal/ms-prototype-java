package hello.service.impl;

import hello.model.Brand;
import hello.model.Category;
import hello.model.Product;
import hello.repositories.ProductRepository;
import hello.service.ProductService;
import org.hamcrest.Matchers;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.ArgumentCaptor;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.Arrays;
import java.util.List;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.Matchers.hasSize;
import static org.hamcrest.Matchers.notNullValue;
import static org.junit.Assert.assertThat;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class ProductServiceImplTest {
    @Mock
    private ProductRepository productRepositoryMock;

    @InjectMocks
    private ProductService productService = new ProductServiceImpl();

    @Test
    public void list_when_productsExist_then_listOfProductsIsReturned() {
        Product existing1 = generateProduct();
        List<Product> existingProducts = Arrays.asList(existing1);

        when(productRepositoryMock.findAll()).thenReturn(existingProducts);

        List<Product> products = productService.list();
        assertThat(products, hasSize(1));
        assertThat(products.get(0).getName(), is(existing1.getName()));
        assertThat(products.get(0).getColour(), is(existing1.getColour()));
        assertThat(products.get(0).getId(), is(existing1.getId()));
        assertThat(products.get(0).getDepth(), is(existing1.getDepth()));
        assertThat(products.get(0).getWidth(), is(existing1.getWidth()));
        assertThat(products.get(0).getWeight(), is(existing1.getWeight()));
        assertThat(products.get(0).getUnitPrice(), is(existing1.getUnitPrice()));
        assertThat(products.get(0).getBrands(), is(existing1.getBrands()));
        assertThat(products.get(0).getCategory(), is(existing1.getCategory()));

        verify(productRepositoryMock).findAll();
    }

    @Test
    public void create_when_validProduct_then_productIsCreated() {
        Product toBeSaved = generateProduct();
        when(productRepositoryMock.save(toBeSaved)).thenReturn(new Product());

        Product result = productService.create(toBeSaved);

        assertThat(result, notNullValue());
        ArgumentCaptor<Product> categoryCapture = ArgumentCaptor.forClass(Product.class);
        verify(productRepositoryMock).save(categoryCapture.capture());

        Product capturedCategory = categoryCapture.getValue();
        assertThat(capturedCategory.getName(), Matchers.is(toBeSaved.getName()));
        assertThat(capturedCategory.getCategory(), Matchers.is(toBeSaved.getCategory()));
    }

    private Product generateProduct(){
        Product product = new Product();
        product.setId("id");
        product.setName("prod1");
        product.setColour("blue");
        product.setDepth(200);
        product.setHeight(20);
        product.setWeight(10);
        product.setWidth(15);
        product.setUnitPrice(25);
        product.setBrands(Arrays.asList(new Brand("brand1", "owner1")));
        product.setCategory(new Category());

        return product;
    }
}