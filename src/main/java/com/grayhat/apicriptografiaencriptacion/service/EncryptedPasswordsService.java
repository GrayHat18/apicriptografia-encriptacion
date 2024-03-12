package com.grayhat.apicriptografiaencriptacion.service;

import com.grayhat.apicriptografiaencriptacion.model.EncryptedPasswords;
import com.grayhat.apicriptografiaencriptacion.repository.IEncryptedPasswordsRepo;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author grayhat
 */
@Service
public class EncryptedPasswordsService {

    private final IEncryptedPasswordsRepo encryptedPasswords;

    @Autowired
    public EncryptedPasswordsService(IEncryptedPasswordsRepo encryptedPasswords) {
        this.encryptedPasswords = encryptedPasswords;
    }

    public List<EncryptedPasswords> findAllEncryptedPasswords() {
        return encryptedPasswords.findAll();
    }

    public EncryptedPasswords saveEncryptedPassword(EncryptedPasswords encryptedPassword) {
        if (validEncryptedPasswordsData(encryptedPassword)) {
            return this.encryptedPasswords.save(encryptedPassword);
        }
        return null;
    }

    private boolean validEncryptedPasswordsData(EncryptedPasswords encryptedPasswords) {
        return !(encryptedPasswords.getIdEncryption() == null
                || encryptedPasswords.getIdTypeEncryptions() == null
                || encryptedPasswords.isEnabled());
    }

}
