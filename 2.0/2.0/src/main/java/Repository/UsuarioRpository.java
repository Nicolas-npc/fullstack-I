package Repository;

import org.springframework.stereotype.Repository;
import java.util.ArrayList;
import java.util.List;
import Model.UsuarioModel;

public class UsuarioRpository {
    private List<UsuarioModel> listaUsuarios = new ArrayList<>();

    public List<UsuarioModel> obtenerUsuarios() {
        return listaUsuarios;
    }

    public UsuarioModel buscarPorId(int id) {
        for (UsuarioModel usuario : listaUsuarios) {
            if (usuario.getId() == id) {
                return usuario;
            }
        }
        return null;
    }

    public UsuarioModel buscarPorNombre(String nombre) {
        for (UsuarioModel usuario : listaUsuarios) {
            if (usuario.getNombre().equals(nombre)) {
                return usuario;
            }
        }
        return null;
    }

    public UsuarioModel guardar(UsuarioModel user) {

        listaUsuarios.add(user);
        return user;
    }

    public UsuarioModel actualizar(UsuarioModel user) {
        int id  = 0;
        int idPosicion = 0;

        for (int i = 0; i < listaUsuarios.size(); i++) {
            if (listaUsuarios.get(i).getId() == user.getId()) {
                id = user.getId();
                idPosicion = i;
            }
        }

        UsuarioModel usuario1 = new UsuarioModel();
        usuario1.setId(id);
        usuario1.setNombre(user.getNombre());
        usuario1.setCorreo(user.getCorreo());
        usuario1.setContraseña(user.getContraseña());
        usuario1.setRol(user.getRol());

        listaUsuarios.set(idPosicion, usuario1);
        return usuario1;
    }

    public void eliminar(int id) {
        UsuarioModel usuario = buscarPorId(id);
        if (usuario != null) {
            listaUsuarios.remove(usuario);
        }
        int idPosicion = 0;
        for (int i = 0; i < listaUsuarios.size(); i++) {
            if (listaUsuarios.get(i).getId() == id) {
                idPosicion = i;
                break;
            }
        }
        if (idPosicion > 0) {
            listaUsuarios.remove(idPosicion);
        }
        listaUsuarios.removeIf(x -> x.getId() == id);
    }
}
