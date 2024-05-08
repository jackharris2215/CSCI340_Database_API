package App.Infrastructure;

import App.Domain.ITeaRepository;
import App.Domain.Store;
import App.Domain.Tea;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.List;

public class TeaRepository implements ITeaRepository {

    private JdbcTemplate databaseConnection;
    @Override
    public Tea create(Tea tea) {
        String sql = "INSERT INTO jh203518.TEA\n" +
                "VALUES ('"
                + tea.getName() + "', '"
                + tea.getType() + "', '"
                + tea.getBrewTemp() + "', '"
                + tea.getBrewTime() + "', '"
                + tea.getBrewQuantity() + "', '"
                + tea.getAmount()  + "', '";
        this.databaseConnection.execute(sql);
        return tea;
    }

    @Override
    public int update(String name, Tea tea) {
        String sql = "UPDATE jh203518.TEA SET name = '" + tea.getName()
                + "', type = '" + tea.getType()
                + "', brewTemp = '" + tea.getBrewTemp()
                + "', brewTime = '" + tea.getBrewTime()
                + "', brewQuantity = '" + tea.getBrewQuantity()
                + "', amount = '" + tea.getAmount()
                + "' WHERE name = '" + name + "';";
        return this.databaseConnection.update(sql);
    }

    @Override
    public boolean delete(String id) {
        return false;
    }

    @Override
    public List<Tea> get(String name) {
        String sql = "SELECT * FROM jh203518.TEA WHERE name = '" + name + "';";
        return this.databaseConnection.query(sql, BeanPropertyRowMapper.newInstance(Tea.class));
    }

    @Override
    public List<Tea> get() {
        String sql = "SELECT * FROM jh203518.TEA;";
        return this.databaseConnection.query(sql, BeanPropertyRowMapper.newInstance(Tea.class));
    }

    public List<Tea> buy(String name) {
        String sql = "SELECT * FROM jh203518.TEA WHERE name = '" + name + "';";
        List<Tea> teaStuff = this.databaseConnection.query(sql, BeanPropertyRowMapper.newInstance(Tea.class));
        String dec = "UPDATE jh203518.TEA SET Amount = Amount-1 WHERE Amount>0 AND name='" + name +"';";
        this.databaseConnection.execute(dec);
        return teaStuff;
    }

    @Override
    public void setDatabaseConnection(JdbcTemplate databaseConnection) {
        this.databaseConnection = databaseConnection;
    }
}
