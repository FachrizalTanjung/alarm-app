$(document).ready(function () {
    var pengingatTable = $('#pengingat-table').DataTable({
        ajax: {
            url: 'rest/pengingat/get-all-pengingats'
        },
        columns: [
            {
                data: 'id',
                visible: false
            },
            {
                data: 'catatan',
            },
            {
                data: 'tanggalAktif',
            },
            {
                data: 'tanggalSebelumAktif',
            },
            {
                data: 'idKategori',
                visible: false
            },
            {
                data: 'kategori'
            },
            {
                data: null,
                render: function (data, type, row, meta) {
                    return '<a id="btn-update" class="btn btn-primary">Update</a>&nbsp;<a id="btn-delete" class="btn btn-danger">Delete</a>';
                }
            }
      ]
    });
    
    $('#pengingat-table tbody').on('click', 'td.details-control', function () {
        var tr = $(this).closest('tr');
        var row = table.row( tr );
 
        if ( row.child.isShown() ) {
            // This row is already open - close it
            row.child.hide();
            tr.removeClass('shown');
        }
        else {
            // Open this row
            row.child( format(row.data()) ).show();
            tr.addClass('shown');
        }
    } );

    //Aksi saat klik tombol update
    $('#pengingat-table tbody').on('click', '#btn-update', function () {
    	var data = pengingatTable.row($(this).parents('tr')).data();
        localStorage.clear();

        //Menyimpan data untuk update
        localStorage.setItem('id', data.id);
        localStorage.setItem('catatan', data.catatan);
        localStorage.setItem('tanggalAktif', data.tanggalAktif);
        localStorage.setItem('tanggalSebelumAktif', data.tanggalSebelumAktif);
        localStorage.setItem('idKategori', data.idKategori);
        localStorage.setItem('kategori', data.kategori);

        //Pindah ke url update
        window.location.href = 'ubah-pengingat';
    });
    
  //Aksi saat klik tombol delete
    $('#pengingat-table tbody').on('click', '#btn-delete', function () {
    	if (confirm("Apakah anda yakin ingin menghapus data?")) {
    		var data = pengingatTable.row($(this).parents('tr')).data();
            var settings = {
        			"async": true,
        			"crossDomain": true,
        			"url": "rest/pengingat/delete",
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
            	window.location.href = 'pengingat';
    		});
        }
    });
});