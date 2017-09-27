/**
 * ISBAN Mexico - (c) Banco Santander Central Hispano
 * Todos los derechos reservados
 *
 * DAOCargoEjecutor.java
 *
 * Control de versiones:
 *
 * Version 	Date/Hour 				By 					Company 	Description
 * ------- 	------------------- 	----------------	-------- 	-----------------------------------------------------------------
 * 1.0 		15/01/2013 11:57:32 	"Marcos Coronado"	Isban Mex. 	Creacion de archivo
 */

package mx.isban.ejemplo.samples.dao.impl;

import mx.isban.agave.commons.architech.Architech;
import mx.isban.agave.commons.beans.MessageBean;
import mx.isban.agave.commons.interfaces.EjecutorDAO;

/**
 * The Class DAOCargoEjecutor.
 */
public class DAOSamplesEjecutor extends Architech implements EjecutorDAO {

    /** The Constant serialVersionUID. */
    private static final long serialVersionUID = 5675028403724680973L;

    /**
     * {@inheritDoc}
     */
    @Override
    public void ejecuta(final MessageBean msj) {
        this.setLoggingBean(msj.getLogginBean());
        this.setNameComponent("cmpInterceptoresImplCargos");

        this.info("Iniciando ejecucion del dao ejecutor");
        this.info("Mostrando informacion del objeto ejecutor" + msj.getObjetoEjecutor().toString());
        this.info("Terminando ejecucion del dao ejecutor");
    }

}
