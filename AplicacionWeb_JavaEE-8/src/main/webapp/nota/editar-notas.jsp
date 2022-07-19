<%-- 
    Document   : editar-notas
    Created on : Sep 28, 2021, 5:33:06 PM
    Author     : Genrry Luis
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

        <title>Editar Notas</title>
    </head>
    <body>   

        <header id="main-header" class="py-2 bg-primary text-white text-center">
            <div class="container">
                <div class="row">
                    <div class="col-12">
                        <h1>
                            Notas
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
                        <a href="${pageContext.request.contextPath}/ServletNota?accion=listar" class="btn btn-light btn-block">
                            <i class="fa fa-arrow-left"></i>Regresar a notas
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
                                <h4>Editar notas</h4>
                            </div>
                            <div class="card-body">                               
                                <!--Formulario-->
                                <form method="POST" action="${pageContext.request.contextPath}/ServletNota">
                                    <!-- -->
                                    <div class="mb-3">
                                        <label for="idNota" class="form-label">Ingrese su código</label>
                                        <input type="text" id="idNota" name="idNota" readonly="" class="form-control" value="${nota.idNota}">
                                    </div>

                                    <div class="mb-3">
                                        <label for="nombreActividad" class="form-label">Nombre Actividad</label>
                                        <input type="text" id="nombreActividad" name="nombreActividad" class="form-control" value="${nota.nombreActividad}">
                                    </div> 
                                    
                                    <div class="mb-3">
                                        <label for="notaActividad" class="form-label">Nota Actividad</label>
                                        <input type="text" id="notaActividad" name="notaActividad" class="form-control" value="${nota.notaActividad}">
                                    </div> 
                                    
                                    <div class="mb-3">
                                        <label for="fechaActividad" class="form-label">Fecha Actividad</label>
                                        <input type="text" id="fechaActividad" name="fechaActividad" class="form-control" value="${nota.fechaActividad}">
                                    </div>
                                    
                                    <div class="mb-3">
                                        <label for="idAsignacion" class="form-label">Codigo asignacion</label>
                                        <input type="text" id="idAsignacion" name="idAsignacion" class="form-control" value="${nota.idAsignacion}">
                                    </div> 
                                    
                                     <!--Para enviar el id-->
                                    <input type="hidden" name="idNota" value="${nota.idNota}">

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

        <!--javaScrip-->
        <script src="./assets/js/jquery-3.6.0.js"></script>
        <script src="./assets/js/bootstrap.bundle.js"></script>
        <!--BjavaScrip-->

    </body>
</html>
