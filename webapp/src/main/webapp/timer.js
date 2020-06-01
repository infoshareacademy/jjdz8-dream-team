function timer()
{
    var today = new Date();

    var day = today.getDate();
    var month = today.getMonth()+1;
    var year = today.getFullYear();

    var godzina = today.getHours();
    if (godzina<10) godzina = "0"+godzina;

    var minuta = today.getMinutes();
    if (minuta<10) minuta = "0"+minuta;

    var sekunda = today.getSeconds();
    if (sekunda<10) sekunda = "0"+sekunda;

    document.getElementById("zegar").innerHTML =
        day+"/"+month+"/"+year+" | "+godzina+":"+minuta+":"+sekunda;

    setTimeout("timer()",1000);
}