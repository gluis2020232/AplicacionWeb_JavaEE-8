/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.proyectoGrupo.models.dao;

import com.proyectoGrupo.db.Conexion;
import com.proyectoGrupo.models.domain.Nota;
import com.proyectoGrupo.models.idao.INotaDao;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Genrry Luis
 */
public class NotaDaoImpl implements INotaDao {

    private static final String SQL_SELECT = "SELECT id_nota, nombre_actividad, nota_actividad, fecha_actividad, asignacion_id FROM Nota;";
    private static final String SQL_DELETE = "DELETE FROM Nota where id_nota = ?";
    private static final String SQL_INSERT = "INSERT INTO Nota(nombre_actividad, nota_actividad, fecha_actividad, asignacion_id) VALUES (?, ?, ?, ?)";
    private static final String SQL_SELECT_BY_ID = "SELECT id_nota, nombre_actividad, nota_actividad, fecha_actividad, asignacion_id FROM Nota WHERE id_nota = ?";
    private static final String SQL_UPDATE = "UPDATE Nota SET nombre_actividad = ?, nota_actividad = ?, fecha_actividad = ?, asignacion_id = ? WHERE id_nota = ?";
    
    Connection conn = null;
    PreparedStatement pstmt = null;
    ResultSet rs = null;
    Nota nota = null;

    List<Nota> listaNota = new ArrayList<>();

    @Override
    public List<Nota> listar() {
        try {
            conn = Conexion.getConnection();
            pstmt = conn.prepareStatement(SQL_SELECT);
            rs = pstmt.executeQuery();

            while (rs.next()) {     
                int idNota = rs.getInt("id_nota");
                String nombreActividad = rs.getString("nombre_actividad");
                int notaActividad = rs.getInt("nota_actividad");
                Date fechaActividad = rs.getDate("fecha_actividad");
                String idAsignacion = rs.getString("asignacion_id");

                nota = new Nota(idNota, nombreActividad, notaActividad, fechaActividad, idAsignacion);
                listaNota.add(nota);
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
        return listaNota;
    }

    @Override
    public Nota encontrar(Nota nota) {
        try {
            conn = Conexion.getConnection();
            pstmt = conn.prepareStatement(SQL_SELECT_BY_ID);
        //    pstmt.setString(1, nota.getIdAsignacion());
            pstmt.setInt(1, nota.getIdNota());
            System.out.println(pstmt.toString());

            rs = pstmt.executeQuery();

            while (rs.next()) {
                //Estos campos tienen que coincidir con base de datos
                String nombreActividad = rs.getString("nombre_actividad");
                int notaActividad = rs.getInt("nota_actividad");
                Date fechaActividad = rs.getDate("fecha_actividad");
                String idAsignacion = rs.getString("asignacion_id");

                //carreraTecnica.setCodigoCarrera(codigoCarrera);
                nota.setNombreActividad(nombreActividad);
                nota.setNotaActividad(notaActividad);
                nota.setFechaActividad(fechaActividad);
                nota.setIdAsignacion(idAsignacion);

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
        return nota;
    }

    
    @Override
    public int insertar(Nota nota) {
        int rows = 0;
        try {
            conn = Conexion.getConnection();
            pstmt = conn.prepareStatement(SQL_INSERT);
            
            pstmt.setString(1, nota.getNombreActividad());
            pstmt.setInt(2, nota.getNotaActividad());
            pstmt.setDate(3, nota.getFechaActividad());
            pstmt.setString(4, nota.getIdAsignacion());

            System.out.println(pstmt.toString());

            rows = pstmt.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace(System.out);
        } catch (Exception e) {
            e.printStackTrace(System.out);
        } finally {
            Conexion.close(pstmt);
            Conexion.close(conn);
        }

        return rows;
    }
    

    @Override
    public int actualizar(Nota nota) {
        int rows = 0;
        try {
            //Preparar una sentencia a partir de una conexion
            conn = Conexion.getConnection();
            pstmt = conn.prepareStatement(SQL_UPDATE);

            pstmt.setString(1, nota.getNombreActividad());
            pstmt.setInt(2, nota.getNotaActividad());
            pstmt.setDate(3, nota.getFechaActividad());
            pstmt.setString(4, nota.getIdAsignacion());
            
            pstmt.setInt(5, nota.getIdNota());

            System.out.println(pstmt.toString());

            rows = pstmt.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace(System.out);
        } catch (Exception e) {
            e.printStackTrace(System.out);
        } finally {
            Conexion.close(pstmt);
            Conexion.close(conn);
        }

        return rows;
    }

    @Override
    public int eliminar(Nota nota) {
     int rows = 0;
        try {
            conn = Conexion.getConnection();
            pstmt = conn.prepareStatement(SQL_DELETE);
            pstmt.setInt(1, nota.getIdNota());
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
