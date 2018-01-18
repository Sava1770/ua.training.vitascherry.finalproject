function getCheckedCount(elem) {
    return $(elem).find("input[type=radio]:checked").length;
}

var allRadios = document.getElementsByClassName("picker");
var temp;
var i;
for(i = 0; i < allRadios.length; i++) {
    allRadios[i].onclick = function() {
        if(temp === this){
            this.checked = false;
            temp = null;
        } else {
            temp = this;
        }
    };
}