package hello.controller;

import hello.dto.BrandDto;
import hello.model.BrandEntity;
import hello.service.BrandService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController("/brands")
public class BrandController {

    @Autowired
    private BrandService brandService;

    @RequestMapping(value="/list", method = RequestMethod.GET)
    public List<BrandEntity> getList(){
        return brandService.list();
    }

    @RequestMapping(value="/create", method = RequestMethod.POST)
    public BrandDto create(@RequestBody BrandDto dto){
        throw new UnsupportedOperationException();
    }

    @RequestMapping(value = "/update", method = RequestMethod.POST)
    public BrandDto update(@RequestParam String id, @RequestBody BrandDto dto){
        throw new UnsupportedOperationException();
    }
}
