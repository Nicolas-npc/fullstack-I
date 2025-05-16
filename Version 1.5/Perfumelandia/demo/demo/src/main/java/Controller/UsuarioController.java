package Controller;

import java.util.List;
import org.springframework.web.bind.annotation.*;
import Service.UsuarioService;
import Model.UsuarioModel;

@RestController
@RequestMapping("/Usuarios")
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

