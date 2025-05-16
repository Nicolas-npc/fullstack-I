package Repository;

import org.springframework.stereotype.Repository;
import java.util.ArrayList;
import java.util.List;
import Model.PerfumeModel;

@Repository
public class PerfumeRepository {

    private List<PerfumeModel> listaPerfume = new ArrayList<>();

    public List<PerfumeModel> obtenerPerfumes() {
        return listaPerfume;
    }

    public PerfumeModel buscarPorId(int id) {
        for (PerfumeModel perfume : listaPerfume) {
            if (perfume.getId() == id) {
                return perfume;
            }
        }
        return null;
    }

    public PerfumeModel buscarPorNombre(String nombre) {
        for (PerfumeModel perfume : listaPerfume) {
            if (perfume.getNombre().equals(nombre)) {
                return perfume;
            }
        }
        return null;
    }

    public PerfumeModel guardar(PerfumeModel per) {

        listaPerfume.add(per);
        return per;
    }

    public PerfumeModel actualizar(PerfumeModel per) {
        int id  = 0;
        int idPosicion = 0;

        for (int i = 0; i < listaPerfume.size(); i++) {
            if (listaPerfume.get(i).getId() == per.getId()) {
                id = per.getId();
                idPosicion = i;
            }
        }

        PerfumeModel perfume1 = new PerfumeModel();
        perfume1.setId(id);
        perfume1.setNombre(per.getNombre());
        perfume1.setMarca(per.getMarca());
        perfume1.setPrecio(per.getPrecio());
        perfume1.setCantidad(per.getCantidad());

        listaPerfume.set(idPosicion, perfume1);
        return perfume1;
    }

    public void eliminar(int id) {
        PerfumeModel perfume = buscarPorId(id);
        if (perfume != null) {
            listaPerfume.remove(perfume);
        }
        int idPosicion = 0;
        for (int i = 0; i < listaPerfume.size(); i++) {
            if (listaPerfume.get(i).getId() == id) {
                idPosicion = i;
                break;
            }
        }
        if (idPosicion > 0) {
            listaPerfume.remove(idPosicion);
        }
        listaPerfume.removeIf(x -> x.getId() == id);
    }








}
