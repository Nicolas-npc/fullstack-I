package Service;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import Usuarios.Gerente;
import Repository.GerenteRepository;

@Service
public class GerenteService {
    @Autowired
    private GerenteRepository repo;

    public GerenteService(GerenteRepository repo) {
        this.repo = repo;
    }
    
    public Gerente crearGerente(Gerente gerente) {
        return repo.guardar(gerente);
    }

    public List<Gerente> obtenerTodos() {
        return repo.obtenerGerentes();
    }

    public Gerente actualizarGerente(int id, Gerente nuevo) {
        Gerente existente = repo.buscarPorId(id);
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
