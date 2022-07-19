<%-- 
    Document   : Curso
    Created on : 3/09/2021, 01:12:55 PM
    Author     : A-R
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

        <title>Listado de curso</title>
    </head>
    <body>
        <header id="main-header" class="py-2 bg-light pt-4">
            <div class="container">
                <div class="row">
                    <div class="col-12">
                        <h1 class="text-center">Curso</h1>
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
                            <i class="fas fa-cog"> </i> Control curso  <i class="fas fa-cog"> </i>
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
                            <i class="fas fa-plus"></i> Agregar curso
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

                    <form method="POST" action="${pageContext.request.contextPath}/ServletCurso">
                        <div class="modal-body bg-dark text-dark">

                            <div class="form-floating mb-3">
                                <input type="number" id="ciclo" name="ciclo" class="form-control" placeholder="Ciclo">
                                <label for="ciclo" class="form-label">Ciclo</label>
                            </div>

                            <div class="form-floating mb-3">
                                <input type="number" id="cupo_maximo" name="cupo_maximo" class="form-control" placeholder="cupoMaximo">
                                <label for="cupo_maximo" class="form-label">Cupo Maximo</label>
                            </div>

                            <div class="form-floating mb-3">
                                <input type="nummber" id="cupo_minimo" name="cupo_minimo" class="form-control" placeholder="Cupo Minimo ">
                                <label for="cupo_minimo" class="form-label">Cupo Minimo </label>
                            </div>

                            <div class="form-floating mb-3">
                                <input type="text" id="descipcion" name="descipcion" class="form-control" placeholder="Descipcion">
                                <label for="descipcion" class="form-label">Descipcion</label>
                            </div>

                            <div class="form-floating mb-3">
                                <input type="text" id="codigo_carrera" name="codigo_carrera" class="form-control" step="any" placeholder="Codigo Carrera">
                                <label for="codigo_carrera" class="form-label">Codigo Carrera</label>
                            </div>

                            <div class="form-floating mb-3">
                                <input type="number" id="horario_id" name="horario_id" class="form-control" placeholder="Horario">
                                <label for="horario_id" class="form-label">Horario</label>
                            </div>

                            <div class="form-floating mb-3">
                                <input type="number" id="instructor_id" name="instructor_id" class="form-control" placeholder="Instructor">
                                <label for="instructor_id" class="form-label">Instructor</label>
                            </div>

                            <div class="form-floating mb-3">
                                <input type="number" id="telefono" name="salon_id" class="form-control" placeholder="Salon">
                                <label for="salon_id" class="form-label">Salon</label>
                            </div>

                            <input type="hidden" name="accion" value="insertar">
                        </div>

                        <div class="modal-footer bg-dark">
                            <button type="button" class="btn btn-danger" data-bs-dismiss="modal">Cancelar</button>
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
                                <h4> <i class="fas fa-chalkboard-teacher"></i> Listado de curso <i class="fas fa-chalkboard-teacher"></i> </h4>
                            </div>
                        </div>

                        <table class="table table-striped "> 
                            <thead class="table-primary">

                                <tr>
                                    <th> <i class="fas fa-book-open"></i> #</th>
                                    <th>Ciclo</th>
                                    <th>Cupo Maximo</th>
                                    <th>Cupo Minimo</th>
                                    <th>Descripcion</th>
                                    <th>Codigo de Carrera</th>
                                    <th>instructor</th>
                                    <th>salon</th>
                                    <th>horario</th>
                                    <th> </th>
                                    <th></th>
                                </tr>
                            </thead>
                            <tbody>
                                <c:forEach var="curso" items="${listadoCurso}">
                                    <tr>
                                        <td>${curso.idCurso}</td>
                                        <td>${curso.ciclo}
                                        <td>${curso.cupoMaximo}</td>
                                        <td>${curso.cupoMinimo}</td>
                                        <td>${curso.descripcion}</td>
                                        <td>${curso.codigoCarrera}</td>
                                        <td>${curso.idInstructor}</td>
                                        <td>${curso.idSalon}</td>
                                        <td>${curso.idHorario}</td>
                                        <td>
                                            <a class="btn btn-outline-success" href="${pageContext.request.contextPath}/ServletCurso?accion=editar&idCurso=${curso.idCurso}">
                                                <i class="fas fa-user-edit"></i> Editar
                                            </a>
                                        </td> 
                                        <td>
                                            <a class="btn btn-outline-danger" href="${pageContext.request.contextPath}/ServletCurso?accion=eliminar&idCurso=${curso.idCurso}">
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

    <script src="../assets/js/jquery-3.6.0.js"></script>
    <script src="../assets/js/bootstrap.bundle.js"></script>
</body>
</html>  






