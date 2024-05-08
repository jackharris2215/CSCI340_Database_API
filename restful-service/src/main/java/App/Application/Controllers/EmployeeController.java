package App.Application.Controllers;

import App.Domain.Employee;
import App.Infrastructure.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/Employee")
public class EmployeeController {



    @Autowired
    private JdbcTemplate databaseConnection;
    private EmployeeRepository employeeRepository;

    public EmployeeController() {
        this.employeeRepository = new EmployeeRepository();
    }

    @GetMapping("/")
    @ResponseStatus(HttpStatus.OK)
    public List<Employee> get(){
        this.employeeRepository.setDatabaseConnection(this.databaseConnection);
        return this.employeeRepository.get();
    }

    @GetMapping("/{Id}")
    @ResponseStatus(HttpStatus.OK)
    public List<Employee> get(@PathVariable("id") String id){
        this.employeeRepository.setDatabaseConnection(this.databaseConnection);
        return this.employeeRepository.get(id);
    }

    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public void put(@PathVariable("id") String id, @RequestBody() Employee employee){
        this.employeeRepository.setDatabaseConnection(this.databaseConnection);
        this.employeeRepository.update(id, employee);
    }

    @PostMapping("/")
    @ResponseStatus(HttpStatus.CREATED)
    public void post(@RequestBody() Employee employee){
        this.employeeRepository.setDatabaseConnection(this.databaseConnection);
        this.employeeRepository.create(employee);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public void delete(@PathVariable("id") String id){
        this.employeeRepository.setDatabaseConnection(this.databaseConnection);
        this.employeeRepository.delete(id);
    }
}
