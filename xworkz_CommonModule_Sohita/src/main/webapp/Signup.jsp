

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>SignUp </title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet">
    <style>
        .form-container {
            border: 1px solid #ddd; 
            border-radius: 10px; 
            box-shadow: 0 4px 8px rgba(0, 0, 0, 0.1); 
            padding: 20px; 
            background-color: lightblue; 
            max-width: 500px; 
            margin: 20px auto; 
            
        }
      .error {
            color: blue;
            font-size: 14px;
        }
        </style>
</head>
<body>
<div class="form-container">
    <h3 class="text-center mb-4">SignUp Form</h3>
    <form action="SignupServlet" method="post" onsubmit="return validateForm()">
        <div class="mb-3">
            <label for="name" class="form-label">Name</label>
            <input type="text" class="form-control" id="name" name="name" placeholder="Enter your name" oninput="validateName()">
            <p id="nameError" class="error" style="display: none;">Name should be at least 10 characters long.</p>
        </div>
        <div class="mb-3">
            <label for="email" class="form-label">Email</label>
            <input type="email" class="form-control" id="email" name="email" placeholder="Enter your email">
            <p id="emailError" class="error" style="display: none;">Age should be greater than 18.</p>
        </div>
        <div class="mb-3">
            <label for="phoneNo" class="form-label">PhoneNo</label>
            <input type="number" class="form-control" id="phoneNo" name="phoneNo" placeholder="Enter your phoneNo">
            <p id="phoneNoError" class="error" style="display: none;">Please enter a valid Gmail address.</p>
        </div>
        <div class="mb-3">
            <label for="alterEmail" class="form-label">AlterEmail</label>
            <input type="email" class="form-control" id="alterEmail" name="alterEmail" placeholder="Enter your alterEmail">
            <p id="alterEmailError" class="error" style="display: none;">Password should be at least 7 characters long and contain special characters.</p>
        </div>
        <div class="mb-3">
            <label for="alterPhoneNo" class="form-label">AlterPhoneNo</label>
            <input type="number" class="form-control" id="alterPhoneNo" name="alterPhoneNo" placeholder="Enter your alterPhoneNo">
            <p id="alterPhoneNoError" class="error" style="display: none;">Passwords should match.</p>
        </div>
        <div class="mb-3">
            <label for="location" class="form-label">Location</label>
            <input type="text" class="form-control" id="location" name="location" placeholder="Enter your location">
            <p id="locationError" class="error" style="display: none;">Phone number should start with 9 and contain 10 digits.</p>
        </div>
       
        <div class="text-center">
            <button type="submit" class="btn btn-primary">Submit</button>
        </div>
    </form>
    <h3>${name}</h3>
</div>

<script>
    function validateName() {
        const nameField = document.getElementById('userName');
        const nameError = document.getElementById('nameError');

        if (nameField.value.length < 10) {
            nameError.style.display = 'block';
        } else {
            nameError.style.display = 'none';
        }
    }

    function validateForm() {
        let isValid = true;

        const nameField = document.getElementById('userName');
        const nameError = document.getElementById('nameError');
        if (nameField.value.length < 10) {
            nameError.style.display = 'block';
            isValid = false;
        } else {
            nameError.style.display = 'none';
        }


        return isValid;
    }
</script>
</body>