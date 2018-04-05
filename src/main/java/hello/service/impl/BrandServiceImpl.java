package hello.service.impl;

import hello.model.Brand;
import hello.repositories.BrandRepository;
import hello.service.BrandService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class BrandServiceImpl implements BrandService {
    @Autowired
    private BrandRepository repo;

    @Override
    public List<Brand> list() {
        return repo.findAll();
    }

    @Override
    public Brand create(Brand brand) {
        return repo.save(brand);
    }

    @Override
    public Brand update(Brand brand) {
        return repo.save(brand);
    }

    @Override
    public void delete(Brand brand) {
        repo.delete(brand);
    }

    @Override
    public void delete(String id) {
        Optional<Brand> toBeDeleted = repo.findById(id);
        if (!Objects.isNull(toBeDeleted)) {
            delete(toBeDeleted.orElse(null));
        }
    }
}
