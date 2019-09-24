package cn.yan.service;


public interface IBaseService<T> {

    void insertEntity(T entity);

    void updateEntityById(T entity);

}
