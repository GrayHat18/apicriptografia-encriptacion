package com.grayhat.apicriptografiaencriptacion.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import java.sql.Timestamp;
import lombok.*;

/**
 *
 * @author grayhat
 */
@Entity
@Table(name = "type_encryption")
@Setter
@Getter
@EqualsAndHashCode
public class TypeEncryption {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_type_encryption")
    private int idTypeEncryption;

    @Column(name = "descriptor_name")
    private String descriptorName;

    @Column(name = "description")
    private String descriptor;

    @Column(name = "created_at")
    private Timestamp createdAt;

    @Column(name = "updated_at")
    private Timestamp updatedAt;

    @Column(name = "enabled")
    private boolean enabled;

    public TypeEncryption() {

    }

    public TypeEncryption(Builder builder) {
        this.idTypeEncryption = builder.idTypeEncryption;
        this.descriptorName = builder.descriptorName;
        this.descriptor = builder.descriptor;
        this.createdAt = builder.createdAt;
        this.updatedAt = builder.updatedAt;
        this.enabled = builder.enabled;
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

        public TypeEncryption build() {
            return new TypeEncryption(this);
        }
    }

}
