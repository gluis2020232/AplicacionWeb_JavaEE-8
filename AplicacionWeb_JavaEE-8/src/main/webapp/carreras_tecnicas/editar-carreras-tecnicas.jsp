<%-- 
    Document   : editar-carreras-tecnicas
    Created on : 17-sep-2021, 12:01:35
    Author     : Hugo Daniel Velasquez Patzan
--%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!--Para iterar los registros de la tablas y poder mostrarlos en la pagina-->
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html>
    <head>

        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="./assets/css/style.css">
        <meta name="viewport" content="width=device-width, initial-scale=1">

        <!--Bostsrap-->
        <link rel="stylesheet" href="./assets/css/bootstrap.css">
        <!--Bostsrap-->

        <script src="https://kit.fontawesome.com/f90d3bf50d.js"></script>

        <title>Editar Carreras Técnicas</title>
    </head>
    <body>   

        <header id="main-header" class="py-2 bg-primary text-white text-center">
            <div class="container">
                <div class="row">
                    <div class="col-12">
                        <h1>
                            Carreras Tecnicas
                        </h1>
                    </div>
                </div>
            </div>
        </header> 

        <!--Cabecera (header y nav) -->
        <jsp:include page="/WEB-INF/paginas/comunes/cabecera.jsp"/>
        <!--Cabecera (header y nav) -->


        <section id="actions" class="by-4 mb-4 bg-light">
            <div class="container">
                <div class="row">
                    <div class="col-md-3"><!--Especificar la cantidad de columnas-->
                        <a href="${pageContext.request.contextPath}/ServletCarreraTecnica?accion=listar" class="btn btn-light btn-block">
                            <i class="fa fa-arrow-left"></i>Regresar a Carreras tecnicas
                        </a>
                    </div>
                    <div class="col-md-3">

                    </div>
                    <div class="col-md-3">

                    </div>
                </div>
            </div>
        </section>


        <main>
            <div class="container">
                <div class="row">
                    <div class="col-12">
                        <div class="card">
                            <div class="card-header">
                                <h4>Editar carrera tecnica</h4>
                            </div>
                            <div class="card-body">                               
                                <!--Formulario-->
                                <form method="POST" action="${pageContext.request.contextPath}/ServletCarreraTecnica">
                                    <!-- -->
                                    <div class="mb-3">
                                        <label for="codigoCarrera" class="form-label">Ingrese su código</label>
                                        <input type="text" id="codigoCarrera" name="codigoCarrera" readonly="" class="form-control" value="${carreraTecnica.codigoCarrera}">
                                    </div>

                                    <div class="mb-3">
                                        <label for="nombre" class="form-label">Nombre carrera</label>
                                        <input type="text" id="nombre" name="nombre" class="form-control" value="${carreraTecnica.nombre}">
                                    </div>   
                                    
                                     <!--Para enviar el id-->
                                    <input type="hidden" name="codigoCarrera" value="${carreraTecnica.codigoCarrera}">

                                    <input type="hidden" name="accion" value="actualizar">

                                     <!--El boton submit envía todo lo que esta dentro del formulario hacia el Servlet-->
                                    <button type="button" class="btn btn-danger" data-bs-dismiss="modal">Cancelar</button>
                                    <button type="submit" class="btn btn-success">Guardar cambios</button>
                                </form>
                                <!--Finalizacion de Formulario-->
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </main>

        <!--Pie de pagina (footer) -->
        <jsp:include page="/WEB-INF/paginas/comunes/pie-pagina.jsp"/>
        <!--Pie de pagina (footer) -->

        <!--javaScrip-->
        <script src="./assets/js/jquery-3.6.0.js"></script>
        <script src="./assets/js/bootstrap.bundle.js"></script>
        <!--BjavaScrip-->

    </body>
</html>