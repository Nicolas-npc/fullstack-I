package Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import Usuarios.Empleado;
import Repository.EmpleadoRepository;

@Service
public class EmpleadoService {
    @Autowired
    private EmpleadoRepository repo;

    public EmpleadoService(EmpleadoRepository repo) {
        this.repo = repo;
    }

    public Empleado crearEmpleado(Empleado empleado) {
        return repo.guardar(empleado);
    }

    public List<Empleado> obtenerTodos() {
        return repo.obtenerEmpleados();
    }

    public Empleado actualizarEmpleado(int id, Empleado nuevo) {
        Empleado existente = repo.buscarPorId(id);
        if (existente != null) {
            existente.setId(nuevo.getId());
            existente.setNombre(nuevo.getNombre());
            existente.setCorreo(nuevo.getCorreo());
            existente.setRol(nuevo.getRol());
            existente.setContraseña(nuevo.getContraseña());
            return repo.guardar(existente);
        }
        return null;
    }

    public void eliminarUsuario(int id) {
        repo.eliminar(id);
    }
}
