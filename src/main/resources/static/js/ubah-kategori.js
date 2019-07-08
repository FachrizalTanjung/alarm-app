$(document).ready(function () {
    $('#txtId').val(localStorage.getItem('id'));
    $('#txtKategori').val(localStorage.getItem('kategori'));

    

    $("#formUpdate").submit(function (e) {
        e.preventDefault();
        var action = $(this).attr("action");
        var data = new FormData();
        data.append('id', $('#txtId').val());
        data.append('kategori', $('#txtKategori').val());
        jQuery.each(jQuery('#txtFile')[0].files, function (i, file) {
            data.append('fileData', file);
        });
        
        $.ajax({
            type: "POST",
            url: action,
            cache: false,
            data: data,
            contentType: false,
            processData: false
        }).done(function () {
        	alert('Data berhasil disimpan');
        	window.location.href = 'kategori';
        }).fail(function () {
            alert('An error occurred please try again later.')
        });
    });
});