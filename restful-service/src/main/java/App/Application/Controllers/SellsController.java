package App.Application.Controllers;

import App.Domain.Sells;
import App.Domain.Tea;
import App.Infrastructure.SellsRepository;
import App.Infrastructure.TeaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController()
@RequestMapping("/Sells")
public class SellsController {
    @Autowired
    private JdbcTemplate databaseConnection;

    private SellsRepository sellsRepository;

    public SellsController(){
        this.sellsRepository = new SellsRepository();
    }

    @GetMapping("/")
    @ResponseStatus(HttpStatus.OK)
    public List<Sells> get(){
        this.sellsRepository.setDatabaseConnection(this.databaseConnection);
        return this.sellsRepository.get();
    }
}
