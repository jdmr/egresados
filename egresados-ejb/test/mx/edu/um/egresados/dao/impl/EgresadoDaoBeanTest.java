/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package mx.edu.um.egresados.dao.impl;

import java.util.Date;
import java.util.List;
import javax.ejb.embeddable.EJBContainer;
import javax.naming.Context;
import javax.naming.NamingException;
import mx.edu.um.egresados.dao.EgresadoDao;
import mx.edu.um.egresados.modelo.Egresado;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author jdmr
 */
public class EgresadoDaoBeanTest {
    private static EJBContainer container;
    private static Context context;
    private EgresadoDao egresadoDao;
    private Long egresadoId;

    public EgresadoDaoBeanTest() {
    }

    @BeforeClass
    public static void setUpClass() throws Exception {
        container = EJBContainer.createEJBContainer();
        context = container.getContext();
    }

    @AfterClass
    public static void tearDownClass() throws Exception {
        context.close();
        container.close();
    }

    @Before
    public void setUp() throws NamingException {
        egresadoDao = (EgresadoDao) context.lookup("java:global/classes/EgresadoDao");
        Egresado egresado = new Egresado();
        egresado.setMatricula("00000000");
        egresado.setNombre("Nombre");
        egresado.setApellidoPaterno("ApellidoPaterno");
        egresado.setApellidoMaterno("ApellidoMaterno");
        egresado.setEsHombre(true);
        egresado.setEstadoCivil("SOLTERO");
        egresado.setFechaNacimiento(new Date());
        egresado.setNacionalidad("MEXICANA");
        egresado.setReligion("ASD");
        egresado = egresadoDao.guarda(egresado);
        egresadoId = egresado.getId();
    }

    @After
    public void tearDown() {
        egresadoDao.elimina(egresadoId);
    }

    /**
     * Test of lista method, of class EgresadoDaoBean.
     */
    @Test
    public void testLista() throws Exception {
        System.out.println("lista");
        List<Egresado> egresados = egresadoDao.lista();
        assertNotNull(egresados);
        assertTrue(egresados.size()>=1);
    }

    /**
     * Test of obtiene method, of class EgresadoDaoBean.
     */
    @Test
    public void testObtiene() throws Exception {
        System.out.println("obtiene");
        Egresado egresado = egresadoDao.obtiene(egresadoId);
        assertNotNull(egresado);
        assertEquals("Nombre",egresado.getNombre());
    }

    /**
     * Test of guarda method, of class EgresadoDaoBean.
     */
    @Test
    public void testGuarda() throws Exception {
        System.out.println("guarda");
        Egresado egresado = egresadoDao.obtiene(egresadoId);
        assertNotNull(egresado);
        assertEquals("Nombre",egresado.getNombre());
        egresado.setNombre("TEST");
        egresadoDao.guarda(egresado);
        Egresado x = egresadoDao.obtiene(egresadoId);
        assertNotNull(x);
        assertEquals("TEST",x.getNombre());
    }

}