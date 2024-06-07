package Data;

import Model.Estadio;


import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class EstadioDAO implements DAO<Estadio>{

    @Override
    public void insert(Estadio estadio) {
        String sql = "INSERT INTO estadio(id, nome) VALUES(?, ? )";
        try(PreparedStatement stmt = ConnectionFactory.createStatement(sql)) {
            stmt.setInt(1, estadio.getId());
            stmt.setString(2, estadio.getNome());
            ;
            stmt.executeUpdate();

        }catch (SQLException e){
            e.printStackTrace();
        }



    }

    @Override
    public void update(Estadio estadio) {
        String sql = "UPDATE estadio SET nome =? WHERE id =?";
        try(PreparedStatement stmt = ConnectionFactory.createStatement(sql)) {
            stmt.setString(1, estadio.getNome());

            stmt.setInt(3, estadio.getId());
            stmt.executeUpdate();

        }catch (SQLException e){
            e.printStackTrace();
        }

    }

    @Override
    public void delete(Estadio estadio) {
        String sql = "DELETE FROM estadio WHERE id =?";
        try(PreparedStatement stmt = ConnectionFactory.createStatement(sql)) {
            stmt.setInt(1, estadio.getId());
            stmt.executeUpdate();

        }catch (SQLException e){
            e.printStackTrace();
        }

    }

    @Override
    public Estadio findById(int id) {
        String sql = "SELECT * FROM estadio WHERE id =?";
        Estadio estadio = null;
        try(PreparedStatement stmt = ConnectionFactory.createStatement(sql)) {
            stmt.setInt(1, id);
            ResultSet rs = stmt.executeQuery();

            while (rs.next()){
                estadio = new Estadio(rs.getInt("id"),
                        rs.getString("nome"));



            }


        }catch(SQLException e){
            e.printStackTrace();

        }
        return estadio;
    }

    @Override
    public List<Estadio> findAll() {
        String sql = "SELECT * FROM estadio";
        List<Estadio> estadios = new ArrayList<>();
        try(PreparedStatement stmt = ConnectionFactory.createStatement(sql)) {
            ResultSet rs = stmt.executeQuery();

            while (rs.next()){
                Estadio estadio = new Estadio(rs.getInt("id"),
                        rs.getString("nome"));
                estadios.add(estadio);



            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return estadios;
    }
}
