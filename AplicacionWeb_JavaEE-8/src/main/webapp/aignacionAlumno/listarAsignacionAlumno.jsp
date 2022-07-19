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

        <title>Listado de asignacion alumno</title>
    </head>
    <body>
        <header id="main-header" class="py-2 bg-light pt-4">
            <div class="container">
                <div class="row">
                    <div class="col-12">
                        <h1 class="text-center">Asignacion alumno</h1>
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
                            <i class="fas fa-cog"> </i> Control asignacion alumno  <i class="fas fa-cog"> </i>
                        </h1>
                    </div>
                </div>
            </div>
        </header>
        
        <section id="acciones" class="py-4 mb-4" >
            <div class="container">
                <div class="row">
                    <div class="col-12 col-md-3">
                        <a class="btn btn-outline-info" data-bs-toggle="modal" data-bs-target="#agregar-asignacionAlumno-modal">
                            <i class="fas fa-plus"></i> Agregar AsignacionAlumno
                        </a>
                    </div>
                </div>
            </div>
        </section>

        <!-- Modal -->
        <div class="modal fade" id="agregar-asignacionAlumno-modal" tabindex="-1" aria-labelledby="exampleModalLabel" aria-hidden="true">
            <div class="modal-dialog">
                <div class="modal-content">
                    <div class="modal-header bg-primary text-white">
                        <h5 class="modal-title bg-primary" id="exampleModalLabel">Agregar</h5>
                        <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
                    </div>
                    <form method="POST" action="${pageContext.request.contextPath}/ServletAsignacionAlumno">
                        <div class="modal-body">
                            <div class="mb-3">
                                <label for="idCurso" class="form-label">idCurso</label>
                                <input type="number" id="idCurso" name="idCurso" class="form-control">
                            </div>
                            <div class="mb-3">
                                <label for="fechaAsignacion" class="form-label">fechaAsignacion</label>
                                <input type="datetime" id="fechaAsignacion" name="fechaAsignacion" class="form-control">
                            </div>
                            <div class="mb-3">
                                <label for="carne" class="form-label" >carne</label>
                                <input type="text" id="carne" name="carne" class="form-control">
                            </div>

                            <input type="hidden" name="accion" value="insertar">


                        </div>
                        <div class="modal-footer">
                            <button type="button" class="btn btn-danger" data-bs-dismiss="modal">Calcelar</button>
                            <button type="submit" class="btn btn-success">Guardar</button>
                            
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
                                <h4> <i class="fas fa-chalkboard-teacher"></i> Listado de asignacion alumno <i class="fas fa-chalkboard-teacher"></i> </h4>
                            </div>
                        </div>

                        <table class="table table-striped "> 
                            <thead class="table-primary">

                                <tr>
                                    <th> <i class="fas fa-book-open"></i> #</th>
                                    <th>Fecha asignacion</th>
                                    <th>carne</th>
                                    <th>id curso</th>
                                    <th></th>
                                    <th></th>
                                </tr>
                            </thead>
                            <tbody>
                                <c:forEach var="asigancionAlumno" items="${listarAsignacionAlumno}">
                                    <tr>
                                        <td> <i class="fas fa-book-reader"></i> ${asigancionAlumno.idAsignacion}</td>
                                        <td>${asigancionAlumno.fechaAsignacion}</td>
                                        <td>${asigancionAlumno.carne}</td>
                                        <td>${asigancionAlumno.idCurso}</td>

                                        <td>
                                            <a class="btn btn-outline-success" href="${pageContext.request.contextPath}/ServletAsignacionAlumno?accion=editar&idAsignacion=${asigancionAlumno.idAsignacion}">
                                                <i class="fas fa-user-edit"></i> Editar
                                            </a>
                                        </td> 

                                        <td>
                                            <a class="btn btn-outline-danger" href="${pageContext.request.contextPath}/ServletAsignacionAlumno?accion=eliminar&idAsignacion=${asignacionAlumno.idAsignacion}">
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

