package hello.service;

import hello.model.BaseObject;

public interface UpdateService<T extends BaseObject> {
    T update(T object);
}
