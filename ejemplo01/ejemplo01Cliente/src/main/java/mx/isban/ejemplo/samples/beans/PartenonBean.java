package mx.isban.ejemplo.samples.beans;

import java.util.List;
import java.util.Map;

import mx.isban.agave.dataaccess.ResponseMessageDTO;

public class PartenonBean extends ResponseMessageDTO {

    /**
     * 
     */
    private static final long serialVersionUID = 1L;
    private String trxNombre;
    private String trxOperacion;
    private String trxVersion;
    private boolean trxVersionDisabled;
    private List<PartenonMetadataBean> listaMetadataSend;
    private List<PartenonMetadataBean> listaMetadataRcve;
    private List<List<String>> listaResultados;
    private Map<String, String> mapaScalars;

    public String getTrxNombre() {
        return trxNombre;
    }

    public void setTrxNombre(String trxNombre) {
        this.trxNombre = trxNombre;
    }

    public String getTrxOperacion() {
        return trxOperacion;
    }

    public void setTrxOperacion(String trxOperacion) {
        this.trxOperacion = trxOperacion;
    }

    public String getTrxVersion() {
        return trxVersion;
    }

    public void setTrxVersion(String trxVersion) {
        this.trxVersion = trxVersion;
    }

    public boolean isTrxVersionDisabled() {
        return trxVersionDisabled;
    }

    public void setTrxVersionDisabled(boolean trxVersionDisabled) {
        this.trxVersionDisabled = trxVersionDisabled;
    }

    public List<PartenonMetadataBean> getListaMetadataSend() {
        return listaMetadataSend;
    }

    public void setListaMetadataSend(List<PartenonMetadataBean> listaMetadataSend) {
        this.listaMetadataSend = listaMetadataSend;
    }

    public List<PartenonMetadataBean> getListaMetadataRcve() {
        return listaMetadataRcve;
    }

    public void setListaMetadataRcve(List<PartenonMetadataBean> listaMetadataRcve) {
        this.listaMetadataRcve = listaMetadataRcve;
    }

    public List<List<String>> getListaResultados() {
        return listaResultados;
    }

    public void setListaResultados(List<List<String>> listaResultados) {
        this.listaResultados = listaResultados;
    }

    public Map<String, String> getMapaScalars() {
        return mapaScalars;
    }

    public void setMapaScalars(Map<String, String> mapaScalars) {
        this.mapaScalars = mapaScalars;
    }

    @Override
    public String getResultToJSONString() {
        // TODO Auto-generated method stub
        return null;
    }

}
