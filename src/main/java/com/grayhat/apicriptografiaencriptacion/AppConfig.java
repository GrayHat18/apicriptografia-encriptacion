package com.grayhat.apicriptografiaencriptacion;

import com.grayhat.apicriptografiaencriptacion.dto.EncryptedPasswordsDto;
import com.grayhat.apicriptografiaencriptacion.dto.EncryptionsDto;
import com.grayhat.apicriptografiaencriptacion.dto.TypeEncryptionDto;
import com.grayhat.apicriptografiaencriptacion.model.EncryptedPasswords;
import com.grayhat.apicriptografiaencriptacion.model.Encryptions;
import com.grayhat.apicriptografiaencriptacion.model.TypeEncryption;
import com.grayhat.apicriptografiaencriptacion.repository.IEncryptionsRepo;
import com.grayhat.apicriptografiaencriptacion.service.EncryptionStrategyService;
import com.grayhat.apicriptografiaencriptacion.service.EncryptionsService;
import org.springframework.context.annotation.Bean;

/**
 *
 * @author grayhat
 */
public class AppConfig {

    /*Bean para las clases de modelo con el patrón builder*/
    @Bean
    public TypeEncryption.Builder typeEncryptionBuilder() {
        return new TypeEncryption.Builder();
    }

    @Bean
    public Encryptions.Builder encryptionsBuilder() {
        return new Encryptions.Builder();
    }

    @Bean
    public EncryptedPasswords.Builder encryptedPasswordsBuilder() {
        return new EncryptedPasswords.Builder();
    }

    /*----------------------------------------------------*/

 /*Bean para las clases de DTO que tienen el patrón Builder*/
    @Bean
    public TypeEncryptionDto.Builder typeEncryptionDtoBuilder() {
        return new TypeEncryptionDto.Builder();
    }

    @Bean
    public EncryptionsDto.Builder encryptionsDtoBuilder() {
        return new EncryptionsDto.Builder();
    }

    @Bean
    public EncryptedPasswordsDto.Builder encryptedPasswordsDtoBuilder() {
        return new EncryptedPasswordsDto.Builder();
    }

    /*----------------------------------------------------*/
}
