package App.Infrastructure;

import App.Domain.ISellsRepository;
import App.Domain.Sells;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.List;

public class SellsRepository implements ISellsRepository {

    private JdbcTemplate databaseConnection;

    @Override
    public Sells create(Sells sells) {
        String sql = "INSERT INTO jh203518.SELLS VALUES ('" + sells.getStoreId()
                + "', '" + sells.getProductId()
                + "', '" + sells.getTeaName() + "');";
        this.databaseConnection.execute(sql);
        return sells;
    }

    @Override
    public int update(String id, Sells sells) {
        return 0;
    }

//    public int update(String storeId, String productId, Sells sells) {
//        String sql = "UPDATE jh203518.SELLS SET storeId = '" + sells.getStoreId()
//                + "', productId = '" + sells.getProductId()
//                + "', teaName = '" + sells.getTeaName()
//                + "' WHERE storeId = '" + storeId
//                + "' AND productId = '" + productId + "';";
//        return this.databaseConnection.update(sql);
//    }

    @Override
    public boolean delete(String id) {
        return false;
    }


    @Override
    public List<Sells> get(String storeId) {
        String sql = "SELECT * FROM jh203518.SELLS WHERE storeId = '" + storeId + "';";
        return this.databaseConnection.query(sql, BeanPropertyRowMapper.newInstance(Sells.class));
    }

    @Override
    public List<Sells> get() {
        String sql = "SELECT * FROM jh203518.SELLS;";
        return this.databaseConnection.query(sql, BeanPropertyRowMapper.newInstance(Sells.class));
    }

    @Override
    public void setDatabaseConnection(JdbcTemplate databaseConnection) {
        this.databaseConnection = databaseConnection;
    }
}
