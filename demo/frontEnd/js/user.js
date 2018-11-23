BASE_URL = 'http://localhost:8080/';
var userId;

function login() {
    // accepting data from Login Form and out it in a object
    var userForm = { // constructing object
        email : document.getElementById("email").value, // accepting Form data
        password : document.getElementById("password").value // accepting password from the form
    };
    // convert UserForm object to JSON
    var userJson = JSON.stringify(userForm);
    // calling the backend api
    $.ajax({
        url: BASE_URL + '/user/login',
        type: 'POST',
        data : userJson,
        contentType: 'application/json',
        success:function (data) {
            localStorage.setItem('user', data.id);
            localStorage.setItem('role', data.who_R_U);
            window.location.href = 'cars.html';
        },
        error : function (errorData) {
            alert(errorData.responseJSON !== undefined?errorData.responseJSON.message:errorData.responseJSON);
        }
    });
}
function logout(){
    localStorage.clear();
    window.location.href = 'cars.html';
}
function signup() {
    // DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MMM-dd");
    // LocalDate dt = DateTimeFormatter.ofPattern("yyyy-MMM-dd").parseLocalDate(document.getElementById("dob").value);
    var userForm = {
        firstName : document.getElementById("firstname").value,
        lastName : document.getElementById("lastname").value,
        dob : document.getElementById("dob").value,
        // dob : DateTimeFormatter.ofPattern("yyyy-MMM-dd").parseLocalDate(document.getElementById("dob").value),  //???
        gender : document.getElementById("gender").value,
        email : document.getElementById("email").value,
        password : document.getElementById("password").value,
        who_R_U:"CUSTOMER",
        address:{
            street:document.getElementById("street").value,
            city:document.getElementById("city").value,
            state:document.getElementById("state").value,
            zip:document.getElementById("zip").value,
        }
    };
    var userJson = JSON.stringify(userForm);
    $.ajax({
        url:BASE_URL + 'user',
        type: 'POST',
        data : userJson,
        contentType: 'application/json',
        success :function () {
            alert("signUp successfull");
            window.location.href = 'cars.html';
        },
        error : function () {
            alert("try again");
        }
    })
}