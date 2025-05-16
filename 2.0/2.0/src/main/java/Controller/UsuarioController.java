package Controller;
import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import Model.EmpleadoModel;
import Service.EmpleadoService;

@RestController
@RequestMapping("/Usuario")
public class UsuarioController {
    private UsuarioService service;

    public UsuarioController(UsuarioService service) {
        this.service = service;
    }

    @PostMapping
    public UsuarioModel crear(@RequestBody UsuarioModel usuario) {
        return service.crearUsuario(usuario);
    }

    @GetMapping
    public List<UsuarioModel> listar() {
        return service.obtenerTodos();
    }

    @PutMapping("/{id}")
    public UsuarioModel actualizarUsuario(@PathVariable int id, @RequestBody UsuarioModel nuevo) {
        return service.actualizarUsuario(id, nuevo);
    }

    @DeleteMapping("/{id}")
    public void eliminar(@PathVariable int id) {
        service.eliminarUsuario(id);
    }
}
