<%-- 
    Document   : editar-instructor
    Created on : 16-sep-2021, 21:10:41
    Author     : Hugo Daniel Velasquez Patzan
--%>

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

        <title>Editar instructor</title>
    </head>
    <body>

        <jsp:include page="../WEB-INF/paginas/comunes/cabecera.jsp"/>



        <section id="actions" class="py-4 mb-4 bg-light">
            <div class="container">
                <div class="row">
                    <div class="col-md-3">
                        <a href="${pageContext.request.contextPath}/ServletInstructor?accion=listar" class="btn btn-light   btn-block">
                            <i class="fa fa-arrow-left"></i> Regresar a instructor
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
                                <h4>Editar instructor</h4>
                            </div>  
                            <div class="card-body">
                                <form method="POST" action="${pageContext.request.contextPath}/ServletInstructor">
                                    <div class="modal-body">
                                        <div class="mb-3">
                                            <label for="nombres" class="form-label">Nombre:</label>
                                            <input type="text" id="nombres" name="nombres" class="form-control" value="${instructor.nombres}">
                                        </div>
                                        <div class="mb-3">
                                            <label for="apellidos" class="form-label" >Apellido:</label>
                                            <input type="text" id="apellidos" name="apellidos" class="form-control" value="${instructor.apellidos}">
                                        </div>
                                        <div class="mb-3">
                                            <label for="direccion" class="form-label" >Direccion:</label>
                                            <input type="text" id="direccion" name="direccion" class="form-control" value="${instructor.direccion}">
                                        </div>
                                        <div class="mb-3"> 
                                        <label for="telefono" class="form-label" >Telefono:</label>
                                            <input type="number" id="telefono" name="telefono" class="form-control" value="${instructor.telefono}">
                                        </div>
                                        <input type="hidden" name="idInstructor" value="${instructor.idInstructor}">
                                        <input type="hidden" name="accion" value="actualizar">



                                    </div>
                                    <div class="modal-footer">
                                        <button type="button" class="btn btn-danger" data-bs-dismiss="modal">Cancelar</button>
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

