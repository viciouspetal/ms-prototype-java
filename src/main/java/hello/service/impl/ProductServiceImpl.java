package hello.service.impl;

import hello.model.Category;
import hello.model.Product;
import hello.repositories.ProductRepository;
import hello.service.BrandService;
import hello.service.CategoryService;
import hello.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
@Transactional
public class ProductServiceImpl implements ProductService {
    @Autowired
    private ProductRepository productRepository;

    @Override
    public List<Product> list() {
        return productRepository.findAll();
    }

    @Override
    public Product create(Product product) {
        return productRepository.save(product);
    }

    @Override
    public Product update(Product object) {
        Product existing = productRepository.getOne(object.getId());
        existing.setName(object.getName());
        existing.setUnitPrice(object.getUnitPrice());
        existing.setWidth(object.getWidth());
        existing.setWeight(object.getWeight());
        existing.setHeight(object.getHeight());
        existing.setDepth(object.getDepth());
        existing.setColour(object.getColour());
        existing.setBrands(object.getBrands());
        existing.setCategory(object.getCategory());
        return productRepository.save(existing);
    }

    @Override
    public void delete(Product object) {
        productRepository.delete(object);
    }

    @Override
    public void delete(String id) {
        Optional<Product> toBeDeleted = productRepository.findById(id);
        if (!Objects.isNull(toBeDeleted)) {
            delete(toBeDeleted.orElse(null));
        }
    }
}
