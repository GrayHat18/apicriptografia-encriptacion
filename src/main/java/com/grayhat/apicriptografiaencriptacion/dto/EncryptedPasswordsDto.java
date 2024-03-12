package com.grayhat.apicriptografiaencriptacion.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import java.sql.Timestamp;
import java.util.Objects;

/**
 *
 * @author grayhat
 */
public class EncryptedPasswordsDto {

    @JsonProperty("idEncryptedPassword")
    private int idEncryptedPassword;

    @JsonProperty("encryption")
    private EncryptionsDto encryption;

    @JsonProperty("typeEncryptions")
    private TypeEncryptionDto typeEncryptions;

    @JsonProperty("createdAt")
    private Timestamp createdAt;

    @JsonProperty("updatedAt")
    private Timestamp updatedAt;

    @JsonProperty("enabled")
    private boolean enabled;

    public EncryptedPasswordsDto(Builder builder) {
        this.idEncryptedPassword = builder.idEncryptedPassword;
        this.encryption = builder.encryption;
        this.typeEncryptions = builder.typeEncryptions;
        this.createdAt = builder.createdAt;
        this.updatedAt = builder.updatedAt;
        this.enabled = builder.enabled;
    }

    public static class Builder {

        private int idEncryptedPassword;
        private EncryptionsDto encryption;
        private TypeEncryptionDto typeEncryptions;
        private Timestamp createdAt;
        private Timestamp updatedAt;
        private boolean enabled;

        public Builder idEncryptedPassword(int idEncryptedPassword) {
            this.idEncryptedPassword = idEncryptedPassword;
            return this;
        }

        public Builder idEncryption(EncryptionsDto encryption) {
            this.encryption = encryption;
            return this;
        }

        public Builder typeEncryptions(TypeEncryptionDto typeEncryptions) {
            this.typeEncryptions = typeEncryptions;
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

        public EncryptedPasswordsDto build() {
            return new EncryptedPasswordsDto(this);
        }
    }

    public int getIdEncryptedPassword() {
        return idEncryptedPassword;
    }

    public void setIdEncryptedPassword(int idEncryptedPassword) {
        this.idEncryptedPassword = idEncryptedPassword;
    }

    public EncryptionsDto getEncryption() {
        return encryption;
    }

    public void setEncryption(EncryptionsDto encryption) {
        this.encryption = encryption;
    }

    public TypeEncryptionDto getTypeEncryptions() {
        return typeEncryptions;
    }

    public void setTypeEncryptions(TypeEncryptionDto typeEncryptions) {
        this.typeEncryptions = typeEncryptions;
    }

    public Timestamp getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Timestamp createdAt) {
        this.createdAt = createdAt;
    }

    public Timestamp getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(Timestamp updatedAt) {
        this.updatedAt = updatedAt;
    }

    public boolean isEnabled() {
        return enabled;
    }

    public void setEnabled(boolean enabled) {
        this.enabled = enabled;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 19 * hash + this.idEncryptedPassword;
        hash = 19 * hash + Objects.hashCode(this.encryption);
        hash = 19 * hash + Objects.hashCode(this.typeEncryptions);
        hash = 19 * hash + Objects.hashCode(this.createdAt);
        hash = 19 * hash + Objects.hashCode(this.updatedAt);
        hash = 19 * hash + (this.enabled ? 1 : 0);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final EncryptedPasswordsDto other = (EncryptedPasswordsDto) obj;
        if (this.idEncryptedPassword != other.idEncryptedPassword) {
            return false;
        }
        if (this.enabled != other.enabled) {
            return false;
        }
        if (!Objects.equals(this.encryption, other.encryption)) {
            return false;
        }
        if (!Objects.equals(this.typeEncryptions, other.typeEncryptions)) {
            return false;
        }
        if (!Objects.equals(this.createdAt, other.createdAt)) {
            return false;
        }
        return Objects.equals(this.updatedAt, other.updatedAt);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("EncryptedPasswordsDto{");
        sb.append("idEncryptedPassword=").append(idEncryptedPassword);
        sb.append(", encryption=").append(encryption);
        sb.append(", typeEncryptions=").append(typeEncryptions);
        sb.append(", createdAt=").append(createdAt);
        sb.append(", updatedAt=").append(updatedAt);
        sb.append(", enabled=").append(enabled);
        sb.append('}');
        return sb.toString();
    }
}
