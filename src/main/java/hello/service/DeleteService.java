package hello.service;

import hello.model.BaseObject;

public interface DeleteService<T extends BaseObject> {
    void delete(T object);

    void delete(String id);
}
