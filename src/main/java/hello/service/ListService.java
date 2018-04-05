package hello.service;

import hello.model.BaseObject;

import java.util.List;

public interface ListService<T extends BaseObject> {
    List<T> list();
}
