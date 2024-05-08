package App.Application.Controllers;

import App.Domain.Store;
import App.Infrastructure.StoreRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController()
@RequestMapping("/Store")
public class StoreController {

    @Autowired
    private JdbcTemplate databaseConnection;

    private StoreRepository storeRepository;

    public StoreController(){
        this.storeRepository = new StoreRepository();
    }

    @GetMapping("/")
    public List<Store> Get(){
        this.storeRepository.setDatabaseConnection(databaseConnection);
        return this.storeRepository.get();
    }

    @GetMapping("/{id}")
    public Store Get(@PathVariable("id") String id){
        this.storeRepository.setDatabaseConnection(databaseConnection);
        return this.storeRepository.get(id).getFirst();
    }

    @PostMapping("/")
    public String post(@RequestBody() Store storeToSave){
        this.storeRepository.setDatabaseConnection(databaseConnection);
        this.storeRepository.create(storeToSave);
        return storeToSave.getId();
    }

    @PutMapping("/{Id}")
    public void put(@RequestBody() Store storeToSave,
                    @PathVariable("Id") String Id){
        this.storeRepository.setDatabaseConnection(databaseConnection);
        this.storeRepository.update(Id, storeToSave);
    }

    @DeleteMapping("/{Id}")
    public void delete(@PathVariable("Id") String Id){
        this.storeRepository.setDatabaseConnection(databaseConnection);
        this.storeRepository.delete(Id);
    }
}
