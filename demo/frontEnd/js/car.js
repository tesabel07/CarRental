BASE_URL = 'http://localhost:8080';

function loadCars() {
    $.ajax({
        url: BASE_URL + '/car',
        type: 'GET',
        success: function (data) {
            var cars = "";
            var available = 'Available';
            for (var i in data) {
                if(data[i].available == false) {
                    available = '<span class="p-2 mb-1 bg-danger text-white" >Rented out</span>';
                }else {
                    available = '<span class="p-2 mb-1 bg-success text-white" >Its Available</span>';
                }
                cars = cars + '<div class="col-md-3"><div class="card" > ' +
                    // ' <img class="card-img-top" src="car.jpg" alt="Card image cap">' +
                    ' <img class="card-img-top" src="' + BASE_URL + '/car/image/' + data[i].pictureLocation + '" alt="Card image cap">' +
                    '<div class="card-body"> ' +
                    '<h5 class="card-title">' + data[i].brandName + '</h5> ' +
                    '<p class="card-text">' + data[i].make + '</p> ' +
                    '<p class="card-text">' + data[i].year + '</p> ' +
                    '<p class="card-text">' + data[i].rentalPrice + '</p> ' +
                    '<p class="card-text">' + available + '</p>' +
                '<button onclick="goToCarDetail(' + data[i].carId + ')" class="btn btn-primary" type="button">Detail</button>' +

                '</div></div></div>';

            }

            $(cars).appendTo('#div1');
        },
        error: function (errorData) {

        }
    });
}

function loadReservedCars() {
    $.ajax({
        url: BASE_URL + '/listofreservedcar',
        type: 'GET',
        success: function (data) {
            var cars = "";
            for (var i in data) {

                cars = cars + '<tr>' +
                    '<td>' + data[i].brandName + '</td> ' +
                    '<td>' + data[i].year + '</td> ' +
                    '<td>' + data[i].rentalPrice + '</td> ' +
                                       '</tr>';
            }

            $(cars).appendTo('#tbody');
        },
        error: function (errorData) {

        }
    });
}

function homepage() {
    window.location.href = 'cars.html';
}
function reservepage1() {
    window.location.href = 'reserved.html';
}

function goToCarDetail(id) {
    localStorage.setItem('car', id);
    window.location.href = 'detailOfCar.html';
}
function goToRent(){
    window.location.href = 'rent.html';
}
function deleteCar() {
    userId = localStorage.getItem('user');
    carId = localStorage.getItem('car');
    $.ajax({
        url: BASE_URL + 'car/delete/' + carId + '/' + userId,
        type: 'POST',
        data: {},
        success: function () {
            window.location.href = 'cars.html';
        },
        error: function (errorData) {
            alert(errorData.responseJSON.message);
        }
    })
}

function getCarDetail() {
    carId = localStorage.getItem('car');
    $.ajax({
        url: BASE_URL + '/car/' + carId,
        type: 'GET',
        success: function (data) {
            if(data.available){
                $('#buttonOnDetail').append('<button class="btn btn-info" onclick="rentCar()">rent</button>')
            }
            else{
                $('#buttonOnDetail').append('<button class="btn btn-info" onclick="returnCar()">Return</button>')
            }
            $('#carImg').append('<img src="' + BASE_URL + '/car/image/' + data.pictureLocation + '" alt="Card image cap" style="width: 100%">');
            $('#brandName').append(data.brandName);
            $('#make').append(data.make);
            $('#year').append(data.year);
            $('#rentalPrice').append(data.rentalPrice);

        },
        error: function (errorData) {
            alert(errorData.responseJSON.message);
        }
    })
}
function returnCar(){
    $.ajax({
        url: BASE_URL + '/carReturn/'  + localStorage.getItem('car'),
        type: 'GET',
        success: function (data) {

            alert('Successful!');
            window.location.href = 'cars.html';
        },
        error: function (errorData) {
            alert(errorData.responseJSON.message);
        }
    });
}
function addCar() {
    var addCarForm = {
        brandName: document.getElementById("brandName").value,
        make: document.getElementById("make").value,
        year: document.getElementById("year").value,
        rentalPrice: document.getElementById("rental").value,
        pictureLocation: localStorage.getItem('filePath')

    };
    var carJson = JSON.stringify(addCarForm);
    $.ajax({
        url: BASE_URL + '/car/',
        type: 'POST',
        data: carJson,
        contentType: 'application/json',
        success: function (data) {
            window.location.href = 'cars.html';
        },
        error: function (errorData) {
            alert(errorData.responseJSON.message);
        }
    });
}

function reserve() {
    var startDate = document.getElementById("startDate").value;
    userId = localStorage.getItem('user');
    carId = localStorage.getItem('car');

    $.ajax({
        url: BASE_URL + '/reserve/' + userId + '/' + carId + '/' + startDate,
        type: 'GET',
        success: function (data) {
            alert('Successfull!');
            window.location.href = 'cars.html';
        },
        error: function (errorData) {
            alert(errorData.responseJSON.message);
        }
    });
}

function rentCar() {
    userId = localStorage.getItem('user');
    carId = localStorage.getItem('car');
    $.ajax({
       url: BASE_URL + '/rent/' + userId + '/' + carId,
        type: 'GET',
        success: function () {
            alert("successfully rented.");
            window.location.href = 'cars.html';
        },
        error: function (errorData) {
            alert(errorData.responseJSON.message);
        }
    });
}

function upload() {
    var file = $('#file')[0].files[0];
    var formdata = new FormData();
    formdata.append('file', file);
    $.ajax({
        url: BASE_URL + '/car/upload',
        type: 'POST',
        data: formdata,
        contentType: false,
        processData: false,
        success: function (data) {
            localStorage.setItem('filePath', data);
        },
        error: function (errorData) {
            alert('error');
        }
    });
}

function showOrHideFunctionality() {

    var onLoginDivs = document.getElementsByClassName('LoggedIn');
    var notLoginDivs = document.getElementsByClassName('notLoggedIn');
    var customerLoginDivs = document.getElementsByClassName('customer');
    var adminLoginDivs = document.getElementsByClassName('admin');
    if (!localStorage.getItem('user')) {
        for (var i = onLoginDivs.length; i--;) {
            var div = onLoginDivs[i];
            div.style.display = 'none';
        }
    }else {
        for (var j = notLoginDivs.length; j--;) {
            var div = notLoginDivs[j];
            div.style.display = 'none';
        }
    }

    if(localStorage.getItem('role') !== "CUSTOMER"){
        for (var i = customerLoginDivs.length; i--;) {
            var div = customerLoginDivs[i];
            div.style.display = 'none';
        }
    }
    if(localStorage.getItem('role') !== "ADMIN"){
        for (var i = adminLoginDivs.length; i--;) {
            var div = adminLoginDivs[i];
            div.style.display = 'none';
        }
    }

}