package hello.controller;

import hello.dto.Brand;
import hello.model.BrandEntity;
import hello.service.BrandService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController("/brands")
public class BrandController {

    @Autowired
    private BrandService brandService;

    @RequestMapping("/list")
    public List<BrandEntity> getBrands(){
        return brandService.list();
    }
}
