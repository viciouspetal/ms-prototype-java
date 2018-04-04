package hello.controller;

import hello.model.Brand;
import hello.service.BrandService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/brands")
public class BrandController {

    @Autowired
    private BrandService brandService;

    @RequestMapping(value="/list", method = RequestMethod.GET)
    public List<Brand> getList(){
        return brandService.list();
    }

    @RequestMapping(value="/create", method = RequestMethod.POST)
    public Brand create(@RequestBody Brand object){
        throw new UnsupportedOperationException();
    }

    @RequestMapping(value = "/update/{id}", method = RequestMethod.POST)
    public Brand update(@RequestParam String id, @RequestBody Brand object){
        throw new UnsupportedOperationException();
    }
}
