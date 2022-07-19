<%-- 
    Document   : index
    Created on : 03-sep-2021, 15:00:10
    Author     : Hugo Daniel Velasquez Patzan
--%>
<%@page contentType="text/html"  pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Inicio Control Academico</title>
        <link rel="stylesheet" href="./assets/css/bootstrap.css">
        <link rel="stylesheet" href="./assets/css/style.css">
        <meta name="viewport" content="width=device-width, initial-scale=1">
    </head>
    <body>
        <h1 class="text-center">Control Academico</h1>
        

        <jsp:include page="WEB-INF/paginas/comunes/cabecera.jsp"/>
        <script src="./assets/js/jquery-3.6.0.js"></script>
        <script src="./assets/js/bootstrap.bundle.js"></script>
        <jsp:include page="WEB-INF/paginas/comunes/pie-pagina.jsp"/>
        <main>

            <section id = "contenido">
                <p class="descripcion">
                    Este proyecto esta hecho para el correcto manejo de datos, poder mostrar, editar, agregar y eliminar datos. 
                </p>

                <img id="kinal-img-principal" src="./assets/images/principal.png">

                
                <p class="descripcion" id = "contenido">
                    Nuestro principal objetivo es entregar un proyecto funcional y sin ningun error
                </p>

            </section>

        </main>
    </body>
    
</html>