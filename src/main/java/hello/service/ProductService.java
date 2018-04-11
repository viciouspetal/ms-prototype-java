package hello.service;

import hello.model.Product;

public interface ProductService extends ListService<Product>, CreateService<Product>, UpdateService<Product>, DeleteService<Product> {
}
