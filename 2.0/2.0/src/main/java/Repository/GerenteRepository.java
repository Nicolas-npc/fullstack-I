package Repository;

import org.springframework.stereotype.Repository;
import java.util.ArrayList;
import java.util.List;
import Usuarios.Gerente;

@Repository
public class GerenteRepository {
    private List<Gerente> listaGerentes = new ArrayList<>();

    public List<Gerente> obtenerGerentes() {
        return listaGerentes;
    }

    public Gerente buscarPorId(int id) {
        for (Gerente gerente : listaGerentes) {
            if (gerente.getId() == id) {
                return gerente;
            }
        }
        return null;
    }

    public Gerente buscarPorNombre(String nombre) {
        for (Gerente gerente : listaGerentes) {
            if (gerente.getNombre().equals(nombre)) {
                return gerente;
            }
        }
        return null;
    }

    public Gerente guardar(Gerente grnt) {
        listaGerentes.add(grnt);
        return grnt;
    }

    public Gerente actualizar(Gerente grnt) {
        int id  = 0;
        int idPosicion = 0;

        for (int i = 0; i < listaGerentes.size(); i++) {
            if (listaGerentes.get(i).getId() == grnt.getId()) {
                id = grnt.getId();
                idPosicion = i;
            }
        }

        Gerente gerente1 = new Gerente();
        gerente1.setId(id);
        gerente1.setNombre(grnt.getNombre());
        gerente1.setCorreo(grnt.getCorreo());
        gerente1.setContraseña(grnt.getContraseña());
        gerente1.setRol(grnt.getRol());

        listaGerentes.set(idPosicion, gerente1);
        return gerente1;
    }

    public void eliminar(int id) {
        Gerente gerente = buscarPorId(id);
        if (gerente != null) {
            listaGerentes.remove(gerente);
        }
        int idPosicion = 0;
        for (int i = 0; i < listaGerentes.size(); i++) {
            if (listaGerentes.get(i).getId() == id) {
                idPosicion = i;
                break;
            }
        }
        if (idPosicion > 0) {
            listaGerentes.remove(idPosicion);
        }
        listaGerentes.removeIf(x -> x.getId() == id);
    }
}
