package mx.edu.um.egresados.dao;

import java.util.List;
import javax.ejb.Local;
import mx.edu.um.egresados.modelo.Egresado;

/**
 *
 * @author jdmr
 */
@Local
public interface EgresadoDao {

    /**
     * Obtiene lista de egresados
     * @return
     */
    public List<Egresado> lista();

    /**
     * Obtiene el usuario con la llave
     * @param id
     * @return
     */
    public Egresado obtiene(Long id);

    /**
     * Crea o actualiza el usuario
     * @param egresado
     * @return Egresado Regresa el egresado actualizado
     */
    public Egresado guarda(Egresado egresado);

    /**
     * Elimina el usuario
     * @param id
     */
    public void elimina(Long id);
}
