package hello.controller;

import hello.model.Product;
import hello.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/products")
public class ProductController {

    @Autowired
    private ProductService productService;

    @RequestMapping(value = "/list", method = RequestMethod.GET)
    public List<Product> getList() {
        return productService.list();
    }

    @RequestMapping(value = "/create", method = RequestMethod.POST)
    public Product create(@RequestBody Product object) {
        return productService.create(object);
    }

    @RequestMapping(value = "/update/{id}", method = RequestMethod.POST)
    public Product update(@RequestParam String id, @RequestBody Product object) {
        throw new UnsupportedOperationException();
    }
}