package hello.service;

import hello.model.BaseObject;

public interface CreateService<T extends BaseObject> {
    T create(T object);
}
