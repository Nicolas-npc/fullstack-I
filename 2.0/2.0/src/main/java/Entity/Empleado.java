package Entity;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
@Data
@NoArgsConstructor
@EntityScan
@EqualsAndHashCode(callSuper = true)
public class Empleado {
    private int idEmpleado;
    private String sucursal;

    public Empleado(int id, String nombre, String correo, String contraseña, int idEmpleado, String sucursal) {
        super(id, nombre, correo, contraseña, "EMPLEADO", true); // Llama al constructor de la superclase y establece el rol y activo
        this.idEmpleado = idEmpleado;
        this.sucursal = sucursal;
    }

    public void registrarVenta() {
        System.out.println("Empleado " + getNombre() + " ha registrado una venta.");
    }
}
