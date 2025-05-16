package Model;

import org.springframework.boot.autoconfigure.domain.EntityScan;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@EntityScan
public class GerenteModel {
    private String nombre;
    private String correo;
    private String contrasena;
    private String puesto;
    private String turno;
    private boolean estado = true;
}
