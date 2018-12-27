var linc=document.getElementById("linc");
var p=0;
function dayNightFunction() {

    if(p%2==0)
    {
        linc.href="../page_2.css";
    }
    else
    {
        linc.href="../page_1.css";
    }
    p++;

}