package eatmap.app.service;

import java.util.List;

import eatmap.app.entity.Speciality;

public interface Dao<T> {
	T GetByName(String nom);
	List<T> GetAll();
    T GetById(Integer id);
	T Save(T t);
	void Delete(Integer id);
	T Update(Integer id, T t);
}
