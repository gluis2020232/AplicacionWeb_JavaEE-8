package com.proyectoGrupo.models.dao;

import com.proyectoGrupo.db.Conexion;
import com.proyectoGrupo.models.domain.CarreraTecnica;
import com.proyectoGrupo.models.idao.ICarreraTecnicaDao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Hugo Daniel Velasquez Patzan Codigo Tecnico IN5BV
 * @date 27-ago-2021
 * @time 16:55:04
 */
public class CarreraTecnicaDaoImpl implements ICarreraTecnicaDao {

    private static final String SQL_SELECT = "SELECT codigo_carrera, nombres FROM Carrera_tecnica;";
    private static final String SQL_DELETE = "DELETE FROM Carrera_tecnica where codigo_carrera = ?";
    private static final String SQL_INSERT = "INSERT INTO Carrera_tecnica(codigo_carrera, nombres) VALUES (?, ?)";
    private static final String SQL_SELECT_BY_ID = "SELECT codigo_carrera, nombres FROM Carrera_tecnica WHERE codigo_carrera = ?";
    private static final String SQL_UPDATE = "UPDATE Carrera_tecnica SET nombres = ? WHERE codigo_carrera = ?";

    Connection conn = null;
    PreparedStatement pstmt = null;
    ResultSet rs = null;
    CarreraTecnica carreraTecnica = null;

    List<CarreraTecnica> listaCarreraTecnica = new ArrayList<>();

    @Override
    public List<CarreraTecnica> listar() {
        try {
            conn = Conexion.getConnection();
            pstmt = conn.prepareStatement(SQL_SELECT);
            rs = pstmt.executeQuery();

            while (rs.next()) {
                String codigoCarrera = rs.getString("codigo_carrera");
                String nombre = rs.getString("nombres");

                carreraTecnica = new CarreraTecnica(codigoCarrera, nombre);
                listaCarreraTecnica.add(carreraTecnica);
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
        return listaCarreraTecnica;
    }

    @Override
    public CarreraTecnica encontrar(CarreraTecnica carreraTecnica) {
        try {
            conn = Conexion.getConnection();
            pstmt = conn.prepareStatement(SQL_SELECT_BY_ID);//Primer cambio
            pstmt.setString(1, carreraTecnica.getCodigoCarrera());
            System.out.println(pstmt.toString());

            rs = pstmt.executeQuery();

            while (rs.next()) {
                //Estos campos tienen que coincidir con base de datos
                String nombre = rs.getString("nombres");
                
                carreraTecnica.setNombre(nombre);

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
        return carreraTecnica;
    }

    @Override
    public int insertar(CarreraTecnica carreraTecnica) {
        int rows = 0;
        try {
            conn = Conexion.getConnection();
            pstmt = conn.prepareStatement(SQL_INSERT);
            pstmt.setString(1, carreraTecnica.getCodigoCarrera());
            pstmt.setString(2, carreraTecnica.getNombre());

            System.out.println(pstmt.toString());

            //Me devuelve la cantidad de filas que fueron afectadas
            rows = pstmt.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace(System.out);
        } catch (Exception e) {
            e.printStackTrace(System.out);
        } finally {
            Conexion.close(pstmt);
            Conexion.close(conn);
        }
        //
        return rows;
    }

    @Override
    public int actualizar(CarreraTecnica carreraTecnica) {
        int rows = 0;
        try {
            //Preparar una sentencia a partir de una conexion
            conn = Conexion.getConnection();
            pstmt = conn.prepareStatement(SQL_UPDATE);

            pstmt.setString(1, carreraTecnica.getNombre());            
            pstmt.setString(2, carreraTecnica.getCodigoCarrera());

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
    public int eliminar(CarreraTecnica carreraTecnica) {
        int rows = 0;
        try {
            conn = Conexion.getConnection();
            pstmt = conn.prepareStatement(SQL_DELETE);
            pstmt.setString(1, carreraTecnica.getCodigoCarrera());
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