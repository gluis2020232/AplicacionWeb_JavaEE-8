<%-- 
    Document   : listarInstructor
    Created on : 01-sep-2021, 16:44:30
    Author     : Hugo Daniel Velasquez Patzan
--%>


<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <!--<link rel="stylesheet" type="text/css" href="../assets/css/style.css">
         Bootstrap CSS --> 
        <link rel="stylesheet" href="../assets/css/bootstrap.css">
        <script src="https://kit.fontawesome.com/f90d3bf50d.js"></script>

        <title>Listado de instructor</title>
    </head>
    <body>


        <header id="main-header" class="py-2 bg-light pt-4">
            <div class="container">
                <div class="row">
                    <div class="col-12">
                        <h1 class="text-center">Instructor</h1>
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
                            <i class="fas fa-cog"> </i> Control instructor  <i class="fas fa-cog"> </i>
                        </h1>
                    </div>
                </div>
            </div>
        </header>
        <section id="acciones" class="py-4 mb-4">
            <div class="container">
                <div class="row">
                    <div class="col-12 col-md-3">
                        <button type="button" class="btn btn-outline-info" data-bs-toggle="modal" data-bs-target="#exampleModal">
                            <i class="fas fa-plus"></i> Agregar instructor
                        </button>
                    </div>


                </div>
            </div>
        </section>


        <!-- Modal -->
        <div class="modal fade" id="exampleModal" tabindex="-1" aria-labelledby="exampleModalLabel" aria-hidden="true">
            <div class="modal-dialog">
                <div class="modal-content">
                    <div class="modal-header">
                        <h5 class="modal-title" id="exampleModalLabel">Agregar instructor</h5>
                        <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
                    </div>
                    <form method="POST" action="${pageContext.request.contextPath}/ServletInstructor">

                        <div class="modal-body">
                            <div class="mb-3">
                                <label for="nombre" class="form-label">Ingrese su nombre</label> 
                                <input type="text" id="nombre" name="nombre" class="form-control"> 
                            </div>
                            <div class="mb-3">
                                <label for="apellido" class="form-label">Apellido</label> 
                                <input type="text" id="apellido" name="apellido" class="form-control"> 
                            </div>
                            <div class="mb-3">
                                <label for="direccion" class="form-label">Direccion</label>
                                <input type="text" id="direccion"  name="direccion" class="form-control">

                            </div>
                            <div class="mb-3">
                                <label for="telefono" class="form-label">Telefono</label>
                                <input type="tel" id="telefono" name="telefono" class="form-control">
                            </div>

                            <input type="hidden" name="accion" value="insertar">
                        </div>
                        <div class="modal-footer">
                            <button type="button" class="btn btn-secondary" data-bs-dismiss="modal">Cancelar</button>
                            <button type="submit" class="btn btn-primary">Guardar</button>


                        </div>
                    </form>
                </div>
            </div>
        </div>

        <section id="estudiantes" class="mb-5 mt-5">
            <div class="container">
                <div class="row">
                    <div class="col-xs-12 col-md-12">


                        <div class="card">
                            <div class="card-header">
                                <h4> <i class="fas fa-chalkboard-teacher"></i> Listado de instructor <i class="fas fa-chalkboard-teacher"></i> </h4>
                            </div>
                        </div>

                        <table class="table table-striped "> 
                            <thead class="table-primary">

                                <tr>
                                    <th>#</th>
                                    <th>Nombre completo</th>
                                    <th>Direccion</th>
                                    <th>Telefono</th>         
                                    <th></th>
                                    <th></th>
                                </tr>
                            </thead>
                            <tbody>
                                <c:forEach var="instructor" items="${listaInstructor}">
                                    <tr>
                                        <td> <i class="fas fa-chalkboard-teacher"></i>  ${instructor.idInstructor}</td>
                                        <td>${instructor.nombres} ${instructor.apellidos}</td>
                                        <td>${instructor.direccion}</td>
                                        <td>${instructor.telefono}</td>
                                        <td>
                                            <a class="btn btn-outline-success" href="${pageContext.request.contextPath}/ServletInstructor?accion=editar&idInstructor=${instructor.idInstructor}">
                                                <i class="fas fa-user-edit"></i> Editar
                                            </a>
                                        </td> 
                                        <td>
                                            <a class="btn btn-outline-danger" href="${pageContext.request.contextPath}/ServletInstructor?accion=eliminar&idInstructor=${instructor.idInstructor}">
                                                <i class="fas fa-trash-alt"></i> Eliminar
                                            </a>
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

    <!--Pie de pagina (footer) -->

    <!--javaScrip-->
    <script src="../assets/js/jquery-3.6.0.js"></script>
    <script src="../assets/js/bootstrap.bundle.js"></script>

</body>
</html>

