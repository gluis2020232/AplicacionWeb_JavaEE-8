<%-- 
    Document   : editar-alumno
    Created on : 17-sep-2021, 8:15:35
    Author     : Hugo Daniel Velasquez Patzan
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<fmt:setLocale value="es-GT"/>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1">


        <!-- BootsTrap CSS -->

        <link rel="stylesheet" href="./assets/css/bootstrap.css">
        <link rel="stylesheet" href="./assets/css/style.css">

        <script src="https://kit.fontawesome.com/f90d3bf50d.js"></script>


        <title>Editar Alumno</title>
    </head>

    <body>

        <section id ="actions" class="py-4 mb-4 bg-light">
            <div class="container">
                <div class="row">
                    <div class="col-md-3">
                        <a href="listarAlumno.jsp" class="btn btn-light btn-block">
                            <i class="fa fa-arrow-left"></i>
                            Regresar a Listado Alumno
                        </a>
                    </div>                    
                    <div class="col-md-3">

                    </div>

                    <div class="col-md-3">

                    </div>

                </div>
            </div>
        </section>

        <section>
            <div class="container">
                <div class="row">
                    <div class="col-12">
                        <div class="card">
                            <div class="card-header">
                                <h4>Editar Alumno</h4>
                            </div>
                            <div class="card-body">
                                <form method="POST" action="${pageContext.request.contextPath}/ServletAlumno">

                                    <div class="mb-3">
                                        <label for="carne" class="form-label">Carne</label>
                                        <input type="text" id="carne" name="carne" class="form-control" value="${alumno.carne}">
                                    </div>

                                    <div class="mb-3">
                                        <label for="apellidos" class="form-label">Apellido</label>
                                        <input type="text" id="apellidos" name="apellidos" class="form-control" value="${alumno.apellidos}">
                                    </div>

                                    <div class="mb-3">
                                        <label for="nombres" class="form-label">Nombre</label>
                                        <input type="text" id="nombres" name="nombres" class="form-control" value="${alumno.nombres}">
                                    </div>                                    

                                    <div class="mb-3">
                                        <label for="email" class="form-label">Email</label>
                                        <input type="email" id="email" name="email" class="form-control" value="${alumno.email}">
                                    </div>

                                    <input type="hidden" name="idEstudiante" value="${alumno.carne}">

                                    <input type="hidden" name="accion" value="actualizar">

                                    <button type="button" class="btn btn-secondary" data-bs-dismiss="modal">Cancelar</button>
                                    <button type="submit" class="btn btn-success">Guardar</button>
                                </form>
                            </div>
                        </div>
                    </div>                    
                </div>
            </div>
        </section> 

    </body>
</html>