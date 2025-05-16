package Model;

import org.springframework.boot.autoconfigure.domain.EntityScan;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
@EntityScan
public class EmpleadoModel {
    private String nombre;
    private String correo;
    private String contrasena;
    private String puesto;
    private String turno;
}
