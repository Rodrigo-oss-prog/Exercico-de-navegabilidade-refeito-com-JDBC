package Data;

import Model.Jogador;
import Model.Time;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class JogadorDAO implements DAO<Jogador> {
    @Override
    public void insert(Jogador jogador) {
        String sql = "INSERT INTO jogador(id, nome, id_time) VALUES (?, ?, ?)";
        try(PreparedStatement stmt = ConnectionFactory.createStatement(sql)){
            stmt.setInt(1, jogador.getId());
            stmt.setString(2, jogador.getNome());
            stmt.setInt(3, jogador.getId());
            stmt.executeUpdate();

        }catch (SQLException e){
            e.printStackTrace();

        }
    }

    @Override
    public void update(Jogador jogador) {
        String sql = "UPDATE jogador SET nome =?, id_time =? WHERE id =?";
        try(PreparedStatement stmt = ConnectionFactory.createStatement(sql)){
            stmt.setString(1, jogador.getNome());
            stmt.setInt(2, jogador.getId());
            stmt.setInt(3, jogador.getId());
            stmt.executeUpdate();

        }catch (SQLException e){
            e.printStackTrace();

        }

    }

    @Override
    public void delete(Jogador jogador) {
        String sql = "DELETE FROM jogador WHERE id =?";
        try(PreparedStatement stmt = ConnectionFactory.createStatement(sql)){
            stmt.setInt(1, jogador.getId());
            stmt.executeUpdate();

        }catch (SQLException e){
            e.printStackTrace();

        }

    }

    @Override
    public Jogador findById(int id) {
        String sql = "SELECT * FROM jogador WHERE id =?";
        Jogador jogador = null;
        try(PreparedStatement stmt = ConnectionFactory.createStatement(sql)){
            stmt.setInt(1, id);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()){
                Time time =new TimeDAO().findById(rs.getInt("id_time"));
                jogador = new Jogador(
                        rs.getInt("id"),
                        rs.getString("nome"),
                        time

                );
            }


        }catch(SQLException e){
            e.printStackTrace();
        }
        return jogador;
    }

    @Override
    public List<Jogador> findAll() {
        String sql = "SELECT * FROM jogador";
        List<Jogador> jogadores = new ArrayList<>();
        try(PreparedStatement stmt = ConnectionFactory.createStatement(sql)){
            ResultSet rs = stmt.executeQuery();
            while (rs.next()){
                Time time =new TimeDAO().findById(rs.getInt("id_time"));
                Jogador jogador = new Jogador(
                        rs.getInt("id"),
                        rs.getString("nome"),
                        time

                );
                jogadores.add(jogador);
            }

        }catch (SQLException e) {

        }
        return jogadores;
    }
}
