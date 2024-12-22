<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Index Page</title>
    <!-- Bootstrap CSS -->
    <link href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css" rel="stylesheet">
    <style>
        body {
            background-image: url(https://th.bing.com/th/id/OIP.4ZN9MdMKO5ws-uAAmYfc8QHaFj?w=253&h=190&c=7&r=0&o=5&pid=1.7);
            background-size: cover;
            background-repeat: repeat;
            background-position: center;
            /*font-family: 'Segoe UI', Tahoma, Geneva, Verdana, sans-serif;*/
            color: #333; /* For readability */
        }
        /* Header Section */
        .header {
            padding: 15px;
            background-color: rgba(63, 81, 181, 0.85); /* Semi-transparent indigo */
            display: flex;
            justify-content: space-between;
            align-items: center;
            border-bottom: 2px solid #5c6bc0;
            box-shadow: 0px 2px 5px rgba(0, 0, 0, 0.2);
        }
        .logo img {
            height: 80px;
        }
        .auth-links a {
            font-size: 1.2em;
            margin-right: 15px;
            text-decoration: none;
            color: pink; 
            font-weight: normal;
            transition: color 0.3s;
        }
        .auth-links a:hover {
            color: lightblue; 
        }

        /* Content Container */
        .container {
            background-color: rgba(255, 255, 255, 0.9); /* Lightened semi-transparent white */
            border-radius: 15px;
            padding: 40px;
            box-shadow: 0px 4px 15px rgba(0, 0, 0, 0.3);
            margin-top: 80px;
        }
        h1 {
            font-size: 2.8rem;
            margin-bottom: 20px;
            color: #512da8; /* Deep purple */
            font-weight: bold;
        }
        p {
            font-size: 1.2em;
            color: #3f51b5; /* Indigo for subtle contrast */
        }

        /* Footer Section */
        footer {
            margin-top: 50px;
            text-align: center;
            color: pink; 
            font-size: 1em;
            padding: 10px;
            background-color: rgba(63, 81, 181, 0.7); /* Footer background */
        }
        footer p {
            margin: 0;
        }
    </style>
</head>
<body>

    <!-- Header -->
    <div class="header">
        <div class="logo">
            <img src="https://th.bing.com/th?id=OIP.5W588qZyeMAuWUs1PAIKyAAAAA&w=250&h=250&c=8&rs=1&qlt=90&o=6&pid=3.1&rm=2" alt="Logo">
        </div>
        <div class="auth-links">
            <a href="Signin.jsp" class="signin-link">SignIn</a>
            <a href="Signup.jsp" class="signup-link">SignUp</a>
             <a href="Success.jsp" class="success-link">Success</a>
        </div>
    </div>

    <!-- Body Content -->
    <div class="container text-center">
        <h1>Welcome </h1>
        
    </div>
    <!-- Bootstrap JS (Optional) -->
    <script src="https://code.jquery.com/jquery-3.5.1.slim.min.js"></script>
    <script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.4.4/dist/umd/popper.min.js"></script>
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>

</body>
</html>