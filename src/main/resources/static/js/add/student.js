$(document).ready(function () {
	$('#dateOfBirth').datepicker({
        uiLibrary: 'bootstrap4',
        format: 'dd-mmm-yyyy'
    });
});

function validateSaveStudent() {
	var name = $("#name").val();
	var placeOfBirth = $("#placeOfBirth").val();
	var dateOfBirth = $("#dateOfBirth").val();
	var gender = $("#gender").val();
	var level = $("#level").val();
	var schoolName = $("#schoolName").val();
	var classroom = $("#classroom").val();

	var data = new Object();
	data.name = name;
	data.placeOfBirth = placeOfBirth;
	data.dateOfBirth = dateOfBirth;
	data.gender = gender;
	data.level = level;
	data.schoolName = schoolName;
	data.classroom = classroom;

	if (name !== '' && placeOfBirth !== '' 
		&& dateOfBirth !== '' && gender !== '' 
			&& level !== '' && schoolName !== '' 
				&& classroom !== '') {
		var settings = {
			"async": true,
			"crossDomain": true,
			"url": "http://localhost:8082/pantau/rest/student/insert",
			"method": "POST",
			"headers": {
				"content-type": "application/json",
				"cache-control": "no-cache"
			},
			"processData": false,
			"data": JSON.stringify(data)
		}

		$.ajax(settings).done(function (response) {

		});
		alert("Data saved successfully");
		window.location.reload();
	}
}