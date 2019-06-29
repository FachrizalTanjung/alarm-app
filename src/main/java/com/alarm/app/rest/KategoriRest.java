package com.alarm.app.rest;

import javax.ws.rs.core.MediaType;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alarm.app.dao.KategoriDao;
import com.alarm.app.dto.DtoKategori;
import com.alarm.app.dto.DtoResponse;
import com.alarm.app.model.Kategori;
import com.alarm.app.util.ResponseUtil;

@Controller
@RequestMapping("/rest/kategori")
public class KategoriRest {
	
	@Autowired
	private KategoriDao kategoriDao;
	
	@RequestMapping(value = "/insert", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON)
	public @ResponseBody DtoResponse insertKategori(@RequestBody DtoKategori data){
		
		Kategori kategori = new Kategori();
		
		kategori.setKategori(data.getKategori());
		kategori.setFile(data.getFile());
		
		kategoriDao.save(kategori);
		return ResponseUtil.response(1, "Sukses");
	}

}
