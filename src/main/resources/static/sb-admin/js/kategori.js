$(document).ready(function(){
	
});

function validateSaveKategori()  {
	var kategori  = $("#kategori").val(); 
	var file = $("#file").val();
	var reminders = $("#reminders").val();

	var data = new Object(); 
	data.kategori  = kategori ;
	data.file = file;
	data.reminders = reminders;
	
	if (kategori !== '' && file !== '' 
		&& reminders !== '' ) {
		var settings = {
			"async": true,
			"crossDomain": true,
			"url": "http://localhost:1000/alarm/rest/kategori/insert ",
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
