package Controller;

import java.util.List;

import Model.GerenteModel;
import Repository.GerenteRepository;
import Service.GerenteService;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/Gerentes")
public class GerenteController {
private GerenteService service;
    public GerenteController(GerenteService service) {
        this.service = service;
    }
    
    @PostMapping
    public GerenteRepository crear(@RequestBody GerenteService Gerente) {
        return service.crearGerente(Gerente);
    }
    
    @GetMapping
    public List<GerenteModel> listar() {
        return service.obtenerTodos();
    }
    
    @PutMapping("/{id}")
    public GerenteModel actualizarGerente(@PathVariable int id, @RequestBody GerenteModel nuevo) {
        return service.actualizarGerente(id, nuevo);
    }

    @DeleteMapping("/{id}")
    public void eliminar(@PathVariable int id) {
        service.eliminarUsuario(id);
    }
}
