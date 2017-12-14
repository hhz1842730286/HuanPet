package com.jiyun.huanpet.model.api;

import java.util.List;

/**
 * Created by mengYao on 2017/12/8.
 */

public interface DbApis<T> {
    long insert(T t);
    boolean delete(T t);
    boolean update(T t);
    List<T> queryAll();
    T queryWhere(Object o);
}
