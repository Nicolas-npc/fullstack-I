package Repository;

import org.springframework.stereotype.Repository;
import java.util.ArrayList;
import java.util.List;
import Usuarios.Empleado;

@Repository
public class EmpleadoRepository {
     private List<Empleado> listaEmpleados = new ArrayList<>();

    public List<Empleado> obtenerEmpleados() {
        return listaEmpleados;
    }

    public Empleado buscarPorId(int id) {
        for (Empleado empleado : listaEmpleados) {
            if (empleado.getId() == id) {
                return empleado;
            }
        }
        return null;
    }

    public Empleado buscarPorNombre(String nombre) {
        for (Empleado empleado : listaEmpleados) {
            if (empleado.getNombre().equals(nombre)) {
                return empleado;
            }
        }
        return null;
    }

    public Empleado guardar(Empleado emp) {
        listaEmpleados.add(emp);
        return emp;
    }

    public Empleado actualizar(Empleado emp) {
        int id  = 0;
        int idPosicion = 0;

        for (int i = 0; i < listaEmpleados.size(); i++) {
            if (listaEmpleados.get(i).getId() == emp.getId()) {
                id = emp.getId();
                idPosicion = i;
            }
        }

        Empleado empleado1 = new Empleado();
        empleado1.setId(id);
        empleado1.setNombre(emp.getNombre());
        empleado1.setCorreo(emp.getCorreo());
        empleado1.setContraseña(emp.getContraseña());
        empleado1.setRol(emp.getRol());

        listaEmpleados.set(idPosicion, empleado1);
        return empleado1;
    }

    public void eliminar(int id) {
        Empleado empleado = buscarPorId(id);
        if (empleado != null) {
            listaEmpleados.remove(empleado);
        }
        int idPosicion = 0;
        for (int i = 0; i < listaEmpleados.size(); i++) {
            if (listaEmpleados.get(i).getId() == id) {
                idPosicion = i;
                break;
            }
        }
        if (idPosicion > 0) {
            listaEmpleados.remove(idPosicion);
        }
        listaEmpleados.removeIf(x -> x.getId() == id);
    }
}
