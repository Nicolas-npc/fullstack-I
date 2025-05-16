package Service;
import Model.UsuarioModel;
import java.util.List;
import Repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UsuarioService {
    @Autowired
    private UsuarioRepository repo;

    public UsuarioService(UsuarioRepository repo) {
        this.repo = repo;
    }

    public UsuarioModel crearUsuario(UsuarioModel usuario) {
        return repo.guardar(usuario);
    }

    public List<UsuarioModel> obtenerTodos() {
        return repo.obtenerUsuarios();
    }

    public UsuarioModel actualizarUsuario(int id, UsuarioModel nuevo) {
        UsuarioModel existente = repo.buscarPorId(id);
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
