/**
 * ISBAN Mexico - (c) Banco Santander Central Hispano
 * Todos los derechos reservados
 *
 * BeanResultSamplesEjecutor.java
 *
 * Control de versiones:
 *
 * Version 	Date/Hour 				By 					Company 	Description
 * ------- 	------------------- 	----------------	-------- 	-----------------------------------------------------------------
 * 1.0 		15/01/2013 12:01:57 	"Marcos Coronado"	Isban Mex. 	Creacion de archivo
 */

package mx.isban.ejemplo.samples.beans;

import mx.isban.agave.commons.interfaces.EjecutorObjeto;

/**
 * The Class BeanResultSamplesEjecutor.
 */
public class ResultSamplesEjecutorBean implements EjecutorObjeto {

    /** The Constant serialVersionUID. */
    private static final long serialVersionUID = -1231960067352767421L;

    /** The string class. */
    private String stringClass = ResultSamplesEjecutorBean.class.getCanonicalName();

    /** The nombre campo. */
    private String nombreCampo;

    /** The cantidad. */
    private int cantidad;

    /**
     * Instantiates a new bean ejecutor.
     */
    public ResultSamplesEjecutorBean() {
        // Nada
    }

    /**
     * Instantiates a new bean ejecutor.
     * @param nombreCampo the nombre campo
     * @param cantidad the cantidad
     */
    public ResultSamplesEjecutorBean(final String nombreCampo, final int cantidad) {
        super();
        this.nombreCampo = nombreCampo;
        this.cantidad = cantidad;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String getStringClass() {
        return this.stringClass;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void setStringClass(final String stringClass) {
        this.stringClass = stringClass;
    }

    /**
     * Gets the nombre campo.
     * @return el nombreCampo
     */
    public String getNombreCampo() {
        return this.nombreCampo;
    }

    /**
     * Sets the nombre campo.
     * @param nombreCampo el nombreCampo a establecer
     */
    public void setNombreCampo(final String nombreCampo) {
        this.nombreCampo = nombreCampo;
    }

    /**
     * Gets the cantidad.
     * @return el cantidad
     */
    public int getCantidad() {
        return this.cantidad;
    }

    /**
     * Sets the cantidad.
     * @param cantidad el cantidad a establecer
     */
    public void setCantidad(final int cantidad) {
        this.cantidad = cantidad;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String toString() {
        StringBuffer cad = new StringBuffer();
        cad.append("BeanResultSamplesEjecutor [");
        cad.append("stringClass=").append(this.stringClass);
        cad.append(", nombreCampo=").append(this.nombreCampo);
        cad.append(", cantidad=").append(this.cantidad);
        cad.append("]");
        return cad.toString();
    }

}
