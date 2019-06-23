$(document).ready(function () {
    var studentTable = $('#student-table').DataTable({
        ajax: {
            url: 'rest/student/all',
            dataSrc: ''
        },
        columns: [
            {
                data: 'id'
            },
            {
                data: 'name'
            },
            {
                data: 'placeOfBirth'
            },
            {
                data: 'dateOfBirth'
            },
            {
                data: 'gender'
            },
            {
                data: 'level'
            },
            {
                data: 'schoolName'
            },
            {
                data: 'classroom'
            },
            {
                data: null,
                render: function (data, type, row, meta) {
                    return '<a id="btn-update" class="btn btn-primary">Update</a>&nbsp;<a id="btn-delete" class="btn btn-danger">Delete</a>';
                }
            }],
        dom: 'Bfrtip',
        buttons: [
            {
                text: 'Add',
                action: function (e, dt, node, config) {
                    location.href = 'add-student';
                },
                className: 'btn btn-primary'
            }
        ]
    });
    
	//Aksi saat klik tombol update
	$('#student-table tbody').on('click', '#btn-update', function() {
		var data = studentTable.row($(this).parents('tr')).data();
		console.log(data);
		localStorage.clear();
		
		//Menyimpan data untuk update
		localStorage.setItem("id",data.id);
		localStorage.setItem("name",data.name);
		localStorage.setItem("placeOfBirth",data.placeOfBirth);
		localStorage.setItem("dateOfBirth",data.dateOfBirth);
		localStorage.setItem("gender",data.gender);
		localStorage.setItem("level",data.level);
		localStorage.setItem("schoolName",data.schoolName);
		localStorage.setItem("classroom",data.classroom);
		
		//Pindah ke url update
		window.location.href = 'update-student';
	});
});