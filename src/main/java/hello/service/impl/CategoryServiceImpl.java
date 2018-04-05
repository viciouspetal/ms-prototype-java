package hello.service.impl;

import hello.model.Category;
import hello.repositories.CategoryRepository;
import hello.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class CategoryServiceImpl implements CategoryService {
    @Autowired
    private CategoryRepository repository;

    @Override
    public List<Category> list() {
        return repository.findAll();
    }

    @Override
    public Category create(Category category) {
        return repository.save(category);
    }

    @Override
    public Category update(Category category) {
        Category existing = repository.getOne(category.getId());
        existing.setDepartment(category.getDepartment());
        existing.setName(category.getName());
        return repository.save(existing);
    }

    @Override
    public void delete(Category category) {
        repository.delete(category);
    }

    @Override
    public void delete(String id) {
        Optional<Category> toBeDeleted = repository.findById(id);
        if (!Objects.isNull(toBeDeleted)) {
            delete(toBeDeleted.orElse(null));
        }
    }
}
