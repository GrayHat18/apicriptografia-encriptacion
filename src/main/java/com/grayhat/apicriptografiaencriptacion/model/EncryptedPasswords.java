package com.grayhat.apicriptografiaencriptacion.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import java.sql.Timestamp;

/**
 *
 * @author grayhat
 */
@Entity
@Table(name = "encrypted_passwords")
public class EncryptedPasswords {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_encrypted_password")
    private int idEncryptedPassword;

    @ManyToOne
    @JoinColumn(name = "id_encryption")
    private Encryptions encryption;

    @ManyToOne
    @JoinColumn(name = "id_type_encryption")
    private TypeEncryption typeEncryptions;

    @Column(name = "created_at")
    private Timestamp createdAt;

    @Column(name = "updated_at")
    private Timestamp updatedAt;

    @Column(name = "enabled")
    private boolean enabled;

    public EncryptedPasswords() {

    }

    public EncryptedPasswords(Builder builder) {
        this.idEncryptedPassword = builder.idEncryptedPassword;
        this.encryption = builder.encryption;
        this.typeEncryptions = builder.typeEncryptions;
        this.createdAt = builder.createdAt;
        this.updatedAt = builder.updatedAt;
        this.enabled = builder.enabled;
    }

    public static class Builder {

        private int idEncryptedPassword;
        private Encryptions encryption;
        private TypeEncryption typeEncryptions;
        private Timestamp createdAt;
        private Timestamp updatedAt;
        private boolean enabled;

        public Builder idEncryptedPassword(int idEncryptedPassword) {
            this.idEncryptedPassword = idEncryptedPassword;
            return this;
        }

        public Builder idEncryption(Encryptions encryption) {
            this.encryption = encryption;
            return this;
        }

        public Builder typeEncryptions(TypeEncryption typeEncryptions) {
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

        public EncryptedPasswords build() {
            return new EncryptedPasswords(this);
        }
    }

    public int getIdEncryptedPassword() {
        return idEncryptedPassword;
    }

    public void setIdEncryptedPassword(int idEncryptedPassword) {
        this.idEncryptedPassword = idEncryptedPassword;
    }

    public Encryptions getIdEncryption() {
        return encryption;
    }

    public void setIdEncryption(Encryptions idEncryption) {
        this.encryption = idEncryption;
    }

    public TypeEncryption getIdTypeEncryptions() {
        return typeEncryptions;
    }

    public void setIdTypeEncryptions(TypeEncryption idTypeEncryptions) {
        this.typeEncryptions = idTypeEncryptions;
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
