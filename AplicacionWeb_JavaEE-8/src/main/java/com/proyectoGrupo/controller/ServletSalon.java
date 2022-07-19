package com.proyectoGrupo.controller;

import com.proyectoGrupo.db.Conexion;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.annotation.WebServlet;
import javax.servlet.ServletException;
import java.util.List;
import com.proyectoGrupo.models.dao.SalonDaoImpl;
import com.proyectoGrupo.models.domain.Salon;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * --add-modules javafx.controls,javafx.fxml
 *
 * @author Denil José Parada Cabrera
 * @date 25/08/2021
 * @time 11:40:37 PM
 * @codigoTecnico: IN5BV
 */
@WebServlet("/ServletSalon")
public class ServletSalon extends HttpServlet {
    
    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {

        request.setCharacterEncoding("UTF-8");
        System.out.println("\ndoPost");
        String accion = request.getParameter("accion");
        System.out.println("accion: " + accion);

        if (accion != null) {

            switch (accion) {

                case "insertar":
                    insertarSalones(request, response);
                    break;
                case "actualizar":
                    actualizarSalones(request, response);
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
                    listarSalones(request, response);
                    break;
                case "editar":
                    editarSalones(request, response);
                    break;
                case "eliminar":
                    EliminarSalones(request, response);
                    break;
            }

        }
    }

    private void listarSalones(HttpServletRequest request, HttpServletResponse response) throws IOException {
        List<Salon> listaSalon = new SalonDaoImpl().listar();

        HttpSession sesion = request.getSession();
        sesion.setAttribute("listadoSalones", listaSalon);
        response.sendRedirect("salon/listar-salon.jsp");

    }
    
    private void EliminarSalones(HttpServletRequest request, HttpServletResponse response) throws IOException {
        int idSalon = Integer.parseInt(request.getParameter("idSalon"));

        Salon salon = new Salon(idSalon);

        int registrosEliminados = new SalonDaoImpl().eliminar(salon);
        System.out.println("cantidad de registros eliminados: " + registrosEliminados);
        listarSalones(request, response);

    }
    
    private void editarSalones(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        int idSalon = Integer.parseInt(request.getParameter("idSalon"));

        Salon salon = new SalonDaoImpl().encontrar(new Salon(idSalon));

        System.out.println(salon);

        request.setAttribute("salon", salon);
        request.getRequestDispatcher("salon/editar-salon.jsp").forward(request, response);
    }
    
    private void actualizarSalones(HttpServletRequest request, HttpServletResponse response) throws IOException{
        
        int idSalon = Integer.parseInt(request.getParameter("idSalon"));
        int capacidad = Integer.parseInt(request.getParameter("capacidad"));
        String descripcion = request.getParameter("descripcion");
        String nombre_salon = request.getParameter("nombre_salon");

        Salon salon = new Salon(idSalon, capacidad, descripcion, nombre_salon);
        System.out.println(salon);
        int registrosActualizados = new SalonDaoImpl().actualizar(salon);
        listarSalones(request, response);
    }
    

    private void insertarSalones(HttpServletRequest request, HttpServletResponse response) throws IOException {
        
        int capacidad = Integer.parseInt(request.getParameter("capacidad"));
        String descripcion = request.getParameter("descripcion");
        String nombre_salon = request.getParameter("nombre_salon");

        Salon salon = new Salon(capacidad, descripcion, nombre_salon);
        System.out.println(salon);

        //insertar 
        int registrosIngresados = new SalonDaoImpl().insertar(salon);
        System.out.println("registros ingresados:" + registrosIngresados);
        listarSalones(request, response);
        
    }

    

}