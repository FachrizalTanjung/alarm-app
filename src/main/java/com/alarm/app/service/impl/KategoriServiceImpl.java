package com.alarm.app.service.impl;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.alarm.app.dao.KategoriDao;
import com.alarm.app.dto.DataTablesResponse;
import com.alarm.app.dto.DtoKategori;
import com.alarm.app.dto.DtoResponse;
import com.alarm.app.model.Kategori;
import com.alarm.app.service.KategoriService;
import com.alarm.app.util.ResponseUtil;

@Service
@Transactional(readOnly = true)
public class KategoriServiceImpl implements KategoriService {

	@Autowired
	private KategoriDao kategoriDao;

	@Override
	public DataTablesResponse<DtoKategori> getAllKategori() {
		DataTablesResponse<DtoKategori> response = new DataTablesResponse<>();
		List<DtoKategori> dtoKategoris = new ArrayList<>();
		List<Kategori> kategoris = (List<Kategori>) kategoriDao.findAll();
		for (Kategori kategori : kategoris) {
			DtoKategori dtoKategori = new DtoKategori();

			dtoKategori.setId(kategori.getIdKategori());
			dtoKategori.setKategori(kategori.getKategori());

			dtoKategoris.add(dtoKategori);
		}

		response.setData(dtoKategoris);
		return response;
	}

	@Override
	public DtoKategori getKategoriById(Integer id) {
		Kategori kategori = kategoriDao.findOne(id);
		DtoKategori dtoKategori = new DtoKategori();
		dtoKategori.setId(kategori.getIdKategori());
		dtoKategori.setKategori(kategori.getKategori());
		dtoKategori.setFileData(kategori.getFile());
		return dtoKategori;
	}

	@Override
	@Transactional(readOnly = false)
	public DtoResponse insert(DtoKategori kategori) throws IOException {
		Kategori data = new Kategori();

		data.setKategori(kategori.getKategori());
		if (kategori.getFile() != null) {
			data.setFile(kategori.getFile().getBytes());
		}

		kategoriDao.save(data);
		return ResponseUtil.response(1, "Sukses");
	}

	@Override
	@Transactional(readOnly = false)
	public DtoResponse update(DtoKategori kategori) throws IOException {
		Kategori data = kategoriDao.findOne(kategori.getId());
		if (data != null) {
			data.setKategori(kategori.getKategori());
			if (kategori.getFile() != null) {
				data.setFile(kategori.getFile().getBytes());
			}

			kategoriDao.save(data);
		}

		return ResponseUtil.response(1, "Sukses");
	}

	@Override
	@Transactional(readOnly = false)
	public DtoResponse delete(Integer id) {
		if (id == null) {
			return ResponseUtil.response(0, "Gagal");
		} else
			kategoriDao.delete(id);
		return ResponseUtil.response(1, "Sukses");
	}

}
