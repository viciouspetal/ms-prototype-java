package hello.controller;

import hello.model.Category;
import hello.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/categories")
public class CategoryController {

    @Autowired
    private CategoryService categoryService;

    @RequestMapping(value = "/list", method = RequestMethod.GET)
    public List<Category> getList() {
        return categoryService.list();
    }

    @RequestMapping(value = "/create", method = RequestMethod.POST)
    public Category create(@RequestBody Category category) {
        return categoryService.create(category);
    }

    @RequestMapping(value = "/update/{id}", method = RequestMethod.POST)
    public Category update(@RequestParam String id, @RequestBody Category category) {
        return categoryService.update(category);
    }

    @RequestMapping(value = "/delete/{id}", method = RequestMethod.DELETE)
    public void delete(@RequestParam String id) {
        categoryService.delete(id);
    }
}
