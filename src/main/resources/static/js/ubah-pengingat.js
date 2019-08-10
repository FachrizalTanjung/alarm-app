$(document).ready(function () {
	
	
	
	$('#txtTglAktif').datepicker({
        uiLibrary: 'bootstrap4',
        format: 'dd-mmm-yyyy'
    });
	
	$('#txtTglSbmAktif').datepicker({
        uiLibrary: 'bootstrap4',
        format: 'dd-mmm-yyyy'
    });
	
	$.ajax({
        type: "GET",
        url: 'rest/kategori/get-all-kategoris',
        cache: false,
        contentType: 'application/json',
        processData: false
    }).done(function (resp) {
    	console.log(JSON.stringify(resp));
    	var html = '';
    	for (var i = 0; i < resp.data.length; i++) {
    		html += '<option value="' + resp.data[i].id + '">' + resp.data[i].kategori + '</option>';
    	}
    	$('#cbIdKategori').replaceWith(
    			'<select class="form-control" id="cbIdKategori">'+html+
                '</select>');
    	$('#cbIdKategori').val(localStorage.getItem('idKategori'));
    	$('#txtId').val(localStorage.getItem('id'));
        $('#txtCatatan').val(localStorage.getItem('catatan'));
        $('#txtTglAktif').val(localStorage.getItem('tanggalAktif'));
        $('#txtTglSbmAktif').val(localStorage.getItem('tanggalSebelumAktif'));
//        $('#txtKategori').val(localStorage.getItem('kategori'));
    }).fail(function () {
        alert('An error occurred please try again later.')
    });
	
	
	
    $("#formUpdate").submit(function (e) {
        e.preventDefault();
        var action = $(this).attr("action");
        var data = new Object();
        data.catatan = $('#txtCatatan').val();
        data.tanggalAktif = $('#txtTglAktif').val();
        data.tanggalSebelumAktif = $('#txtTglSbmAktif').val();
        data.idKategori = $('#cbIdKategori').val();
        
        $.ajax({
            type: "POST",
            url: action,
            cache: false,
            data: JSON.stringify(data),
            contentType: 'application/json',
            processData: false
        }).done(function () {
        	alert('Data berhasil diupdate');
        	window.location.href = 'pengingat';
        }).fail(function () {
            alert('An error occurred please try again later.')
        });
    });
});