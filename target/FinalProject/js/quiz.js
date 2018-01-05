function validate() {
    var result = true;
    $(".answers").each(function () {
        var n = validateEach($(this));
        if (n == 0) {
            result = false;
        }
    });
    /*if (result) {
        // input is valid -- reset the error message
        form.setCustomValidity("");
    } else {
        form.setCustomValidity("At least one answer must be checked!");
    }*/
    return result;
}

function validateEach(elem) {
    return $(elem).find("input[type=checkbox]:checked").length;
}