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

public class EmpleadosController {
    private EmpleadoService service;
    public EmpleadosController(EmpleadoService service) {
        this.service = service;
    }
    
    @PostMapping
    public EmpleadoModel crear(@RequestBody EmpleadoModel empleado) {
        return service.crearEmpleado(empleado);
    }
    
    @GetMapping
    public List<EmpleadoModel> listar() {
        return service.obtenerEmpleados();
    }
    
    @PutMapping("/{id}")
    public EmpleadoModel actualizaruUsuario(@PathVariable int id, @RequestBody EmpleadoModel nuevo) {
        return service.actualizarEmpleado(id, nuevo);
    }

    @DeleteMapping("/{id}")
    public void eliminar(@PathVariable int id) {
        service.eliminarUsuario(id);
    }
}
