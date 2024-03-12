package com.grayhat.apicriptografiaencriptacion.service;

import com.grayhat.apicriptografiaencriptacion.model.EncryptedPasswords;
import com.grayhat.apicriptografiaencriptacion.model.Encryptions;
import com.grayhat.apicriptografiaencriptacion.model.TypeEncryption;
import com.grayhat.apicriptografiaencriptacion.repository.IEncryptedPasswordsRepo;
import com.grayhat.apicriptografiaencriptacion.repository.IEncryptionsRepo;
import com.grayhat.apicriptografiaencriptacion.service.impl.CesarEncryptionStrategy;
import com.grayhat.apicriptografiaencriptacion.service.impl.PlayFairEncryptionStrategy;
import com.grayhat.apicriptografiaencriptacion.service.impl.PolibioEncryptionStrategy;
import com.grayhat.apicriptografiaencriptacion.service.impl.XOREncryptionStrategy;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author grayhat
 */
@Service
@Transactional
public class EncryptionsService {

    private final IEncryptionsRepo encryptionsRepo;
    private IEncryptionStrategy encryptionStrategy;
    private final IEncryptedPasswordsRepo encryptedPasswords;

    @Autowired
    public EncryptionsService(IEncryptionsRepo encryptionsRepo, IEncryptedPasswordsRepo encryptedPasswords) {
        this.encryptionsRepo = encryptionsRepo;
        this.encryptedPasswords = encryptedPasswords;
    }

    public void setEncryptionStrategy(IEncryptionStrategy encryptionStrategy) {
        this.encryptionStrategy = encryptionStrategy;
    }

    public List<Encryptions> findAllEncryptions() {
        return encryptionsRepo.findAll();
    }

    public Encryptions saveEncryptions(Encryptions encryptions, TypeEncryption typeEncryption) {
        if (validEncryptionsData(encryptions)) {
            if (validTypeEncryptionData(typeEncryption)) {
                encryptionStrategy = determineStrategy(typeEncryption);

                encryptions.setEncryptedText(encryptionStrategy.encrypt(encryptions.getEncryptedText()));

                encryptions = encryptionsRepo.save(encryptions);

                EncryptedPasswords encryptedPasswordsRelation = new EncryptedPasswords.Builder()
                        .idEncryption(encryptions)
                        .typeEncryptions(typeEncryption)
                        .build();

                this.encryptedPasswords.save(encryptedPasswordsRelation);

                return encryptions;
            } else {
                return null;
            }
        } else {
            return null;
        }
    }

    private boolean validEncryptionsData(Encryptions encryptions) {
        return !(encryptions.getEncryptedText() == null || encryptions.isEnabled());
    }

    private boolean validTypeEncryptionData(TypeEncryption typeEncryption) {
        return !(typeEncryption.getDescriptor() == null || typeEncryption.isEnabled());
    }

    private IEncryptionStrategy determineStrategy(TypeEncryption typeEncryption) {
        switch (typeEncryption.getDescriptorName()) {
            case "Cifrado César" -> {
                return new CesarEncryptionStrategy();
            }
            case "Cifrado PlayFair" -> {
                return new PlayFairEncryptionStrategy();
            }
            case "Cifrado Polibio" -> {
                return new PolibioEncryptionStrategy();
            }
            case "Cifrado XOR" -> {
                return new XOREncryptionStrategy();
            }
            default ->
                throw new IllegalArgumentException("Tipo de Encriptación no soportado: " + typeEncryption.getDescriptorName());
        }
    }

}
