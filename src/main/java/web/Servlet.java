package web;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

@WebServlet("/Servlet")
public class Servlet extends HttpServlet{
    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException{
        response.setContentType("text/html; charset=UTF-8");
        PrintWriter salida = response.getWriter();
        
        //Guardamos en variable usuario lo que pongan en la caja de texto usuario del HTML
        String usuario = request.getParameter("usuario");
        //Guardamos en variable password lo que pongan en la caja de texto usuario del HTML
        String password = request.getParameter("password");
        
        
        //Es un arreglo pues pueden ser varias tecnologiasa la vez
        //Usamos el metodo getParameterValues ya que puede regresar varios valores
        String tecnologias[] = request.getParameterValues("tecnologia");
        
        //Recuperamos el valor de Genero
        String genero = request.getParameter("genero");
        
        //Para obtener el valor de la ocupacion
        String ocupacion = request.getParameter("ocupacion");
        
        //Arreglo para varios valores musicales
        String musica[] = request.getParameterValues("musica");
        
        //Obtenemos el valor de los comentarios
        String comentarios = request.getParameter("comentarios");
        
        
        /*Presentamos los valores recogidos que fueron enviados desde el front*/
        salida.print("<html>");
        salida.print("<head>");
        salida.print("<title>Resultado Servlet</title>");
        salida.print("</head>");
        salida.print("<body>");
        salida.print("<h1>Parametros Procesados por el Servlet:</h1>");
        salida.print("<table border='1'>");
        
        
        //Primer variable presentada
        salida.print("<tr>");
        salida.print("<td>");
        salida.print("Usuario:");
        salida.print("</td>");
        salida.print("<td>");
        salida.print(usuario);
        salida.print("</td>");
        salida.print("</tr>");
        
        
        
        //Segunda variable presentada
        salida.print("<tr>");
        salida.print("<td>");
        salida.print("Password:");
        salida.print("</td>");
        salida.print("<td>");
        salida.print(password);
        salida.print("</td>");
        salida.print("</tr>");
        
        
        
        //Impresion de Tecnologias usando foreach
        salida.print("<tr>");
        salida.print("<td>");
        salida.print("Tecnologia:");
        salida.print("</td>");
        salida.print("<td>");
        
        for(String tecnologia: tecnologias){
            salida.print(tecnologia);
            salida.print(" / ");
        }
        
        salida.print("</td>");
        salida.print("</tr>");
        
        
        
        //Impresion de Genero
        salida.print("<tr>");
        salida.print("<td>");
        salida.print("Genero:");
        salida.print("</td>");
        salida.print("<td>");
        salida.print(genero);
        salida.print("</td>");
        salida.print("</tr>");
        
        
        
        //Impresion de Ocupacion
        salida.print("<tr>");
        salida.print("<td>");
        salida.print("Ocupacion:");
        salida.print("</td>");
        salida.print("<td>");
        salida.print(ocupacion);
        salida.print("</td>");
        salida.print("</tr>");
        
        
        
        
        
        
        //Impresion de Musica usando foreach
        //Es necesario validar esta parte ya que no era obligatoria en el formulario
        //por lo tanto el usuario puede o no poner este dato
        //Si esto no se valida y el user no manda dato nos lleva a un error
        salida.print("<tr>");
        salida.print("<td>");
        salida.print("Musica Favorita:");
        salida.print("</td>");
        salida.print("<td>");
        
        //Si musica es diferente de null que no se presente nada
        if(musica != null){
        for(String gustoMusical: musica){
            salida.print(gustoMusical);
            salida.print(" / ");
        }
        }else{
            salida.print("Musica Favorita No Seleccionada");
        }
        salida.print("</td>");
        salida.print("</tr>");
        
        
        
        
        
        //Impresion de Comentarios
        salida.print("<tr>");
        salida.print("<td>");
        salida.print("Comentarios:");
        salida.print("</td>");
        salida.print("<td>");
        salida.print(comentarios);
        salida.print("</td>");
        salida.print("</tr>");
        
        
        
        
        
        
        salida.print("</table>");
        salida.print("</body>");
        salida.print("</html>");   
    }
}