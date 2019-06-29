$(document).ready(function(){
	
});

function validateSaveReminder()  {
	var catatan  = $("#catatan").val(); 
	var tanggal_aktif = $("#tanggal_aktif").val();
	var tanggal_sebelum_aktif = $("#tanggal_sebelum_aktif").val();

	var data = new Object(); 
	data.catatan  = catatan;
	data.tanggal_aktif = tanggal_aktif;
	data.tanggal_sebelum_aktif = tanggal_sebelum_aktif;
	
	if (catatan !== '' && tanggal_aktif !== '' 
		&& tanggal_sebelum_aktif !== '' ) {
		var settings = {
			"async": true,
			"crossDomain": true,
			"url": "http://localhost:1000/alarm-app/rest/reminder/insert",
			"method": "POST",
			"headers": {
				"content-type": "application/json",
				"cache-control": "no-cache"
			},
			"processData": false,
			"data": JSON.stringify(data )
		}

		$.ajax(settings).done(function (response) {

		});
		alert("Data Berhasil Disimpan"); 
		window.location.reload(); 
	}

	
}
