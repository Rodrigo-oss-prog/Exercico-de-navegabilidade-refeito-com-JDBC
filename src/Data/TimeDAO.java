package Data;

import Model.Time;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class TimeDAO implements DAO<Time>{
    @Override
    public void insert(Time time) {
        String sql = "INSERT INTO time(id, nome) VALUES (?,?)";
        try(PreparedStatement stmt = ConnectionFactory.createStatement(sql)) {
            stmt.setInt(1, time.getId());
            stmt.setString(2, time.getNome());
            stmt.executeUpdate();



        }catch (SQLException e) {
            e.printStackTrace();
        }

    }

    @Override
    public void update(Time time) {
        String sql = "UPDATE time SET nome =? WHERE id =?";
        try(PreparedStatement stmt = ConnectionFactory.createStatement(sql)) {
            stmt.setString(1, time.getNome());
            stmt.setInt(2, time.getId());
            stmt.executeUpdate();



        }catch (SQLException e) {
            e.printStackTrace();
        }

    }

    @Override
    public void delete(Time time) {
        String sql = "DELETE FROM time WHERE id =?";
        try(PreparedStatement stmt = ConnectionFactory.createStatement(sql)) {
            stmt.setInt(1, time.getId());
            stmt.executeUpdate();



        }catch (SQLException e) {
            e.printStackTrace();
        }

    }

    @Override
    public Time findById(int id) {
        String sql = "SELECT * FROM time WHERE id = ?";
        Time time = null;
        try(PreparedStatement stmt = ConnectionFactory.createStatement(sql)) {
            stmt.setInt(1, id);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                time = new Time(
                        rs.getInt("id"),
                        rs.getString("nome")
                );
            }
        }catch (SQLException e) {
            e.printStackTrace();
        }

        return time;
    }

    @Override
    public List<Time> findAll() {
        String sql = "SELECT * FROM time";
        List<Time> times = new ArrayList<>();
        try(PreparedStatement stmt = ConnectionFactory.createStatement(sql)) {
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                Time time = new Time(
                        rs.getInt("id"),
                        rs.getString("nome")
                );
                times.add(time);
            }
        }catch (SQLException e) {
            e.printStackTrace();
        }
        return times;
    }
}
