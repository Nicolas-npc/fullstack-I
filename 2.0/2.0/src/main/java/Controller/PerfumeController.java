package Controller;
import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import Model.EmpleadoModel;
import Service.EmpleadoService;

@RestController
@RequestMapping("/Perfume")
public class PerfumeController {
    @Autowired
    private PerfumeService perfumeService;

    @GetMapping
    public List<PerfumeModel> listarPerfumes() {
        return perfumeService.getPerfumes();
    }

    @PostMapping
    public PerfumeModel agregarPerfume(@RequestBody PerfumeModel perfume) {
        return perfumeService.guardarPerfume(perfume);
    }

    @GetMapping("{id}")
    public PerfumeModel buscarPerfume(@PathVariable int id){
        return perfumeService.getPerfumeId(id);
    }

    @PutMapping("{id}")
    public PerfumeModel actualizarPerfume(@PathVariable int id, @RequestBody PerfumeModel perfume){
        return perfumeService.updatePerfume(perfume);
    }

    @DeleteMapping("{id}")
    public String eliminarPerfume(@PathVariable int id) {
        return perfumeService.deletePerfume(id);
    }
}
