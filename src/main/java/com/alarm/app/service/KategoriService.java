package com.alarm.app.service;

import java.io.IOException;

import com.alarm.app.dto.DataTablesResponse;
import com.alarm.app.dto.DtoKategori;
import com.alarm.app.dto.DtoResponse;

public interface KategoriService {

	DataTablesResponse<DtoKategori> getAllKategori();

	DataTablesResponse<DtoKategori> getKategoriById(Integer id);

	DtoResponse insert(DtoKategori kategori) throws IOException;

	DtoResponse update(DtoKategori kategori) throws IOException;

	DtoResponse delete(Integer id);

}
