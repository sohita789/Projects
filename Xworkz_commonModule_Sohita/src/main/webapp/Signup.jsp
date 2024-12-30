<%@ page isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">
<head>
  <meta charset="UTF-8">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH" crossorigin="anonymous">
  <style>
    body {
      background-image: url(https://wallpaperaccess.com/full/3239480.jpg);
      background-size: cover;
      background-repeat: repeat;
      background-position: center;
    }
    .header-content {
      display: flex;
      justify-content: space-between;
      align-items: center;
      width: 100%;
    }
    .logo-img {
      width: 140px;
      height: 70px;
    }
    .header-buttons {
      display: flex;
      gap: 10px;
    }
    h1 {
      text-align: center;
      flex: 1;
      margin: 0;
    }
    .form-container {
      max-width: 600px;
      margin: 0 auto;
    }
    .error-message {
      color: red;
      font-size: 0.875rem;
    }
  </style>
  <title>Course Registration</title>
</head>
<body>
  <header class="d-flex flex-wrap justify-content-between align-items-center py-3 mb-4 border-bottom">
    <div class="header-content w-100">
      <div class="ms-3">
        <img src="https://x-workz.in/static/media/Logo.cf195593dc1b3f921369.png" alt="Xworkz" class="logo-img">
      </div>
      <h1>Course Registration</h1>
      <div class="header-buttons ms-auto">
        <form action="signup" method="post" style="display:inline;">
          <button type="submit" class="btn btn-primary">Sign Up</button>
        </form>
      </div>
    </div>
  </header>

  <div class="container form-container">
    <form action="signup" method="post" onsubmit="return validateForm()">
      <h3>Register with your Details</h3>

      <c:forEach var="i" items="${error}">
        <span style="color: red">${i.defaultMessage}</span>
      </c:forEach>

      <div class="mb-3">
        <label for="name" class="form-label">Name:</label>
        <input type="text" id="name" name="name" class="form-control" placeholder="Enter your name" required onchange="onName()">
        <span id="displayName" class="error-message"></span>
      </div>

      <div class="mb-3">
        <label for="email" class="form-label">Email:</label>
        <input type="text" id="email" name="email" class="form-control" placeholder="Enter your email" required onchange="onEmail()">
        <span id="displayEmail" class="error-message"></span>
      </div>

      <div class="mb-3">
        <label for="phoneNo" class="form-label">Phone Number:</label>
        <input type="text" id="phoneNo" name="phoneNo" class="form-control" placeholder="Enter your phone number" required onchange="onPhoneNo()">
        <span id="displayPhoneNo" class="error-message"></span>
      </div>

      <div class="mb-3">
        <label for="alterEmail" class="form-label">Alternate Email:</label>
        <input type="text" id="alterEmail" name="alterEmail" class="form-control" placeholder="Enter your alternate email" required onchange="onAlterEmail()">
        <span id="displayAlterEmail" class="error-message"></span>
      </div>

      <div class="mb-3">
        <label for="alterphoneNo" class="form-label">Alternate Phone:</label>
        <input type="text" id="alterphoneNo" name="alterphoneNo" class="form-control" placeholder="Enter your alternate phone" required onchange="onAlterPhoneNo()">
        <span id="displayAlterPhoneNo" class="error-message"></span>
      </div>

      <div class="mb-3">
        <label for="location" class="form-label">Location:</label>
        <input type="text" id="location" name="location" class="form-control" placeholder="Enter your location" required>
        <span id="displayLocation" class="error-message"></span>
      </div>

      <button type="submit" class="btn btn-primary w-100">Submit</button>
    </form>
  </div>

  <script>
var emailvalue = "";
var alterEmailValue = "";
var phoneNoValue = "";
var alterPhoneNoValue = "";

function onName() {
  var name = document.getElementById('name');
  var nameValue = name.value;

  if (nameValue.trim().length < 4) {
    document.getElementById("displayName").innerHTML = "Name must be at least 4 characters long.";
    return;
  }

  var xhttp = new XMLHttpRequest();
  xhttp.open("GET", "http://localhost:8080/Xworkz_commonModule_Sohita/name/" + nameValue, true);
  xhttp.send();

  xhttp.onload = function() {
    document.getElementById("displayName").innerHTML = this.responseText;
  }
};

function onEmail() {
  var email = document.getElementById('email');
  emailvalue = email.value;

  if (!emailvalue.includes('@gmail.com') && !emailvalue.includes('@yahoo.com') && !emailvalue.includes('@outlook.com') && !emailvalue.includes('@hotmail.com') && !emailvalue.includes('.edu') && !emailvalue.includes('.org') && !emailvalue.includes('.info') && !emailvalue.includes('.net')) {
    document.getElementById("displayEmail").innerHTML = "Enter a valid email address.";
    return;
  }

  var xhttp = new XMLHttpRequest();
  xhttp.open("GET", "http://localhost:8080/Xworkz_commonModule_Sohita/email/" + emailvalue, true);
  xhttp.send();

  xhttp.onload = function() {
    document.getElementById("displayEmail").innerHTML = this.responseText;
  }
}

function onPhoneNo() {
  var phoneNo = document.getElementById('phoneNo');
  phoneNoValue = phoneNo.value;

  if (phoneNoValue.trim().length !== 10 || (!phoneNoValue.startsWith("6") && !phoneNoValue.startsWith("7") && !phoneNoValue.startsWith("8") && !phoneNoValue.startsWith("9"))) {
    document.getElementById("displayPhoneNo").innerHTML = "Phone number must contain 10 digits and should be valid.";
    return;
  }

  var xhttp = new XMLHttpRequest();
  xhttp.open("GET", "http://localhost:8080/Xworkz_commonModule_Sohita/phoneNo/" + phoneNoValue, true);
  xhttp.send();

  xhttp.onload = function() {
    document.getElementById("displayPhoneNo").innerHTML = this.responseText;
  }
}

function onAlterEmail() {
  var alterEmail = document.getElementById('alterEmail');
  alterEmailValue = alterEmail.value;

  if (!alterEmailValue.includes('@gmail.com') && !alterEmailValue.includes('@yahoo.com') && !alterEmailValue.includes('@outlook.com') && !alterEmailValue.includes('@hotmail.com') && !alterEmailValue.includes('.edu') && !alterEmailValue.includes('.org') && !alterEmailValue.includes('.info') && !alterEmailValue.includes('.net')) {
    document.getElementById("displayAlterEmail").innerHTML = "Enter a valid email address.";
    return;
  }

  if (emailvalue === alterEmailValue) {
    document.getElementById("displayAlterEmail").innerHTML = "Email and Alternate Email should be different.";
    return;
  }

  var xhttp = new XMLHttpRequest();
  xhttp.open("GET", "http://localhost:8080/Xworkz_commonModule_Sohita/alterEmail/" + alterEmailValue, true);
  xhttp.send();

  xhttp.onload = function() {
    document.getElementById("displayAlterEmail").innerHTML = this.responseText;
  }
}

function onAlterPhoneNo() {
  var alterPhoneNo = document.getElementById('alterphoneNo');
  alterPhoneNoValue = alterPhoneNo.value;

  if (alterPhoneNoValue.trim().length !== 10 ||(!alterPhoneNoValue.startsWith("6") && !alterPhoneNoValue.startsWith("7") && !alterPhoneNoValue.startsWith("8") && !alterPhoneNoValue.startsWith("9"))) {
      document.getElementById("displayalterPhoneNo").innerHTML = "alter Phone number must contain 10 digits and should be valid.";
      return;
      }

   var xhttp = new XMLHttpRequest();
   xhttp.open("GET", "http://localhost:8080/Xworkz_commonModule_Sohita/alterPhoneNo/" + alterPhoneNoValue, true);
    xhttp.send();

    xhttp.onload = function() {
   document.getElementById("displayalterPhoneNo").innerHTML = this.responseText;
   }
   }
