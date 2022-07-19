/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.proyectoGrupo.controller;

import com.proyectoGrupo.models.dao.CursoDaoImpl;
import com.proyectoGrupo.models.domain.Curso;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author A-R
 */
@WebServlet("/ServletCurso")
public class ServletCurso extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        String accion = request.getParameter("accion");
        if (accion != null) {
            switch (accion) {
                case "listar":
                    listarCurso(request, response);
                    break;
                case "eliminar":
                    eliminarCurso(request, response);
                    break;
                case "editar":
                    editarCurso(request, response);
                    break;
            }
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        request.setCharacterEncoding("UTF-8");
        System.out.println("\ndoPost");
        String accion = request.getParameter("accion");

        if (accion != null) {
            switch (accion) {
                case "insertar":
                    insertarCurso(request, response);
                    break;
                case "actualizar":
                    actualizarCurso(request, response);
                    break;
            }
        }

    }

    private void listarCurso(HttpServletRequest request, HttpServletResponse response) throws IOException {
        List<Curso> listaCurso = new CursoDaoImpl().listar();

        HttpSession sesion = request.getSession();
        sesion.setAttribute("listadoCurso", listaCurso);
        response.sendRedirect("Curso/Curso.jsp");
    }

    private void eliminarCurso(HttpServletRequest resquest, HttpServletResponse response) throws IOException {
        int idCurso = Integer.parseInt(resquest.getParameter("idcurso"));
        Curso cursos = new Curso(idCurso);

        int registroEliminados = new CursoDaoImpl().eliminar(cursos);
        System.out.println("Cantidad de registros eliminados" + registroEliminados);
        listarCurso(resquest, response);
    }

    private void insertarCurso(HttpServletRequest request, HttpServletResponse response) throws IOException {
        System.out.println("\nInsertarCurso");

        int ciclo = Integer.parseInt(request.getParameter("ciclo"));
        int cupoMaximo = Integer.parseInt(request.getParameter("cupo_maximo"));
        int cupoMinimo = Integer.parseInt(request.getParameter("cupo_minimo"));
        String descripcion = request.getParameter("descipcion");
        String codigoCarreera = request.getParameter("codigo_carrera");
        int idHorario = Integer.parseInt(request.getParameter("horario_id"));
        int idInstructor = Integer.parseInt(request.getParameter("instructor_id"));
        int idSalon = Integer.parseInt(request.getParameter("salon_id"));

        Curso cursos = new Curso(ciclo, cupoMaximo, cupoMinimo, descripcion, codigoCarreera, idHorario, idInstructor, idSalon);
        System.out.println(cursos);
        int registrosIngresados = new CursoDaoImpl().insertar(cursos);
        System.out.println("registors insertados" + registrosIngresados);
        listarCurso(request, response);
    }

    private void editarCurso(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int idCurso = Integer.parseInt(request.getParameter("idCurso"));

        Curso curso = new CursoDaoImpl().encontrar(new Curso(idCurso));
        System.out.println(curso);

        request.setAttribute("curso", curso);

        request.getRequestDispatcher("Curso/editar-curso.jsp").forward(request, response);

    }

    private void actualizarCurso(HttpServletRequest request, HttpServletResponse respone) throws IOException {

        int idCurso = Integer.parseInt(request.getParameter("idCurso"));

        int ciclo = Integer.parseInt(request.getParameter("ciclo"));
        int cupoMaximo = Integer.parseInt(request.getParameter("cupo_maximo"));
        int cupoMinimo = Integer.parseInt(request.getParameter("cupo_minimo"));
        String descripcion = request.getParameter("descipcion");
        String codigoCarreera = request.getParameter("codigo_carrera");
        int idHorario = Integer.parseInt(request.getParameter("horario_id"));
        int idInstructor = Integer.parseInt(request.getParameter("instructor_id"));
        int idSalon = Integer.parseInt(request.getParameter("salon_id"));

        Curso curso = new Curso(idCurso, ciclo, cupoMaximo, cupoMinimo, descripcion, codigoCarreera, idHorario, idInstructor, idSalon);
        System.out.println(curso);
        int registrosActualizados = new CursoDaoImpl().actualuzar(curso);
        System.out.println("registros Actualizados" + registrosActualizados);
        listarCurso(request, respone);

    }

}
