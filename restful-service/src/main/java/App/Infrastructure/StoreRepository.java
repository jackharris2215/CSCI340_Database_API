package App.Infrastructure;

import App.Domain.IStoreRepository;
import App.Domain.Store;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.List;

public class StoreRepository implements IStoreRepository {

    private JdbcTemplate databaseConnection;
    @Override
    public Store create(Store store) {
        String sql = "INSERT INTO jh203518.STORE\n" +
                "VALUES ('"
                + store.getId() + "', '"
                + store.getAddress()  + "', '";
        this.databaseConnection.execute(sql);
        return store;
    }

    @Override
    public int update(String id, Store store) {
        String sql = "UPDATE jh203518.STORE SET Address = '" + store.getAddress() + "',";
        return this.databaseConnection.update(sql);
    }

    @Override
    public boolean delete(String id) {
        return false;
    }

    @Override
    public List<Store> get(String id) {
        String sql = "SELECT * FROM jh203518.STORE WHERE id = '" + id + "';";
        return this.databaseConnection.query(sql, BeanPropertyRowMapper.newInstance(Store.class));
    }

    @Override
    public List<Store> get() {
        String sql = "SELECT * FROM jh203518.STORE;";
        return this.databaseConnection.query(sql, BeanPropertyRowMapper.newInstance(Store.class));
    }

    @Override
    public void setDatabaseConnection(JdbcTemplate databaseConnection) {
        this.databaseConnection = databaseConnection;
    }
}
