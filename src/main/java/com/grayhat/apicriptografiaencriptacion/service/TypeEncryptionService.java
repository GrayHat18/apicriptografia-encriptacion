package com.grayhat.apicriptografiaencriptacion.service;

import com.grayhat.apicriptografiaencriptacion.model.TypeEncryption;
import com.grayhat.apicriptografiaencriptacion.repository.ITypeEncryptionRepo;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author grayhat
 */
@Service
public class TypeEncryptionService {

    private final ITypeEncryptionRepo typeEncryption;

    @Autowired
    public TypeEncryptionService(ITypeEncryptionRepo typeEncryption) {
        this.typeEncryption = typeEncryption;
    }

    //Servicio para obtener todos los tipos de encriptación en base de datos
    public List<TypeEncryption> findAllTypeEncryptions() {
        return typeEncryption.findAll();
    }

    public TypeEncryption saveTypeEncryption(TypeEncryption typeEncryption) {
        if (validTypeEncryptionData(typeEncryption)) {
            return this.typeEncryption.save(typeEncryption);
        }
        return null;
    }

    private boolean validTypeEncryptionData(TypeEncryption typeEncryption) {
        return !(typeEncryption.getDescriptorName() == null || typeEncryption.getDescriptorName().isEmpty())
                && !(typeEncryption.getDescriptor() == null || typeEncryption.getDescriptor().isEmpty())
                && typeEncryption.isEnabled();
    }
}
