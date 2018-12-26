var linc=document.getElementById("linc");
var p=0;
function dayNightFunction() {

    if(p%2==0)
    {
        linc.href="http://localhost:63342/money/templates/page_2.css";
    }
    else
    {
        linc.href="http://localhost:63342/money/templates/page_1.css";
    }
    p++;

}