
window.onload=init;

function init(){
    document.getElementById("iniciar").addEventListener('click',validarLogin,false);
}
function validarLogin(evento)	
{		
     
	if (validarLog(this)){
                
		return true;
        }else
	{
           
		// Cancelamos el evento de envío por defecto asignado al boton de submit enviar.
		evento.preventDefault();		
		return false;	
	}
   
}






function validarLog(objeto)
{
  	
    correcto = true;
    eliminarError(objeto);
 	

	if(document.getElementById("user").type == "text" && document.getElementById("user").value=="")
	{
			document.getElementById("user").className="error1";
			document.getElementById("user").focus();
			document.getElementById("loginfail").innerHTML="Rellena el campo Nombre";
		correcto = false;
	}
  
	if(document.getElementById("pass").type == "password" && document.getElementById("pass").value=="")
		{
			document.getElementById("pass").className="error1";
			document.getElementById("pass").focus();
			document.getElementById("loginfail").innerHTML=document.getElementById("loginfail").innerHTML+"<br/>Rellena el campo contraseña";
		correcto = false;
		}
		
		
	return correcto;

  
}



function eliminarError(objeto)
{
	var formulario = objeto.form;	
	document.getElementById("loginfail").innerHTML="";

	for (var i=0; i<formulario.elements.length; i++)
	{
		
		formulario.elements[i].className="";
	}
}


