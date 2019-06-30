$(document).ready(function() {

});

function saveKategori() {
	var data = new FormData();
	jQuery.each(jQuery('#txtFile')[0].files, function(i, file) {
		data.append('file', file);
	});

	jQuery.ajax({
		url : 'rest/kategori/insert',
		data : data,
		cache : false,
		contentType : false,
		processData : false,
		type : 'POST',
		success : function(data) {
			if (data.status == '1') {
				console.log('berhasil');
			} else {
				console.log('gagal');
			}
		}
	});

}
