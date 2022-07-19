/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.proyectoGrupo.controller;

import java.io.IOException;
import java.util.List;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import com.proyectoGrupo.models.domain.Instructor;
import com.proyectoGrupo.models.dao.InstructorDaoImpl;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;

/**
 *
 * @author Hugo Daniel Velasquez Patzan Codigo Tecnico IN5BV
 * @date 01-sep-2021
 * @time 11:40:52
 */
@WebServlet("/ServletInstructor")

public class ServletInstructor extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        String accion = request.getParameter("accion");

        if (accion != null) {
            switch (accion) {
                case "listar":

                    listarInstructor(request, response);
                    break;
                case "editar":
                    editarInstructor(request, response);
                    break;
                case "eliminar":
                    eliminarInstructor(request, response);
                    break;

            }
        }

    }

    private void editarInstructor(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        int idInstructor = Integer.parseInt(request.getParameter("idInstructor"));

        Instructor instructor = new InstructorDaoImpl().encontrar(new Instructor(idInstructor));

        System.out.println(instructor);

        request.setAttribute("instructor", instructor);

        request.getRequestDispatcher("instructor/editar-instructor.jsp").forward(request, response);

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        request.setCharacterEncoding("UTF-8");
        System.out.println("\ndoPost");
        String accion = request.getParameter("accion");

        if (accion != null) {
            switch (accion) {
                case "insertar":
                    insertarInstructor(request, response);
                    break;
                case "actualizar":
                    actualizarInstructor(request, response);
                    break;
            }
        }

    }

    private void insertarInstructor(HttpServletRequest request, HttpServletResponse response) throws IOException {
        System.out.println("\ninsertarInstructor");

        String nombre = request.getParameter("nombre");
        String apellidos = request.getParameter("apellido");
        String direccion = request.getParameter("direccion");
        String telefono = request.getParameter("telefono");

        Instructor instructor = new Instructor(apellidos, nombre, direccion, telefono);
        System.out.println(instructor);

        int registrosIngresados = new InstructorDaoImpl().insertar(instructor);

        listarInstructor(request, response);

    }

    private void listarInstructor(HttpServletRequest request, HttpServletResponse response) throws IOException {
        List<Instructor> listaInstructor = new InstructorDaoImpl().listar();

        HttpSession session = request.getSession();
        session.setAttribute("listaInstructor", listaInstructor);
        response.sendRedirect("instructor/listarInstructor.jsp");
    }

    private void eliminarInstructor(HttpServletRequest request, HttpServletResponse response) throws IOException {
        int idInstructor = Integer.parseInt(request.getParameter("idInstructor"));

        Instructor instructor = new Instructor(idInstructor);
        int registrosEliminados = new InstructorDaoImpl().eliminar(instructor);
        listarInstructor(request, response);
    }

    private void actualizarInstructor(HttpServletRequest request, HttpServletResponse response) throws IOException {
        int idInstructor = Integer.parseInt(request.getParameter("idInstructor"));
        String apellidos = request.getParameter("apellidos");
        String nombre = request.getParameter("nombres");

        String direccion = request.getParameter("direccion");
        String telefono = request.getParameter("telefono");

        Instructor instructor = new Instructor(idInstructor, apellidos, nombre, direccion, telefono);
        System.out.println(instructor);
        int registrosActualizados = new InstructorDaoImpl().actualizar(instructor);
        listarInstructor(request, response);
    }

}
