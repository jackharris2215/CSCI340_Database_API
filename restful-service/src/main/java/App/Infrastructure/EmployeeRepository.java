package App.Infrastructure;

import App.Domain.Employee;
import App.Domain.IEmployeeRepository;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.List;

public class EmployeeRepository implements IEmployeeRepository {

    private JdbcTemplate databaseConnection;

    public void setDatabaseConnection(JdbcTemplate databaseConnection){
        this.databaseConnection = databaseConnection;
    }

    @Override
    public Employee create(Employee employee) {
        String sql = "INSERT INTO jh203518.EMPLOYEE VALUES ('" + employee.getId() + "', '" + employee.getName() + "', '" + employee.getDateOfBirth() + "', '" + employee.getWorkLocation()+ "');";
        this.databaseConnection.execute(sql);
        return employee;
    }

    @Override
    public int update(String id, Employee employee) {
        String sql = "UPDATE jh203518.EMPLOYEE SET id = '" + employee.getId() + "', name = '" + employee.getName() + "', dateofbirth = '" + employee.getDateOfBirth() + "', workLocation = '" + employee.getWorkLocation() + "' WHERE id = '" + id + "';";
        return this.databaseConnection.update(sql);
    }

    @Override
    public boolean delete(String id) {
        String sql = "DELETE FROM jh203518.EMPLOYEE WHERE id = '" + id + "';";
        this.databaseConnection.execute(sql);
        return true;
    }

    @Override
    public List<Employee> get(String id){
        String sql = "SELECT * FROM jh203518.EMPLOYEE WHERE id = " + id + ";";
        return this.databaseConnection.query(sql, BeanPropertyRowMapper.newInstance(Employee.class));
    }

    @Override
    public List<Employee> get() {
        String sql = "SELECT * FROM jh203518.EMPLOYEE ORDER BY name;";
        return this.databaseConnection.query(sql, BeanPropertyRowMapper.newInstance(Employee.class));
    }
}
