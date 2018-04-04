package hello.controller;

import hello.dto.CategoryDto;
import hello.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/categories")
public class CategoryController {

    @Autowired
    private CategoryService categoryService;

    @RequestMapping(value = "/list", method = RequestMethod.GET)
    public List<CategoryDto> getList() {
        throw new UnsupportedOperationException();
    }

    @RequestMapping(value = "/create", method = RequestMethod.POST)
    public CategoryDto create(@RequestBody CategoryDto dto) {
        throw new UnsupportedOperationException();
    }

    @RequestMapping(value = "/update/{id}", method = RequestMethod.POST)
    public CategoryDto update(@RequestParam String id, @RequestBody CategoryDto dto) {
        throw new UnsupportedOperationException();
    }
}
