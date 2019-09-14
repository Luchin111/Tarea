package Controller;

import domain.Pumakatari;
import domain.PumakatariRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class PumakatariController {
    private final PumakatariRepository repository;

    PumakatariController(PumakatariRepository repository) {
        this.repository = repository;
    }

    // Aggregate root

    @GetMapping("/Puma")
    List<Pumakatari> all() {
        return repository.findAll();
    }

    @PostMapping("/Puma")
    Pumakatari newEmployee(@RequestBody Pumakatari newPumakatari) {
        return repository.save(newPumakatari);
    }

    // Single item

    @GetMapping("/Puma/{id}")
    Pumakatari one(@PathVariable Long id) {

        return repository.findById(id)
                .orElseThrow(() -> new PumakatariNotFoundException(id));
    }

    @PutMapping("/Puma/{id}")
    Pumakatari replaceEmployee(@RequestBody Pumakatari newPumakatari, @PathVariable Long id) {

        return repository.findById(id)
                .map(pumakatari -> {
                    pumakatari.setPlaca(newPumakatari.getPlaca());
                    pumakatari.setRuta(newPumakatari.getRuta());
                    return repository.save(pumakatari);
                })
                .orElseGet(() -> {
                    newPumakatari.setId(id);
                    return repository.save(newPumakatari);
                });
    }

    @DeleteMapping("/Puma/{id}")
    void deleteEmployee(@PathVariable Long id) {
        repository.deleteById(id);
    }
}
