/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.proyectoGrupo.models.dao;

import com.proyectoGrupo.db.Conexion;
import com.proyectoGrupo.models.domain.Curso;
import com.proyectoGrupo.models.idao.ICursoDao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author A-R
 */
public class CursoDaoImpl implements ICursoDao{
    
    private static final String SQL_SELECT = "SELECT curso_id, ciclo, cupo_maximo, cupo_minimo, descipcion, codigo_carrera, horario_id, instructor_id, salon_id FROM Curso;";
    private static final String SQL_DELETE = "DELETE FROM curso WHERE curso_id  = ?";
    private static final String SQL_INSERT = "INSERT INTO curso(ciclo, cupo_maximo, cupo_minimo, descipcion, codigo_carrera, horario_id, instructor_id, salon_id) VALUES ( ?, ?, ?, ?, ?, ?, ?, ?)";
    private static final String SQL_UPDATE = "UPDATE curso SET ciclo = ?, cupo_maximo = ?, cupo_minimo = ?, descipcion = ?, codigo_carrera = ?, horario_id = ?, instructor_id = ?, salon_id = ? WHERE curso_id = ?;";
    private static final String SQL_SELECT_BY_ID = "SELECT curso_id, ciclo, cupo_maximo, cupo_minimo, descipcion, codigo_carrera, horario_id, instructor_id, salon_id FROM Curso WHERE curso_id = ?";


    Connection conn = null;
    PreparedStatement pstmt = null;
    ResultSet rs = null;
    Curso curso = null;
    List<Curso> listaCurso = new ArrayList<>();
    
    @Override
    public List<Curso> listar() {
        try {
            conn = Conexion.getConnection();
            pstmt = conn.prepareStatement(SQL_SELECT);
            rs = pstmt.executeQuery();

            while (rs.next()) {
                int idCurso = rs.getInt("curso_id");
                int ciclo = rs.getInt("ciclo");
                int cupoMaximo = rs.getInt("cupo_maximo");
                int cupoMinimo = rs.getInt("cupo_minimo");
                String descripcion = rs.getString("descipcion");
                String codigoCarreera = rs.getString("codigo_carrera");
                int idHorario = rs.getInt("horario_id");
                int idInstructor = rs.getInt("instructor_id");
                int idSalon = rs.getInt("salon_id");
                curso = new Curso(idCurso, ciclo, cupoMaximo, cupoMinimo, descripcion, codigoCarreera, idHorario, idInstructor, idSalon);
                listaCurso.add(curso);

            }
        } catch (SQLException e) {
            e.printStackTrace(System.out);

        } finally {
            Conexion.close(rs);
            Conexion.close(pstmt);
            Conexion.close(conn);
        }
        return listaCurso;
    }

    @Override
    public Curso encontrar(Curso curso) {
        try {
            conn = Conexion.getConnection();
            pstmt = conn.prepareStatement(SQL_SELECT_BY_ID);
            pstmt.setInt(1, curso.getIdCurso());
            System.out.println(pstmt.toString());
            rs = pstmt.executeQuery();

            while (rs.next()) {
                int ciclo = rs.getInt("ciclo");
                int cupoMaximo = rs.getInt("cupo_maximo");
                int cupoMinimo = rs.getInt("cupo_minimo");
                String descripcion = rs.getString("descipcion");
                String codigoCarreera = rs.getString("codigo_carrera");
                int idHorario = rs.getInt("horario_id");
                int idInstructor = rs.getInt("instructor_id");
                int idSalon = rs.getInt("salon_id");

                /*utilizar metodos Set*/
                curso.setCiclo(ciclo);
                curso.setCupoMaximo(cupoMaximo);
                curso.setCupoMinimo(cupoMinimo);
                curso.setDescripcion(descripcion);
                curso.setCodigoCarrera(codigoCarreera);
                curso.setIdHorario(idHorario);
                curso.setIdInstructor(idInstructor);
                curso.setIdSalon(idSalon);
                System.out.println(curso);
            }
        } catch (SQLException e) {
            e.printStackTrace(System.out);
        } catch (Exception ex) {
            ex.printStackTrace(System.out);
        } finally {
            Conexion.close(rs);
            Conexion.close(pstmt);
            Conexion.close(conn);
        }
        return curso;
    }

    @Override
    public int insertar(Curso curso) {
      int rows = 0;
        try {
            conn = Conexion.getConnection();
            pstmt = conn.prepareStatement(SQL_INSERT);
            pstmt.setInt(1, curso.getCiclo());
            pstmt.setInt(2, curso.getCupoMaximo());
            pstmt.setInt(3, curso.getCupoMinimo());
            pstmt.setString(4, curso.getDescripcion());
            pstmt.setString(5, curso.getCodigoCarrera());
            pstmt.setInt(6, curso.getIdHorario());
            pstmt.setInt(7, curso.getIdInstructor());
            pstmt.setInt(8, curso.getIdSalon());

            System.out.println(pstmt.toString());
            rows = pstmt.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace(System.out);
        } catch (Exception ex) {
            ex.printStackTrace(System.out);
        } finally {
            Conexion.close(pstmt);
            Conexion.close(conn);
        }
        return rows;   
    }
    

    @Override
    public int actualuzar(Curso curso) {
      int rows = 0;
        try {
            conn = Conexion.getConnection();
            pstmt = conn.prepareStatement(SQL_UPDATE);
            pstmt.setInt(1, curso.getCiclo());
            pstmt.setInt(2, curso.getCupoMaximo());
            pstmt.setInt(3, curso.getCupoMinimo());
            pstmt.setString(4, curso.getDescripcion());
            pstmt.setString(5, curso.getCodigoCarrera());
            pstmt.setInt(6, curso.getIdHorario());
            pstmt.setInt(7, curso.getIdInstructor());
            pstmt.setInt(8, curso.getIdSalon());
            pstmt.setInt(9, curso.getIdCurso());
            
            System.out.println(pstmt.toString());
            rows = pstmt.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace(System.out);
        } catch (Exception ex) {
            ex.printStackTrace(System.out);
        } finally {
            Conexion.close(pstmt);
            Conexion.close(conn);
        }
        return rows;    
    }
    

    @Override
    public int eliminar(Curso curso) {
      int rows = 0;
        try {
            conn = Conexion.getConnection();
            pstmt = conn.prepareStatement(SQL_DELETE);
            pstmt.setInt(1, curso.getIdCurso());
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