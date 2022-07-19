/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.proyectoGrupo.models.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import com.proyectoGrupo.models.domain.Instructor;
import java.sql.SQLException;
import com.proyectoGrupo.models.idao.IInstrucorDao;
import com.proyectoGrupo.db.Conexion;

/**
 *
 * @author Hugo Daniel Velasquez Patzan Codigo Tecnico IN5BV
 * @date 01-sep-2021
 * @time 12:35:38
 */
public class InstructorDaoImpl implements IInstrucorDao {

    private static final String SQL_SELECT = "SELECT instructor_id, apellidos, nombres, direccion, telefono FROM instructor;";
    private static final String SQL_DELETE = "DELETE FROM instructor WHERE instructor_id = ?";
    private static final String SQL_INSERT = "INSERT INTO instructor(apellidos, nombres, direccion, telefono) VALUES(?, ?, ?, ?)";
    private static final String SQL_UPDATE = "UPDATE instructor SET apellidos = ?, nombres = ?, direccion = ?, telefono = ? WHERE instructor_id = ?";
    private static final String SQL_SELECT_BY_ID = "SELECT instructor_id, apellidos, nombres, direccion, telefono FROM instructor WHERE instructor_id = ?;";
    Connection conn = null;
    PreparedStatement pstmt = null;
    ResultSet rs = null;
    Instructor instructor = null;
    List<Instructor> listaInstructor = new ArrayList<>();

    @Override
    public List<Instructor> listar() {

        try {
            conn = Conexion.getConnection();
            pstmt = conn.prepareStatement(SQL_SELECT);
            rs = pstmt.executeQuery();

            while (rs.next()) {
                int idInstructor = rs.getInt("instructor_id");
                String apellidos = rs.getString("apellidos");
                String nombres = rs.getString("nombres");
                String direccion = rs.getString("direccion");
                String telefono = rs.getString("telefono");

                instructor = new Instructor(idInstructor, apellidos, nombres, direccion, telefono);
                listaInstructor.add(instructor);
            }

        } catch (SQLException e) {

            e.printStackTrace(System.out);
        } catch (Exception e) {
            e.printStackTrace(System.out);
        } finally {
            Conexion.close(rs);
            Conexion.close(pstmt);
            Conexion.close(conn);
        }
        return listaInstructor;
    }

    @Override
    public Instructor encontrar(Instructor instructor) {

        try {
            conn = Conexion.getConnection();
            pstmt = conn.prepareStatement(SQL_SELECT_BY_ID);
            pstmt.setInt(1, instructor.getIdInstructor());
            rs = pstmt.executeQuery();

            while (rs.next()) {
                String apellidos = rs.getString("apellidos");
                String nombres = rs.getString("nombres");
                String direccion = rs.getString("direccion");
                String telefono = rs.getString("telefono");

                instructor.setApellidos(apellidos);
                instructor.setNombres(nombres);
                instructor.setDireccion(direccion);
                instructor.setTelefono(telefono);

            }

        } catch (SQLException e) {
            e.printStackTrace();
        }catch (Exception e) {
            e.printStackTrace(System.out);
        } finally {
            Conexion.close(rs);
            Conexion.close(pstmt);
            Conexion.close(conn);
        }
        return instructor;

    }

    @Override
    public int insertar(Instructor instructor) {
        int rows = 0;

        try {
            conn = Conexion.getConnection();
            pstmt = conn.prepareStatement(SQL_INSERT);
            pstmt.setString(1, instructor.getApellidos());
            pstmt.setString(2, instructor.getNombres());
            pstmt.setString(3, instructor.getDireccion());
            pstmt.setString(4, instructor.getTelefono());

            System.out.println(pstmt.toString());
            rows = pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace(System.out);
        } finally {
            Conexion.close(pstmt);
            Conexion.close(conn);
        }
        return rows;

    }

    @Override
    public int actualizar(Instructor instructor) {
        int rows = 0;

        try {
            conn = Conexion.getConnection();
            pstmt = conn.prepareStatement(SQL_UPDATE);
            pstmt.setString(1, instructor.getApellidos());
            pstmt.setString(2, instructor.getNombres());
            pstmt.setString(3, instructor.getDireccion());
            pstmt.setString(4, instructor.getTelefono());
            pstmt.setInt(5, instructor.getIdInstructor());

            System.out.println(pstmt.toString());
            rows = pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace(System.out);
        } finally {
            Conexion.close(pstmt);
            Conexion.close(conn);
        }
        return rows;
    }

    @Override
    public int eliminar(Instructor instructor) {
        int rows = 0;
        try {
            conn = Conexion.getConnection();
            pstmt = conn.prepareStatement(SQL_DELETE);
            pstmt.setInt(1, instructor.getIdInstructor());
            System.out.println(pstmt.toString());
            rows = pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace(System.out);
        } finally {
            Conexion.close(pstmt);
            Conexion.close(conn);

        }
        return rows;
    }
}
