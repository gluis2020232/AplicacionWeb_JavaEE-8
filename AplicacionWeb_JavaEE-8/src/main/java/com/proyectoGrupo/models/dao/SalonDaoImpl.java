package com.proyectoGrupo.models.dao;

import com.proyectoGrupo.db.Conexion;
import com.proyectoGrupo.models.domain.Salon;
import com.proyectoGrupo.models.idao.ISalonDao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import com.proyectoGrupo.controller.ServletSalon;

/**
 * --add-modules javafx.controls,javafx.fxml
 *
 * @author Denil José Parada Cabrera
 * @date 19/08/2021
 * @time 05:30:48 PM
 * @codigoTecnico: IN5BV
 */
public class SalonDaoImpl implements ISalonDao {

    private static final String SQL_SELLECT = "select salon_id, capacidad,descripcion,nombre_salon from Salon;";
    private static final String SQL_DELETE = "delete from Salon where salon_id = ?";
    private static final String SQL_INSERT = "insert into Salon (capacidad, descripcion, nombre_salon) VALUES (?,?,?);";
    private static final String SQL_SELLECT__STRING_BY_ID = "SELECT salon_id, capacidad, descripcion, nombre_salon FROM Salon where salon_id = ?";
    private static final String SQL_UPDATE = "UPDATE Salon SET capacidad = ?, descripcion = ?, nombre_salon = ? WHERE salon_id = ?";

    Connection conn = null;
    PreparedStatement pstmt = null;
    ResultSet rs = null;
    Salon salon = null;
    List<Salon> ListaSalon = new ArrayList<>();

    @Override
    public List<Salon> listar() {
        try {
            conn = Conexion.getConnection();
            pstmt = conn.prepareStatement(SQL_SELLECT);
            rs = pstmt.executeQuery();
            while (rs.next()) {
                int idSalon = rs.getInt("salon_id");
                int capacidad = rs.getInt("capacidad");
                String descripcion = rs.getString("descripcion");
                String nombre_salon = rs.getString("nombre_salon");

                salon = new Salon(idSalon, capacidad, descripcion, nombre_salon);
                ListaSalon.add(salon);

            }
        } catch (SQLException e) {
            e.printStackTrace(System.out);
            System.out.println("ecepcion de tipo sql");

        } catch (Exception e) {
            e.printStackTrace(System.out);
        } finally {
            Conexion.close(rs);
            Conexion.close(pstmt);
            Conexion.close(conn);
        }
        return ListaSalon;
    }

    @Override
    public Salon encontrar(Salon salon) {
        try {
            conn = Conexion.getConnection();
            pstmt = conn.prepareStatement(SQL_SELLECT__STRING_BY_ID);
            pstmt.setInt(1, salon.getIdSalon());
            pstmt.toString();

            rs = pstmt.executeQuery();

            while (rs.next()) {
                int capacidad = Integer.parseInt(rs.getString("capacidad"));
                String descripcion = rs.getString("descripcion");
                String nombre_salon = rs.getString("nombre_salon");

                salon.setCapacidad(capacidad);
                salon.setDescripcion(descripcion);
                salon.setNombre_salon(nombre_salon);

                ListaSalon.add(salon);
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
        return salon;
    }

    @Override
    public int insertar(Salon salon) {
        int rows = 0;
        try {
            conn = Conexion.getConnection();
            pstmt = conn.prepareStatement(SQL_INSERT);
            pstmt.setInt(1, salon.getCapacidad());
            pstmt.setString(2, salon.getDescripcion());
            pstmt.setString(3, salon.getNombre_salon());
            System.out.println(pstmt.toString());
            rows = pstmt.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            Conexion.close(pstmt);
            Conexion.close(conn);

        }
        return rows;
    }

    @Override
    public int actualizar(Salon salon) {
    int rows = 0;
        try {
            conn = Conexion.getConnection();
            pstmt = conn.prepareStatement(SQL_UPDATE);
            pstmt.setInt(1, salon.getCapacidad());
            pstmt.setString(2, salon.getDescripcion());
            pstmt.setString(3, salon.getNombre_salon());
            pstmt.setString(3, salon.getNombre_salon());
            pstmt.setInt(4, salon.getIdSalon());
            System.out.println(pstmt.toString());
            rows = pstmt.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            Conexion.close(pstmt);
            Conexion.close(conn);

        }
        return rows;
    }

    @Override
    public int eliminar(Salon salon) {
        int rows = 0;
        try {
            conn = Conexion.getConnection();
            pstmt = conn.prepareStatement(SQL_DELETE);
            pstmt.setInt(1, salon.getIdSalon());
            System.out.println(pstmt.toString());
            rows = pstmt.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace(System.out);
        } finally {
            Conexion.close(pstmt);
            Conexion.close(conn);

        }
        return rows;
    }

}