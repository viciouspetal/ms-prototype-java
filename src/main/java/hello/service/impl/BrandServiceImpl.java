package hello.service.impl;

import hello.BrandRepository;
import hello.model.Brand;
import hello.service.BrandService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BrandServiceImpl implements BrandService {
    @Autowired
    private BrandRepository repo;

    @Override
    public List<Brand> list() {
        return repo.findAll();
    }
}
