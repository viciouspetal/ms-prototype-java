package hello.service;

import hello.model.Category;

public interface CategoryService extends ListService<Category>, CreateService<Category>, UpdateService<Category>, DeleteService<Category> {

}
