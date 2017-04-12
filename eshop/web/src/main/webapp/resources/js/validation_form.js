$(function () {
    $("#registration_id").validate({
        rules: {
            name: {required: true, minlength: 3},
            email: {required: true, email: true},
            message: {required: true, minlength: 5},
            password: {required: true, minlength: 5},
            password_again: {required: true, minlength: 5, equalTo: "#password"}
        },
        messages: {
            name: {required: 'Name is required', minlength: 'Minimum length: 3'},
            phone: {
                required: 'Phone Number is required',
                number: 'Invalid phone number',
                minlength: 'Minimum length: 6'
            },
            email: {required: 'E-mail is required', email: 'Invalid e-mail address'},
            password: {required: 'Password is required', minlength: 'Minimum length: 5'},
            password_again: {required: 'Password is required', minlength: 'Minimum length: 5', equalTo: "uuiuiuisword"}
        },
        success: function (label) {
            label.html('OK').removeClass('error').addClass('ok');
            setTimeout(function () {
                label.fadeOut(500);
            }, 2000)
        }
    });
});