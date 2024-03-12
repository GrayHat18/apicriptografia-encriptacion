package com.grayhat.apicriptografiaencriptacion.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import java.sql.Timestamp;
import lombok.*;

/**
 *
 * @author grayhat
 */
@Getter
@Setter
@EqualsAndHashCode
@ToString
public class TypeEncryptionDto {

    @JsonProperty("idTypeEncryption")
    private int idTypeEncryption;

    @JsonProperty("descriptorName")
    private String descriptorName;

    @JsonProperty("descriptor")
    private String descriptor;

    @JsonProperty("createdAt")
    private Timestamp createdAt;

    @JsonProperty("updatedAt")
    private Timestamp updatedAt;

    @JsonProperty("enabled")
    private boolean enabled;

    public TypeEncryptionDto(Builder builder) {
        this.idTypeEncryption = builder.idTypeEncryption;
        this.descriptorName = builder.descriptorName;
        this.descriptor = builder.descriptor;
        this.createdAt = builder.createdAt;
        this.updatedAt = builder.updatedAt;
        this.enabled = builder.enabled;
    }

    public TypeEncryptionDto() {

    }

    public static class Builder {

        private int idTypeEncryption;
        private String descriptorName;
        private String descriptor;
        private Timestamp createdAt;
        private Timestamp updatedAt;
        private boolean enabled;

        public Builder idTypeEncryption(int idTypeEncryption) {
            this.idTypeEncryption = idTypeEncryption;
            return this;
        }

        public Builder descriptorName(String descriptorName) {
            this.descriptorName = descriptorName;
            return this;
        }

        public Builder descriptor(String descriptor) {
            this.descriptor = descriptor;
            return this;
        }

        public Builder createdAt(Timestamp createdAt) {
            this.createdAt = createdAt;
            return this;
        }

        public Builder updatedAt(Timestamp updatedAt) {
            this.updatedAt = updatedAt;
            return this;
        }

        public Builder enabled(boolean enabled) {
            this.enabled = enabled;
            return this;
        }

        public TypeEncryptionDto build() {
            return new TypeEncryptionDto(this);
        }
    }

}
