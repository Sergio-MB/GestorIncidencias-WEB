window.onload = init;

function init() {
    document.getElementById("registrarauto").addEventListener('click', validarAuto, false);

}
function validarAuto(evento)
{

    if (validarALL(this)) {

        return true;
    } else
    {
        // Cancelamos el evento de envío por defecto asignado al boton de submit enviar.
        evento.preventDefault();
        return false;
    }

}



function validarALL(objeto)
{
    eliminarError(objeto);
    if (document.getElementById("usernombre").type == "text" && document.getElementById("usernombre").value == "")
    {
        document.getElementById("usernombre").className = "error1";
        document.getElementById("usernombre").focus();
        document.getElementById("loginfail").innerHTML = "Rellena el campo Nombre de usuario";
        return false;
    }
    if (document.getElementById("pass").type == "password" && document.getElementById("pass").value == "")
    {
        document.getElementById("pass").className = "error1";
        document.getElementById("pass").focus();
        document.getElementById("loginfail").innerHTML = document.getElementById("loginfail").innerHTML + "<br/>Rellena el campo contraseña";
        return false;
    }
    if (document.getElementById("nom").type == "text" && document.getElementById("nom").value == "")
    {
        document.getElementById("nom").className = "error1";
        document.getElementById("nom").focus();
        document.getElementById("loginfail").innerHTML = document.getElementById("loginfail").innerHTML + "<br/>Rellena el campo nombre";
        return false;
    }
    if (document.getElementById("ape").type == "text" && document.getElementById("ape").value == "")
    {
        document.getElementById("ape").className = "error1";
        document.getElementById("ape").focus();
        document.getElementById("loginfail").innerHTML = document.getElementById("loginfail").innerHTML + "<br/>Rellena el campo apellidos";
        return false;

    }



    valor = document.getElementById("nif").value;
    var letras = ['T', 'R', 'W', 'A', 'G', 'M', 'Y', 'F', 'P', 'D', 'X', 'B', 'N', 'J', 'Z', 'S', 'Q', 'V', 'H', 'L', 'C', 'K', 'E', 'T'];

    if (!(/^\d{8}[A-Z]$/.test(valor))) {
        document.getElementById("nif").focus();
        document.getElementById("nif").className = "error1";
        document.getElementById("loginfail").innerHTML = document.getElementById("loginfail").innerHTML + "<br/>NIF incorrecto";
        return false;
    }

    if (valor.charAt(8) != letras[(valor.substring(0, 8)) % 23]) {
        document.getElementById("nif").focus();
        document.getElementById("nif").className = "error1";
        document.getElementById("loginfail").innerHTML = document.getElementById("loginfail").innerHTML + "<br/>NIF incorrecto";
        return false;
    }

    patron = /^\d{5}$/;
    if (!patron.test(document.getElementById("cp").value))
    {

        document.getElementById("cp").focus();
        document.getElementById("cp").className = "error1";
        document.getElementById("loginfail").innerHTML = document.getElementById("loginfail").innerHTML + "<br/>Codigo postal incorrecto";
        return false;
    }

    patron = /^([a-zA-Z0-9_\.\-])+\@(([a-zA-Z0-9\-])+\.)+([a-zA-Z0-9]{2,4})+$/;
    if (!patron.test(document.getElementById("mail").value))
    {
        document.getElementById("mail").focus();
        document.getElementById("mail").className = "error1";
        document.getElementById("loginfail").innerHTML = document.getElementById("loginfail").innerHTML + "<br/>Email incorrecto";
        return false;
    }
    
    patron = /^\d{9}$/;
    if (!patron.test(document.getElementById("tel").value))
    {
        document.getElementById("tel").focus();
        document.getElementById("tel").className = "error1";
        document.getElementById("loginfail").innerHTML = document.getElementById("loginfail").innerHTML + "<br/>Telefono incorrecto";
        return false;
    }

    return true;
}




function eliminarError(objeto)
{
    var formulario = objeto.form;
    document.getElementById("loginfail").innerHTML = "";

    for (var i = 0; i < formulario.elements.length; i++)
    {

        formulario.elements[i].className = "";
    }
}


