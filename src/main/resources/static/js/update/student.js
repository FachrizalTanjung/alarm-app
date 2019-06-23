$(document).ready(function () {
	
	//Menampilkan data untuk di update
	$('#id').val(localStorage.getItem("id"));
    $('#name').val(localStorage.getItem("name"));
    $('#placeOfBirth').val(localStorage.getItem("placeOfBirth"));
    $('#dateOfBirth').val(localStorage.getItem("dateOfBirth"));
    $('#gender').val(localStorage.getItem("gender"));
    $('#level').val(localStorage.getItem("level"));
    $('#schoolName').val(localStorage.getItem("schoolName"));
    $('#classroom').val(localStorage.getItem("classroom"));
    
  //Jquery untuk update student
	$("#btn-update").click(function(event) {
		updateStudent();
		alert("Data has been updated successfully");
		window.location.href = 'http://localhost:8082/pantau/student';
	});

});

//Function Update Student
function updateStudent() {

	var data = {
		"id" : $('#id').val(),
		"name" : $('#name').val(),
		"placeOfBirth" : $('#placeOfBirth').val(),
		"dateOfBirth" : $('#dateOfBirth').val(),
		"gender" : $('#gender').val(),
		"level" : $('#level').val(),
		"schoolName" : $('#schoolName').val(),
		"classroom" : $('#classroom').val()
	}
	
	console.log(data);

	var settings = {
		"async" : true,
		"crossDomain" : true,
		"url" : "http://localhost:8082/pantau/rest/student/update",
		"method" : "POST",
		"headers" : {
			"content-type" : "application/json",
			"cache-control" : "no-cache"
		},
		"processData" : false,
		"data" : JSON.stringify(data)
	}

	$.ajax(settings).done(function(response) {
		
	});
}