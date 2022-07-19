<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<fmt:setLocale value="es_GT"/>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <link rel="stylesheet" type="text/css" href="./assets/css/style.css">
        <!-- Bootstrap CSS --> 
        <link rel="stylesheet" href="./assets/css/bootstrap.css">

        <script src="https://kit.fontawesome.com/f90d3bf50d.js"></script>

        <title>Editar de salon</title>
    </head>
    <body>

        <jsp:include page="../WEB-INF/paginas/comunes/cabecera.jsp"/>



        <section id="actions" class="py-4 mb-4 bg-light">
            <div class="container">
                <div class="row">
                    <div class="col-md-3">
                        <a href="${pageContext.request.contextPath}/ServletAsignacionAlumno?accion=listar" class="btn btn-light   btn-block">
                            <i class="fa fa-arrow-left"></i> Regresar a Asignacion Alumno
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
                    <div class="col-md-12">
                        <div class="card">
                            <div class="card-header">
                                <h4>Editar salon</h4>
                            </div>  
                            <div class="card-body">
                                <form method="POST" action="${pageContext.request.contextPath}/ServletAsignacionAlumno">
                                    <div class="modal-body">
                                        <div class="mb-3">
                                            <label for="fechaAsignacion" class="form-label">FechaAsignacion</label>
                                            <input type="datetime" id="fechaAsignacion" name="fechaAsignacion" class="form-control" value="${asignacionAlumno.fechaAsignacion}">
                                        </div>
                                        <div class="mb-3">
                                            <label for="carne" class="form-label" >Carne</label>
                                            <input type="text" id="carne" name="carne" class="form-control" value="${asignacionAlumno.carne}">
                                        </div>
                                        <div class="mb-3">
                                            <label for="idCurso" class="form-label" >Id curso</label>
                                            <input type="text" id="idCurso" name="idCurso" class="form-control" value="${asignacionAlumno.idCurso}">
                                        </div>
                                        
                                        <input type="hidden" name="idAsignacion" value="${asignacionAlumno.idAsignacion}">
                                        <input type="hidden" name="accion" value="actualizar">



                                    </div>
                                    <div class="modal-footer">
                                        <button type="button" class="btn btn-danger" data-bs-dismiss="modal">Calcelar</button>
                                        <button type="submit" class="btn btn-success">Guardar</button>
                                    </div>
                                </form>
                            </div> 
                        </div>  
                    </div>  
                </div>
            </div>
        </main>



        <jsp:include page="../WEB-INF/paginas/comunes/pie-pagina.jsp"/>

        <script src="./assets/js/jquery-3.6.0.js"></script>
        <script src="./assets/js/bootstrap.bundle.js"></script>
    </body>
</html>  
