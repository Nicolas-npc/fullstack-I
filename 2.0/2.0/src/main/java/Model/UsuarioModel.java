package Model;

import org.springframework.boot.autoconfigure.domain.EntityScan;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@EntityScan
public class UsuarioModel {
    private int id;
    private String nombre;
    private String correo;
    private String contraseña;
    private String rol;
    private boolean activo = true;
}
