package Usuarios;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
@Data
@NoArgsConstructor
@EntityScan
@EqualsAndHashCode(callSuper = true)
public class Gerente extends Usuario {
    private String sucursalAsignada;

    public Gerente(int id, String nombre, String correo, String contraseña, String sucursalAsignada) {
        super(id, nombre, correo, contraseña, "GERENTE", true); 
        this.sucursalAsignada = sucursalAsignada;
    }

    public void generarReporte() {
        System.out.println("Gerente " + getNombre() + " ha generado un reporte " + sucursalAsignada);
    }
}
