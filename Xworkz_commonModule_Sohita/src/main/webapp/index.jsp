<%@ page isELIgnored="false" %>
<!DOCTYPE html>
<html lang="en">
<head>
  <meta charset="UTF-8">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <title>Internship Form</title>
  <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH" crossorigin="anonymous">
  <style>
    body {
      background-color: #f0f8ff;
      background-image: url(https://wallpaperaccess.com/full/3239480.jpg);
      background-size: cover;
      background-repeat: repeat;
      background-position: center;
    }
    header {
      background-color: lightblue;
      color: black;
    }
    .logo-img {
      border-radius: 15px;
    }
    h1 {
      font-size: 2rem;
      font-weight: bold;
    }
    .btn-primary:hover {
      background-color: pink;
      border-color: orange;
    }
  </style>
</head>
<body>
<header class="d-flex flex-wrap justify-content-between align-items-center py-3 mb-4 border-bottom">
  <div class="d-flex align-items-center ms-3">
    <img src="https://x-workz.in/static/media/Logo.cf195593dc1b3f921369.png" width="180" height="100" alt="Xworkz" class="logo-img">
  </div>

  <div class="text-center flex-grow-1">
    <h1>Welcome to Xworkz Institute</h1>
  </div>

  <ul class="nav nav-pills me-3">
    <li class="nav-item">
      <button class="btn btn-primary rounded-pill px-3" type="button" onClick="signUp()">SignUp</button>
    </li>
    <li class="nav-item">
      <button class="btn btn-primary rounded-pill px-3" type="button" onClick="login()">Login</button>
    </li>
    <li class="nav-item">
      <button class="btn btn-primary rounded-pill px-3" type="button" onClick="resetPassword()">Reset Password</button>
    </li>
  </ul>
</header>

<script>
  function signUp() {
    window.location.href = "Signup.jsp";
  }

  function login() {
    window.location.href = "Signin.jsp";
  }

  function resetPassword() {
    window.location.href = "ResetPassword.jsp";
  }
</script>
</body>
</html>
