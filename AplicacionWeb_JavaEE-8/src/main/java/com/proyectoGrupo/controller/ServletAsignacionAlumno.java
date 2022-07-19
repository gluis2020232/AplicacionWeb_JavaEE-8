/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.proyectoGrupo.controller;

import com.proyectoGrupo.models.dao.InstructorDaoImpl;
import com.proyectoGrupo.models.dao.AsignacionAlumnoDaoImpl;
import com.proyectoGrupo.models.dao.SalonDaoImpl;
import com.proyectoGrupo.models.domain.AsignacionAlumno;
import com.proyectoGrupo.models.domain.Instructor;
import com.proyectoGrupo.models.domain.AsignacionAlumno;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Timestamp;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author jefer
 */
@WebServlet("/ServletAsignacionAlumno")
public class ServletAsignacionAlumno extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {

        request.setCharacterEncoding("UTF-8");
        System.out.println("\ndoPost");
        String accion = request.getParameter("accion");
        System.out.println("accion: " + accion);

        if (accion != null) {

            switch (accion) {

                case "insertar":
                    insertarAsignacionAlumno(request, response);
                    break;
                case "actualizar":
                    actualizarAsignacionAlumno(request, response);
                    break;
            }

        }

    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        String accion = request.getParameter("accion");

        if (accion != null) {
            switch (accion) {
                case "listar":
                    listarAsignacionAlumno(request, response);
                    break;
                case "eliminar":
                    eliminarAsignacionAlumno(request, response);
                    break;
                case "editar":
                    editarAsignacionAlumno(request, response);
                    break;

            }
        }

    }

     private void listarAsignacionAlumno(HttpServletRequest request, HttpServletResponse response) throws IOException{
        List<AsignacionAlumno> listaAsignacion = new AsignacionAlumnoDaoImpl().listar();
        
        
        HttpSession session = request.getSession();
        session.setAttribute("listarAsignacionAlumno", listaAsignacion);
        response.sendRedirect("aignacionAlumno/listarAsignacionAlumno.jsp");
    }

    private void eliminarAsignacionAlumno(HttpServletRequest request, HttpServletResponse response) throws IOException {
    //    int idAsignacion = Integer.parseInt(request.getParameter("asignacion_id"));
        String idAsignacion = request.getParameter("asignacion_id");

        AsignacionAlumno asignacionalumno = new AsignacionAlumno(idAsignacion);
        int registrosEliminados = new AsignacionAlumnoDaoImpl().eliminar(asignacionalumno);
        listarAsignacionAlumno(request, response);
    }

    private void editarAsignacionAlumno(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
     //   int idAsignacion = Integer.parseInt(request.getParameter("idAsignacion"));
        String idAsignacion = request.getParameter("idAsignacion");

        AsignacionAlumno asignacion = new AsignacionAlumnoDaoImpl().encontrar(new AsignacionAlumno(idAsignacion));

        System.out.println(asignacion);

        request.setAttribute("asignacionAlumno", asignacion);
        request.getRequestDispatcher("aignacionAlumno/editar-asignacion-alumno.jsp").forward(request, response);
    }

    private void actualizarAsignacionAlumno(HttpServletRequest request, HttpServletResponse response) throws IOException {
        
    //    int idAsignacionAlumno = Integer.parseInt(request.getParameter("idAsignacion"));
        String idAsignacionAlumno = request.getParameter("idAsignacion");
        
        Timestamp fechaAsignacion = Timestamp.valueOf(request.getParameter("fechaAsignacion"));
        String carne = request.getParameter("carne");
        int idCurso = Integer.parseInt(request.getParameter("idCurso"));

        AsignacionAlumno asignacionAlumno = new AsignacionAlumno(idAsignacionAlumno, fechaAsignacion, carne, idCurso);
        System.out.println(asignacionAlumno);
        int registrosActualizados = new AsignacionAlumnoDaoImpl().actualizar(asignacionAlumno);
        listarAsignacionAlumno(request, response);
    }


    private void insertarAsignacionAlumno(HttpServletRequest request, HttpServletResponse response) throws IOException {
        Timestamp fechaAsignacion = Timestamp.valueOf(request.getParameter("fechaAsignacion"));
        String carne = request.getParameter("carne");
        int idCurso = Integer.parseInt(request.getParameter("idCurso"));
        
        AsignacionAlumno asignacionAlumno = new AsignacionAlumno(fechaAsignacion, carne, idCurso);
        System.out.println(asignacionAlumno);

        int registrosIngresados = new AsignacionAlumnoDaoImpl().insertar(asignacionAlumno);
        System.out.println("registros ingresados:" + registrosIngresados);
        listarAsignacionAlumno(request, response);

    }

}