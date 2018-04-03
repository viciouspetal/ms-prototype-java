package hello.service.impl;

import hello.BrandRepository;
import hello.dto.Brand;
import hello.model.BrandEntity;
import hello.service.BrandService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BrandServiceImpl implements BrandService {
    @Autowired
    private BrandRepository repo;

    @Override
    public List<BrandEntity> list() {
        return repo.findAll();
    }
}
