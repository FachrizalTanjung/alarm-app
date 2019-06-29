$(document).ready(function(){
	
});

function validateSaveKategori()  {
	var kategori  = $("#kategori").val(); 
	var file = $("#file").val();

	var data = new Object(); 
	data.kategori  = kategori ;
	data.file = file;
	
	if (kategori !== '' && file !== '') {
		var settings = {
			"async": true,
			"crossDomain": true,
			"url": "http://localhost:1000/alarm-app/rest/kategori/insert",
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
