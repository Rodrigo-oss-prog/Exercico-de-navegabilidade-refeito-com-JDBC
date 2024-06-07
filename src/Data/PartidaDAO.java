package Data;

import Model.Estadio;
import Model.Partida;
import Model.Time;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class PartidaDAO implements DAO<Partida> {
    @Override
    public void insert(Partida partida) {
        String sql = "INSERT INTO partida(id, id_estadio, id_time1, id_time2) VALUES(?,?,?,?)";
        try(PreparedStatement stmt = ConnectionFactory.createStatement(sql)) {
            stmt.setInt(1, partida.getIdPartida());
            stmt.setInt(2, partida.getEstadio().getId());
            stmt.setInt(3, partida.getTime1().getId());
            stmt.setInt(4, partida.getTime2().getId());
            stmt.executeUpdate();


        }catch (SQLException e){
            e.printStackTrace();
        }

    }

    @Override
    public void update(Partida partida) {
        String sql = "UPDATE partida SET id_estadio =?, id_time1 =?, id_time2 =? WHERE id =?";
        try(PreparedStatement stmt = ConnectionFactory.createStatement(sql)) {
            stmt.setInt(1, partida.getEstadio().getId());
            stmt.setInt(2, partida.getTime1().getId());
            stmt.setInt(3, partida.getTime2().getId());
            stmt.setInt(4, partida.getIdPartida());
            stmt.executeUpdate();


        }catch (SQLException e){
            e.printStackTrace();
        }

    }

    @Override
    public void delete(Partida partida) {
        String sql = "DELETE FROM partida WHERE id =?";
        try(PreparedStatement stmt = ConnectionFactory.createStatement(sql)) {
            stmt.setInt(1, partida.getIdPartida());
            stmt.executeUpdate();


        }catch (SQLException e){
            e.printStackTrace();
        }

    }

    @Override
    public Partida findById(int id) {
        String sql = "SELECT * FROM partida WHERE id =?";
        Partida partida = null;
        try(PreparedStatement stmt = ConnectionFactory.createStatement(sql)) {
            stmt.setInt(1, id);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                Estadio estadio = new EstadioDAO().findById(rs.getInt("estadio"));
                Time time1 = new TimeDAO().findById(rs.getInt("time1"));
                Time time2 = new TimeDAO().findById(rs.getInt("time2"));
                partida = new Partida(rs.getInt("id"),
                        estadio, time1, time2);
            }


        }catch (SQLException e) {
            e.printStackTrace();
        }
        return partida;
    }

    @Override
    public List<Partida> findAll() {
        String sql = "SELECT * FROM partida";
        List<Partida> partidas = new ArrayList<>();
        try(PreparedStatement stmt = ConnectionFactory.createStatement(sql)) {
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                Estadio estadio = new EstadioDAO().findById(rs.getInt("estadio"));
                Time time1 = new TimeDAO().findById(rs.getInt("time1"));
                Time time2 = new TimeDAO().findById(rs.getInt("time2"));
                Partida partida = new Partida(rs.getInt("id"),
                        estadio, time1, time2);
                partidas.add(partida);
            }
        }catch (SQLException e) {
            e.printStackTrace();
        }
        return partidas;
    }
}
