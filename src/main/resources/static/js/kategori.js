$(document).ready(function () {
    var kategoriTable = $('#kategori-table').DataTable({
        ajax: {
            url: 'rest/kategori/get-all-kategoris'
        },
        columns: [
            {
                data: 'id',
                visible: false
            },
            {
                data: 'kategori'
            },
            {
                data: null,
                render: function (data, type, row, meta) {
                    return '<a id="btn-download" href="rest/kategori/get-kategori-by-id?id='+data.id+'" target="_blank" class="btn btn-primary">Download</a>';
                }
            },
            {
                data: null,
                render: function (data, type, row, meta) {
                    return '<a id="btn-update" class="btn btn-primary">Update</a>&nbsp;<a id="btn-delete" class="btn btn-danger">Delete</a>';
                }
            }
      ]
    });

    //Aksi saat klik tombol update
    $('#kategori-table tbody').on('click', '#btn-update', function () {
        var data = kategoriTable.row($(this).parents('tr')).data();
        console.log(data);
        localStorage.clear();

        //Menyimpan data untuk update
        localStorage.setItem('id', data.id);
        localStorage.setItem('kategori', data.kategori);

        //Pindah ke url update
        window.location.href = 'ubah-kategori';
    });
    
  //Aksi saat klik tombol delete
    $('#kategori-table tbody').on('click', '#btn-delete', function () {
        var data = kategoriTable.row($(this).parents('tr')).data();
        var settings = {
    			"async": true,
    			"crossDomain": true,
    			"url": "rest/kategori/delete",
    			"method": "POST",
    			"headers": {
    				"content-type": "application/json",
    				"cache-control": "no-cache"
    			},
    			"processData": false,
    			"data": data.id
    		}

        $.ajax(settings).done(function (response) {
        	alert('Data berhasil dihapus');
        	window.location.href = 'kategori';
		});
    });
});