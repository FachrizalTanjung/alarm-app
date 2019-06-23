$(document).ready(function() {

});

function validateSaveConsults() {
	var subjects = $("#subjects").val();
	var abouts = $("#abouts").val();
	var solutions = $("#solutions").val();
	var actions = $("#actions").val();
	var id = $("#id").val();

	var data = new Object();
	data.subjects = subjects;
	data.abouts = abouts;
	data.solutions = solutions;
	data.actions = actions;
	data.id = id;

	if (subjects !== '' && abouts !== '' && solutions !== '' && actions !== ''&& id !== '') {
		var settings = {
			"async" : true,
			"crossDomain" : true,
			"url" : "http://localhost:8082/pantau/rest/consults/insert",
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
		alert("Data Saved Succesfully");
		window.location.reload();
	}
}