/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.proyectoGrupo.controller;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.annotation.WebServlet;
import javax.servlet.ServletException;
import java.util.List;
import com.proyectoGrupo.models.dao.AlumnoDaoImpl;
import com.proyectoGrupo.models.dao.HorarioDaoImpl;
import com.proyectoGrupo.models.domain.Alumno;
import com.proyectoGrupo.models.domain.Horario;
import java.io.IOException;

import com.proyectoGrupo.models.idao.IHorarioDao;
import java.sql.Time;

/**
 *
 * @author Hugo Daniel Velasquez Patzan Codigo Tecnico IN5BV
 * @date 03-sep-2021
 * @time 21:10:01
 */
@WebServlet("/ServletHorario")
public class ServletHorario extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        request.setCharacterEncoding("UTF-8");

        System.out.println("\ndoPost");

        String accion = request.getParameter("accion");

        if (accion != null) {
            switch (accion) {
                case "insertar":
                    insertarHorario(request, response);
                    break;
                case "actualizar":
                    actualizarHorario(request, response);
                    break;
            }
        }
    }
    
    
    private void actualizarHorario(HttpServletRequest request, HttpServletResponse response) throws IOException {
       
        //Recuperar los valores del formulario agregar horario
        int idHorario = Integer.parseInt(request.getParameter("idHorario"));
        
        Horario horario = new Horario();
        
        horario.setHorario_final(Time.valueOf(request.getParameter("horario_final")));
        horario.setHorario_inicio(Time.valueOf(request.getParameter("horario_inicio")));
        System.out.println("Horario: " + horario);
        

        //Crear el obejeto estudiante utilizando bean
        Horario estudiante = new Horario(idHorario);
        System.out.println(estudiante); 
        
        //Insertar el nuevo objeto a la base de datos
        int registrosActualizados = new HorarioDaoImpl().actualizar(estudiante);

        System.out.println("Registros insertados: " + registrosActualizados);
        
        //Redirigimos hacia listar estudiantes...
        listarHorario(request, response);

    }

    private void insertarHorario(HttpServletRequest request, HttpServletResponse response) throws IOException {
        System.out.println("insertarHorario");

        Horario horario = new Horario();

        horario.setHorario_final(Time.valueOf(request.getParameter("horario_final")));
        horario.setHorario_inicio(Time.valueOf(request.getParameter("horario_inicio")));
        System.out.println("Horario: " + horario);
/*      
        if ((request.getParameter("horario_final") != null) && (!request.getParameter("horario_final").equals(""))) {
            horario.setHorario_final(Time.valueOf(request.getParameter("horario_final")));
        }*/

        //Insertar el nuevo objeto a la base de datos
        int registrosIngresados = new HorarioDaoImpl().insertar(horario);

        System.out.println("Registros insertados: " + registrosIngresados);

        //Redirigimos hacia listar horarios
        listarHorario(request, response);
        
    }

   
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {

        String accion = request.getParameter("accion");

        if (accion != null) {
            switch (accion) {
                case "listar":
                    listarHorario(request, response);
                    break;
                case "editar":
                    editarHorario(request, response);
                    break;
                case "eliminar":
                    eliminarHorario(request, response);
                    break;
            }
        }
    }
    
    
    private void editarHorario(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        
        //Recuperar el id de Horarios
        int idHorario = Integer.parseInt(request.getParameter("idHorario"));
        
        //Crear el objeto de tipo horario
        Horario horario = new HorarioDaoImpl().encontrar(new Horario(idHorario));
   //     Estudiante estudiante = new EstudianteDaoImpl().encontrar(new Estudiante(idEstudiante));
    
        System.out.println(horario);
        
        //Enviamos la informacion al jsp que me cargue en un formulario
        request.setAttribute("AtrHorario", horario);
        
        //Redireccionar hacia un jsp
        request.getRequestDispatcher("horario/editarHorarios.jsp").forward(request, response);
        
    }
    

    private void eliminarHorario(HttpServletRequest request, HttpServletResponse response) throws IOException {
        int idHorario = Integer.parseInt(request.getParameter("idHorario"));
        Horario horario = new Horario(idHorario);
        int registrosEliminados = new HorarioDaoImpl().eliminar(horario);

        System.out.println();
        listarHorario(request, response);

    }

    private void listarHorario(HttpServletRequest request, HttpServletResponse response) throws IOException {
        List<Horario> listaHorario = new HorarioDaoImpl().listar();

        HttpSession sesion = request.getSession();
        sesion.setAttribute("listadoHorario", listaHorario);

        response.sendRedirect("horario/listarHorario.jsp");

    }
}
