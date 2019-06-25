package com.alarm.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.alarm.app.model.Kategori;

public interface KategoriDao extends JpaRepository<Kategori, Integer> {

}
