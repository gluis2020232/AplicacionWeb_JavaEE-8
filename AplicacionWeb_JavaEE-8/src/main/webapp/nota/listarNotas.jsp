<%-- 
    Document   : listarNotas
    Created on : Sep 27, 2021, 4:57:57 AM
    Author     : César Luis
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!--Para iterar los registros de la tablas y poder mostrarlos en la pagina-->
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html>
    <head>

        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="../assets/css/style.css">
        <meta name="viewport" content="width=device-width, initial-scale=1">

        <!--Bostsrap-->
        <link rel="stylesheet" href="../assets/css/bootstrap.css">
        <!--Bostsrap-->

        <script src="https://kit.fontawesome.com/f90d3bf50d.js"></script>

        <title>Notas</title>
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

        <header id="main-header" class="py-2 bg-light pt-4">
            <div class="container">
                <div class="row">
                    <div class="col-12">
                        <h1>
                            <i class="fas fa-cog"> </i>Control Notas<i class="fas fa-cog"> </i>
                        </h1>
                    </div>
                </div>
            </div>
        </header>


        <!-- Agregar Notas -->s
        <section id="acciones" class="py-4 mb-4 pt-1 pb-1" >
            <div class="container">
                <div class="row">
                    <div class="col-12 col-md-3">
                        <a id="btn-agregar-notas" data-bs-toggle="modal" data-bs-target="#agregar-notas-modal" class="btn btn-outline-info">
                            <i class="fas fa-plus"></i> Agregar Notas
                        </a>
                    </div>
                </div>
            </div>
        </section>


        <!-- Modal Para agregar Notas -->
        <div class="modal fade" id="agregar-notas-modal" tabindex="-1" aria-labelledby="exampleModalLabel" aria-hidden="true">
            <div class="modal-dialog">
                <div class="modal-content">
                    <div class="modal-header bg-primary text-white">
                        <h5 class="modal-title" id="exampleModalLabel">Agregar Notas</h5>
                        <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
                    </div>

                    <!--Formulario-->
                    <form method="POST" action="${pageContext.request.contextPath}/ServletNota">
                        <div class="modal-body">

                            <div class="mb-3">
                                <label for="nombreActividad" class="form-label">Nombre Actividad</label>
                                <input type="text" id="nombreActividad" name="nombreActividad" class="form-control">
                            </div>

                            <div class="mb-3">
                                <label for="notaActividad" class="form-label">Nota Actividad</label>
                                <input type="text" id="notaActividad" name="notaActividad" class="form-control">
                            </div>
                            
                            <div class="mb-3">
                                <label for="fechaActividad" class="form-label">Fecha Actividad</label>
                                <input type="text" id="fechaActividad" name="fechaActividad" class="form-control">
                            </div>
                            
                            <div class="form-floating mb-3">
                                <input type="text" id="idAsignacion" name="idAsignacion" class="form-control" step="any" placeholder="idNota">
                                <label for="idAsignacion" class="form-label">Codigo Asignacion</label>
                            </div>
                            
                            <input type="hidden" name="accion" value="insertar">
                            
                        </div>
                        
                        <div class="modal-footer">
                            <button type="button" class="btn btn-danger" data-bs-dismiss="modal">Cancelar</button>
                            <button type="submit" class="btn btn-success">Guardar</button>
                        </div>
                    </form>
                </div>
            </div>
        </div>
        <!-- Button trigger modal -->


        <section id="estudiantes">
            <div class="container">
                <div class="row">
                    <div class="col-xs-12 col-md-12">

                        <div class="card text-lg-center">
                            <div class="card-header">
                                <h4> <i class="fas fa-school"></i> Listado Notas <i class="fas fa-school"></i> </h4>
                            </div>
                        </div>

                        <!--Creando la tabla-->
                        <!--Encabezado-->
                        <table class="table table-striped">
                            <thead class="table-primary">
                                <tr>
                                    <th>#</th>
                                    <th>Nombre Actividad</th>
                                    <th>Nota Actividad</th>
                                    <th>Fecha Actividad</th>
                                    <th>Asignacion</th>
                                    <th></th>
                                    <th></th>
                                </tr>
                            </thead>
                            <!--Cuerpo-->
                            <tbody>
                                <!--Implementamos un ciclo for "jstl" que me permite recorrer todo ese arreglo-->
                                <c:forEach var="nota" items="${listadoNotas}">
                                    <tr>
                                        <td>${nota.idNota}</td>
                                        <td>${nota.nombreActividad}</td>
                                        <td>${nota.notaActividad}</td>
                                        <td>${nota.fechaActividad}</td>
                                        <td>${nota.idAsignacion}</td>
 <!--.getIdAsignacion()-->
                                        <td>
                                            <a class="btn btn-outline-success" href="${pageContext.request.contextPath}/ServletNota?accion=editar&id_nota=${nota.idNota}">
                                                <i class="fas fa-user-edit"></i> Editar
                                            </a>
                                        </td>

                                        <td>
                                            <a class="btn btn-outline-danger" href="${pageContext.request.contextPath}/ServletNota?accion=eliminar&id_nota=${nota.idNota}">
                                                <i class="fas fa-trash-alt"></i> Eliminar
                                            </a>
                                        </td>
                                    </tr>
                                </c:forEach>
                            </tbody>
                        </table><!--Finalización de la tablas-->                      
                    </div>
                </div>
            </div>
        </section>

        <!--Pie de pagina (footer) -->
        <jsp:include page="/WEB-INF/paginas/comunes/pie-pagina.jsp"/>
        <!--Pie de pagina (footer) -->

        <!--javaScrip-->
        <script src="../assets/js/jquery-3.6.0.js"></script>
        <script src="../assets/js/bootstrap.bundle.js"></script>
        <!--BjavaScrip-->

    </body>
</html>
