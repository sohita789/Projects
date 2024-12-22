<%@ page isELIgnored="false" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>SignIn Page</title>
    <!-- Bootstrap CSS -->
    <link href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css" rel="stylesheet">
    <style>
        body {
            background-image: url(https://th.bing.com/th/id/OIP.4ZN9MdMKO5ws-uAAmYfc8QHaFj?w=253&h=190&c=7&r=0&o=5&pid=1.7);
            background-size: cover;
            background-repeat: no-repeat;
            background-position: center;
            font-family: 'Segoe UI', Tahoma, Geneva, Verdana, sans-serif;
            color: #333;
        }

        .container {
            background-color: rgba(255, 255, 255, 0.9);
            border-radius: 15px;
            padding: 30px;
            box-shadow: 0px 4px 15px rgba(0, 0, 0, 0.3);
            margin-top: 100px;
        }

        h1 {
            font-size: 2.5rem;
            color: #512da8;
            font-weight: normal;
            margin-bottom: 20px;
        }

        label {
            font-weight: normal;
            color: #3f51b5;
        }

        .form-control {
            border-radius: 10px;
        }

        .btn-primary {
            background-color: blue;
            border: none;
            border-radius: 10px;
            padding: 10px 20px;
            transition: background-color 0.3s;
        }

        .btn-primary:hover {
            background-color: blue;
        }

        footer {
            margin-top: 50px;
            text-align: center;
            color: purple;
            font-size: 1em;
            padding: 10px;
            background-color: rgba(63, 81, 181, 0.7);
        }
    </style>
</head>
<body>

    <div class="container">
        <h1 class="text-center">Sign In</h1>
        <form action="SigninServlet" method="POST">
            <div class="form-group">
                <label for="email">Email</label>
                <input type="email" class="form-control" id="email" name="email" placeholder="Enter your email" required>
            </div>

            <div class="form-group">
                <label for="password">Password</label>
                <input type="password" class="form-control" id="password" name="password" placeholder="Enter your password" required>
            </div>

            <button type="submit" class="btn btn-primary btn-block">Sign In</button>
        </form>
        
        <div class="reset-link">
      <a href="ResetPassword.jsp" class="btn btn-link">Reset your Password</a>
    </div>
         ${msg}
    </div>

    <!-- Bootstrap JS (Optional) -->
    <script src="https://code.jquery.com/jquery-3.5.1.slim.min.js"></script>
    <script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.4.4/dist/umd/popper.min.js"></script>
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
</body>
</html>