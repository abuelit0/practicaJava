package mx.isban.ejemplo.samples.beans;

import java.io.Serializable;

public class PartenonMetadataBean implements Serializable {

    private static final long serialVersionUID = 1L;
    private String fieldName;
    private String dataType;
    private int length;
    private int decimals;
    private String cardinality;
    private String value;
    private boolean disabled;

    public String getFieldName() {
        return fieldName;
    }

    public void setFieldName(String fieldName) {
        this.fieldName = fieldName;
    }

    public String getDataType() {
        return dataType;
    }

    public void setDataType(String dataType) {
        this.dataType = dataType;
    }

    public int getLength() {
        return length;
    }

    public void setLength(int length) {
        this.length = length;
    }

    public int getDecimals() {
        return decimals;
    }

    public void setDecimals(int decimals) {
        this.decimals = decimals;
    }

    public String getCardinality() {
        return cardinality;
    }

    public void setCardinality(String cardinality) {
        this.cardinality = cardinality;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public boolean isDisabled() {
        return disabled;
    }

    public void setDisabled(boolean disabled) {
        this.disabled = disabled;
    }

    @Override
    public String toString() {
        return "PartenonMetadataBean [fieldName=" + fieldName + ", dataType=" + dataType + ", length=" + length + ", decimals=" + decimals + ", cardinality=" + cardinality + ", value=" + value + "]";
    }

}
