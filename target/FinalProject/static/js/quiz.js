function validate() {
    var isValid = true;
    $(".answers").each(function () {
        if (getCheckedCount($(this)) === 0) {
            isValid = false;
            alert("At least one answer in question must be checked!");
            return (isValid);
        }
    });
    return isValid;
}

function getCheckedCount(elem) {
    return $(elem).find("input[type=checkbox]:checked").length;
}