package Model;

import org.springframework.boot.autoconfigure.domain.EntityScan;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@EntityScan
public class PerfumeModel {

    private int id;
    private String nombre;
    private String marca;
    private int precio;
    private int cantidad;
    
}
