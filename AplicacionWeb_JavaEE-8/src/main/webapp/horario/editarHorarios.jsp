<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<fmt:setLocale value="es_GT"/>

<!DOCTYPE html>
<html>
    <head>

        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

        <link rel="stylesheet" href="./assets/css/style.css">

        <meta name="viewport" content="width=device-width, initial-scale=1">

        <!--Bostsrap-->
        <link rel="stylesheet" href="./assets/css/bootstrap.css">
        <!--Bostsrap-->

        <!--Iconos-->
        <script src="https://kit.fontawesome.com/f90d3bf50d.js"></script>
        <!--Iconos-->

        <title>Editar Horarios</title>
    </head>
    
    <body>

        <!--Cabecera (header y nav) -->
        <jsp:include page="/WEB-INF/paginas/comunes/cabecera.jsp"/>
        <!--Cabecera (header y nav) -->

        <header class="controlEstudiante" id="main-header" class="py-2 <!--bg-primary text-white--> text-center">
            <div class="container">
                <div class="row">
                    <div class="col-12">
                        <h1>
                            <i class="fas fa-cog"></i> Editar Horarios
                        </h1>
                    </div>
                </div>
            </div>
        </header> 

        <section id="actions" class="by-4 mb-4 bg-light">
            <div class="container">
                <div class="row">
                    <div class="col-md-3"><!--Especificar la cantidad de columnas-->
                        <a href="listarHorario.jsp" class="btn btn-light btn-block">
                            <i class="fa fa-arrow-left"></i>Regresar Horarios
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
                                <h4>Editar Horarios</h4>
                            </div>
                            <div class="card-body">

                                <!--Aplicando el modal -->
                                <!-- Modal Agregar horario-->
                                <form method="POST" action="${pageContext.request.contextPath}/ServletHorario">
                                    
                                    <div class="<!--input-group--> mb-3">
                                        <label for="horario_final">Horario Final</label>
                                        <input type="text" id="horario_final" name="horario_final" class="form-control" value="${AtrHorario.horario_final}">
                                    </div>

                                    <div class="mb-3">
                                        <label for="horario_inicio" class="form-label">Horario Inicio</label>
                                        <input type="text" id="horario_inicio" name="horario_inicio" class="form-control" value="${AtrHorario.horario_inicio}">
                                    </div>   
                                    
                                    <input type="hidden" name="idHorario" value="${AtrHorario.idHorario}">

                                    <input type="hidden" name="accion" value="actualizar">

                                    <button type="button" class="btn btn-secondary" data-bs-dismiss="modal">Cancelar</button>
                                    <button type="submit" class="btn btn-success">Guardar</button>
                                </form>
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
