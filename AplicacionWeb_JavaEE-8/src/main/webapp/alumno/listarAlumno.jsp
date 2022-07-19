<%-- 
    Document   : listarAlumno
    Created on : 2/09/2021, 01:19:34 AM
    Author     : IVAN PC
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
        <!-- boostrap CSS -->
        <link rel="stylesheet" href="../assets/css/bootstrap.css">
        <script src="https://kit.fontawesome.com/f90d3bf50d.js"></script>

        <title>Listado de Alumnos</title>
    </head>
    <body>
        <header id="main-header" class="py-2 bg-light pt-4">
            <div class="container">
                <div class="row">
                    <div class="col-12">
                        <h1 class="text-center">Control Alumno</h1>
                    </div>
                </div>
            </div>
        </header>

        <jsp:include page="../WEB-INF/paginas/comunes/cabecera.jsp"/>

        <header id="main-header" class="py-2 bg-light pt-4">
            <div class="container">
                <div class="row">
                    <div class="col-12">
                        <h1>
                            <i class="fas fa-cog"> </i> Control Alumno <i class="fas fa-cog"> </i>
                        </h1>
                    </div>
                </div>
            </div>
        </header>

        <section id="acciones" class="py-4 mb-4">
            <div class="container">
                <div class="row">
                    <div class="col-12 col-md-3">
                        <a data-bs-toggle="modal" data-bs-target="#agregar-alumno-modal" class="btn btn-primary btn-block">
                            <i class="fas fa-plus"></i> Agregar Alumno  
                        </a>
                    </div>
                </div>
            </div>
        </section>
        
        
        <!-- Modal -->
        <div class="modal fade" id="agregar-alumno-modal" tabindex="-1" aria-labelledby="exampleModalLabel" aria-hidden="true">
            <div class="modal-dialog">
                <div class="modal-content">
                    <div class="modal-header bg-primary text-danger">
                        <h5 class="modal-title" id="exampleModalLabel">Agregar Alumno</h5>
                        <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
                    </div>
                    <form method="POST" action="${pageContext.request.contextPath}/ServletAlumno">

                        <div class="modal-body">

                            <div class="mb-3">
                                <label for="carne" class="form-label">Carne</label>
                                <input type="carne" id="carne" name="carne" class="form-control">
                            </div>

                            <div class="mb-3">
                                <label for="apellido" class="form-label">Apellido</label>
                                <input type="text" id="apellido" name="apellido" class="form-control">
                            </div>


                            <div class="mb-3">
                                <label for="nombre">Nombre</label>
                                <input type="text" id="nombre" name="nombre" class="form-control">
                            </div>                            



                            <div class="mb-3">
                                <label for="email" class="form-label">Email</label>
                                <input type="email" id="email" name="email" class="form-control">
                            </div>



                            <input type="hidden" name="accion" value="insertar">


                        </div>
                        <div class="modal-footer">
                            <button type="button" class="btn btn-secondary" data-bs-dismiss="modal">Cancelar</button>
                            <button type="submit" class="btn btn-success">Guardar</button>
                        </div>
                    </form>
                </div>
            </div>
        </div>

        <section id="alumno" class="mb-5 mt-5">
            <div class="container">
                <div class="row">
                    <div class="col-xs-12 col-md-12">


                        <div class="card">
                            <div class="card-header">
                                <h4><i class="fas fa-user-graduate"></i> Listado de Alumnos <i class="fas fa-user-graduate"></i></h4>
                            </div>
                        </div>

                        <table class="table table-striped  ">
                            <thead class="table-primary">
                                <tr>
                                    <th><i class="fas fa-book-open"></i> #</th>
                                    <th>Nombre Completo</th>
                                    <th><i class="fas fa-at"></i> Email</th>
                                    <th></th>
                                    <th></th>
                                </tr>
                            </thead>
                            <tbody>
                                <c:forEach var="alumno" items="${listadoAlumno}">
                                    <tr>                          
                                        <td><i class="fas fa-user-alt"></i> ${alumno.carne}</td>
                                        <td>${alumno.apellidos} ${alumno.nombres}</td>
                                        <td>${alumno.email}</td>

                                        <td>
                                            <a class="btn btn-outline-success" href="${pageContext.request.contextPath}/ServletAlumno?accion=editar&carne=${alumno.carne}">
                                                <i class="fas fa-user-edit"></i> Editar
                                            </a>
                                        </td> 

                                        <td>                        
                                            <a class="btn btn-outline-danger" href="${pageContext.request.contextPath}/ServletAlumno?accion=eliminar&carne=${alumno.carne}">
                                                <i class="fas fa-trash-alt"></i>Eliminar</a>
                                        </td> 

                                    </tr>
                                </c:forEach>
                            </tbody>
                        </table>    
                    </div>


                </div>
            </div>
        </div>
    </section>


    <script src="../assets/js/jquery-3.6.0.js"></script> 
    <script src="../assets/js/bootstrap.bundle.js"></script>
</body>
</html>