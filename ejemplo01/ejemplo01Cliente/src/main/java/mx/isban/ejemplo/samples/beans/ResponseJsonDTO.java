package mx.isban.ejemplo.samples.beans;

import javax.resource.cci.ResourceWarning;

import com.isban.mfconnectors.jca.trxop.cci.RAMappedRecord;

public class ResponseJsonDTO {
    private RAMappedRecord raMappedRecord;
    private ResourceWarning resourceWarning;
    private String metadata;
    private String version;

    public RAMappedRecord getRaMappedRecord() {
        return raMappedRecord;
    }

    public void setRaMappedRecord(RAMappedRecord raMappedRecord) {
        this.raMappedRecord = raMappedRecord;
    }

    public ResourceWarning getResourceWarning() {
        return resourceWarning;
    }

    public void setResourceWarning(ResourceWarning resourceWarning) {
        this.resourceWarning = resourceWarning;
    }

    public String getMetadata() {
        return metadata;
    }

    public void setMetadata(String metadata) {
        this.metadata = metadata;
    }

    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
    }

}
