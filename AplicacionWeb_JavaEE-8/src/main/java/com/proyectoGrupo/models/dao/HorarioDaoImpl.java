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
import com.proyectoGrupo.models.domain.Horario;
import com.proyectoGrupo.models.idao.IHorarioDao;
import java.sql.Time;

/**
 *
 * @author Hugo Daniel Velasquez Patzan Codigo Tecnico IN5BV
 * @date 01-sep-2021
 * @time 12:35:38
 */
public class HorarioDaoImpl implements IHorarioDao {

    private static final String SQL_SELECT = "SELECT horario_id, horario_final, horario_inicio FROM Horario;";
    private static final String SQL_DELETE = "DELETE FROM Horario WHERE horario_id = ?";
    private static final String SQL_INSERT = "INSERT INTO Horario(horario_final, horario_inicio) VALUES (?, ?)";
    private static final String SQL_SELECT_BY_ID = "SELECT horario_id, horario_final, horario_inicio FROM Horario WHERE horario_id = ?";
    private static final String SQL_UPDATE = "UPDATE Horario SET horario_final = ?, horario_inicio = ? WHERE horario_id = ?";

    Connection conn = null;
    PreparedStatement pstmt = null;
    ResultSet rs = null;
    Horario horario = null;
    List<Horario> listaHorario = new ArrayList<>();

    @Override
    public List<Horario> listar() {

        try {
            conn = Conexion.getConnection();
            pstmt = conn.prepareStatement(SQL_SELECT);
            rs = pstmt.executeQuery();

            while (rs.next()) {
                int idHorario = rs.getInt("horario_id");
                Time horario_final = rs.getTime("horario_final");
                Time horario_inicio = rs.getTime("horario_inicio");

                horario = new Horario(idHorario, horario_final, horario_inicio);
                listaHorario.add(horario);
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
        return listaHorario;
    }

    @Override
    public int eliminar(Horario horario) {
        int rows = 0;
        try {
            conn = Conexion.getConnection();
            pstmt = conn.prepareStatement(SQL_DELETE);
            pstmt.setInt(1, horario.getIdHorario());
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

    @Override
    public Horario encontrar(Horario horario) {
        try {
            conn = Conexion.getConnection();
            pstmt = conn.prepareStatement(SQL_SELECT_BY_ID);

            pstmt.setInt(1, horario.getIdHorario());
            System.out.println(pstmt.toString());

            rs = pstmt.executeQuery();

            while (rs.next()) {
                //Estos campos tienen que coincidir con base de datos       
                Time horarioFinal = rs.getTime("horario_final");
                Time horarioInicio = rs.getTime("horario_inicio");

                horario.setHorario_final(horarioFinal);
                horario.setHorario_inicio(horarioInicio);

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
        return horario;
    }

    @Override
    public int insertar(Horario horario) {
        int rows = 0;
        try {
            conn = Conexion.getConnection();
            pstmt = conn.prepareStatement(SQL_INSERT);

            pstmt.setTime(1, horario.getHorario_final());
            pstmt.setTime(2, horario.getHorario_inicio());

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
    public int actualizar(Horario horario) {
        int rows = 0;
        try {
            //Preparar una sentencia a partir de una conexion
            conn = Conexion.getConnection();
            pstmt = conn.prepareStatement(SQL_UPDATE);
            
            pstmt.setTime(1, horario.getHorario_final());
            pstmt.setTime(2, horario.getHorario_inicio());

            pstmt.setInt(3, horario.getIdHorario());

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

}
