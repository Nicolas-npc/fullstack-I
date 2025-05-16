package Service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import Model.PerfumeModel;
import Repository.PerfumeRepository;

@Service
public class PerfumeService {
    @Autowired
    private PerfumeRepository perfumeRespository;

    public List<PerfumeModel> getPerfumes() {
        return perfumeRespository.obtenerPerfumes();
    }

    public PerfumeModel guardarPerfume(PerfumeModel perfume) {
        return perfumeRespository.guardar(perfume);
    }

    public PerfumeModel getPerfumeId(int id) {
        return perfumeRespository.buscarPorId(id);
    }

    public PerfumeModel updatePerfume(PerfumeModel perfume) {
        return perfumeRespository.actualizar(perfume);
    }

    public String deletePerfume(int id) {
        perfumeRespository.eliminar(id);
        return "producto eliminado";
    }
}
