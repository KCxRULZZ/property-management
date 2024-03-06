function validateMobileNumber(input) {
    var mobile = input.value;
    var mobileErr = document.getElementById("mobileErr");

    var regex = /^[0-9]{10}$/;  // 10-digit mobile number

    if (!regex.test(mobile)) {
        mobileErr.innerHTML = "Please enter a valid 10-digit mobile number<br>";
        mobileErr.style.color = "red"; // Set text color to red
        mobileErr.style.fontSize = "12px"; // Set font size to a smaller size
        input.classList.add("input-2");
        input.classList.remove("input-1");
    } else {
        mobileErr.innerHTML = "";
        input.classList.add("input-1");
        input.classList.remove("input-2");
    }
}

function validateAmount(input) {
    var amount = input.value;
    var amountErr = document.getElementById("amountErr");

    if (amount === "") {
        amountErr.innerHTML = "Please enter the property amount<br>";
        amountErr.style.color = "red"; // Set text color to red
        amountErr.style.fontSize = "12px"; // Set font size to a smaller size
        input.classList.add("input-2");
        input.classList.remove("input-1");
    } else if (isNaN(amount) || parseFloat(amount) <= 0) {
        amountErr.innerHTML = "Please enter a valid positive number<br>";
        amountErr.style.color = "red"; // Set text color to red
        amountErr.style.fontSize = "12px"; // Set font size to a smaller size
        input.classList.add("input-2");
        input.classList.remove("input-1");
    } else if (parseFloat(amount) < 0) {
        amountErr.innerHTML = "Please enter a positive number (negative numbers are not allowed)<br>";
        amountErr.style.color = "red"; // Set text color to red
        amountErr.style.fontSize = "12px"; // Set font size to a smaller size
        input.classList.add("input-2");
        input.classList.remove("input-1");
    } else {
        amountErr.innerHTML = "";
        input.classList.add("input-1");
        input.classList.remove("input-2");
    }
}

