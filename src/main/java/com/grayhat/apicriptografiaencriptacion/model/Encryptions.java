package com.grayhat.apicriptografiaencriptacion.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import java.sql.Timestamp;

/**
 *
 * @author grayhat
 */
@Entity
@Table(name = "encryptions")
public class Encryptions {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_encryption")
    private int idEncryption;

    @Column(name = "encrypted_text")
    private String encryptedText;

    @Column(name = "created_at")
    private Timestamp createdAt;

    @Column(name = "updated_at")
    private Timestamp updatedAt;

    @Column(name = "enabled")
    private boolean enabled;

    public Encryptions() {

    }

    public Encryptions(Builder builder) {
        this.idEncryption = builder.idEncryption;
        this.encryptedText = builder.encryptedText;
        this.createdAt = builder.createdAt;
        this.updatedAt = builder.updatedAt;
        this.enabled = builder.enabled;
    }

    public static class Builder {

        private int idEncryption;
        private String encryptedText;
        private Timestamp createdAt;
        private Timestamp updatedAt;
        private boolean enabled;

        public Builder idEncryptions(int idEncryptions) {
            this.idEncryption = idEncryptions;
            return this;
        }

        public Builder encryptedText(String encryptedText) {
            this.encryptedText = encryptedText;
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

        public Encryptions build() {
            return new Encryptions(this);
        }

    }

    public int getIdEncryption() {
        return idEncryption;
    }

    public void setIdEncryption(int idEncryption) {
        this.idEncryption = idEncryption;
    }

    public String getEncryptedText() {
        return encryptedText;
    }

    public void setEncryptedText(String encryptedText) {
        this.encryptedText = encryptedText;
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

}
