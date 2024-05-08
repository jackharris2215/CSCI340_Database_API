package App.Application.Controllers;

import App.Domain.Tea;
import App.Infrastructure.TeaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController()
@RequestMapping("/Tea")
public class TeaController {

    @Autowired
    private JdbcTemplate databaseConnection;

    private TeaRepository teaRepository;

    public TeaController(){
        this.teaRepository = new TeaRepository();
    }

    @GetMapping("/")
    @ResponseStatus(HttpStatus.OK)
    public List<Tea> get(){
        this.teaRepository.setDatabaseConnection(this.databaseConnection);
        return this.teaRepository.get();
    }

    @GetMapping("/{name}")
    @ResponseStatus(HttpStatus.OK)
    public List<Tea> get(@PathVariable("name") String name){
        this.teaRepository.setDatabaseConnection(this.databaseConnection);
        return this.teaRepository.get(name);
    }

    @GetMapping("/buy/{name}")
    @ResponseStatus(HttpStatus.OK)
    public Tea buy(@PathVariable("name") String name){
        this.teaRepository.setDatabaseConnection(this.databaseConnection);
        return this.teaRepository.buy(name).getFirst();
    }
}
