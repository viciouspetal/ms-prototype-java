package hello.controller;

import hello.dto.ProductDto;
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
    public List<ProductDto> getList() {
        throw new UnsupportedOperationException();
    }

    @RequestMapping(value = "/create", method = RequestMethod.POST)
    public ProductDto create(@RequestBody ProductDto dto) {
        throw new UnsupportedOperationException();
    }

    @RequestMapping(value = "/update/{id}", method = RequestMethod.POST)
    public ProductDto update(@RequestParam String id, @RequestBody ProductDto dto) {
        throw new UnsupportedOperationException();
    }
}