/*Recibe todo el objeto por parametro del HTML del elemento que tiene validarForma*/
function validarForma(forma){
    var usuario = forma.usuario; //Recuperamos el elemento usuario del formulario
    //Validamos si contiene un valor igual a cadena vacia o si el valor es igual a "Escribe un Usuario"
    if(usuario.value == "" || usuario.value == "Escribir usuario"){
        alert("Debe proporcionar un nombre de usuario"); //Muestra msj en navegador
        usuario.focus(); //Ponemos el foco sobre el elemento usuario
        usuario.select(); //Tambien seleccionamos este elemento, para que el usuario sepa que es lo que debe modificar
        return false; //Retornamos false para que no se envie mediante el action que hemos indicado, es decir no se enviara la infor al Servlet
    }
    
    
    
    
    
    
    var password = forma.password; //Recuperamos el valor del password del formulario  
    //Validamos si el password esta vacio o si es un password menor a 3 caracteres
    if(password.value == "" || password.value.length < 3){
        alert("Debe proporcionar un password al menos de 3 caracteres");
        password.focus(); //Ponemos el foco sobre el elemento password
        password.select(); //Tambien seleccionamos este elemento, para que el usuario sepa que es lo que debe modificar
        return false; //Retornamos false
    }
    
    
    
    
    
    
    
    
    
    //Validamos la parte de tecnologias favoritas - Esta parte es para elementos de tipo check
    var tecnologias = forma.tecnologia;
    var checkSeleccionado = false; //Indicamos una bandera incialmente como falsa
    
    //Debido a que son varias creamos un arreglo:
    for(var i = 0; i < tecnologias.length; i++){ 
        if(tecnologias[i].checked){ //La propiedad checked valida si la opcion fue seleccionada o no
            checkSeleccionado = true; //En este caso se activa la bandera
            /*La condicion cae aqui en caso de que si se halla seleccionado alguna opcion 
                dentro de tecnologias*/
        }
    }
    
    //En caso de que no se halla seleccionado ninguna tecnologia muestra el mensaje
    if(!checkSeleccionado){
        alert("Debe seleccionar al menos una tecnología");
        return false; //Retornamos falso, por lo tanto no se manda el formulario
    }
    
    
    
    
    
    
        
    //Validamos el genero
    var generos = forma.genero;
    var radioSeleccionado = false; //bandera
    
    //Es para ver si alguno de los elementos ha sido seleccionado
    for(var i = 0; i < generos.length; i++){
        if(generos[i].checked){
            radioSeleccionado = true; //En caso si halla sido seleccionada, se manda la respuesta
        }
    }
    
    if(!radioSeleccionado){
        alert("Debe seleccionar un genero");
        return false; //En caso no halla sido seleccionada, no se manda la respuesta
    }
    
    
    
    
    
    
    //Validamos la ocupacion
    var ocupacion = forma.ocupacion;
    if(ocupacion.value == ""){
        alert("Debe seleccionar una ocupacion");
        return false;
    }
    
    //Si todo sale bien, el formulario es Valido.
    alert("Formulario valido, enviado datos al servidor...");
    return true;
}