package hello.controller;

import hello.model.Category;
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
    public List<Category> getList() {
        throw new UnsupportedOperationException();
    }

    @RequestMapping(value = "/create", method = RequestMethod.POST)
    public Category create(@RequestBody Category object) {
        throw new UnsupportedOperationException();
    }

    @RequestMapping(value = "/update/{id}", method = RequestMethod.POST)
    public Category update(@RequestParam String id, @RequestBody Category dto) {
        throw new UnsupportedOperationException();
    }
}
