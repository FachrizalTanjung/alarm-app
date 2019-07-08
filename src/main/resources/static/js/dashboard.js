 $(document).ready(function () {
//	 var x = document.getElementById("myAudio");
//    getPengingat();
//        setInterval(getPengingat(), 3000);
	 setInterval(function(){getPengingat()}, 5000);
});

function getPengingat() {
    $.ajax({
        type: "GET",
        url: 'rest/pengingat/get-dashboard',
        cache: false,
        contentType: 'application/json',
        processData: false
    }).done(function (resp) {
        console.log(JSON.stringify(resp));
        if (resp.data.length > 0) {
            $('#content').html('<div class="col-xl-3 col-sm-6 mb-3">' +
                '    <div class="card text-white bg-danger o-hidden h-100">' +
                '        <div class="card-body">' +
                '            <div class="mr-5">' + resp.data[0].catatan + '</div>' +
                '        </div>' +
                '        <div class="card-footer">' +
                '            <div>Tanggal Sebelum Aktif :</div>' +
                '            <div>' + resp.data[0].tanggalSebelumAktif + '</div>' +
                '            <div>Tanggal Aktif :</div>' +
                '            <div>' + resp.data[0].tanggalAktif + '</div>' +
                '        </div>' +
                '    </div>' +
                '</div>');
        } else {
        	$('#content').html('');
        }
    }).fail(function () {
        alert('An error occurred please try again later.')
    });

}