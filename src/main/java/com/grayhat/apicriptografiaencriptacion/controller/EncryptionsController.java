package com.grayhat.apicriptografiaencriptacion.controller;

import com.grayhat.apicriptografiaencriptacion.dto.EncryptionsDto;
import com.grayhat.apicriptografiaencriptacion.dto.TypeEncryptionDto;
import com.grayhat.apicriptografiaencriptacion.model.Encryptions;
import com.grayhat.apicriptografiaencriptacion.model.TypeEncryption;
import com.grayhat.apicriptografiaencriptacion.service.EncryptionsService;
import com.grayhat.apicriptografiaencriptacion.util.Mapper;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author grayhat
 */
@RestController
@RequestMapping("/encryptions")
public class EncryptionsController {

    private final EncryptionsService encryptionsService;

    @Autowired
    public EncryptionsController(EncryptionsService encryptionsService) {
        this.encryptionsService = encryptionsService;
    }

    @GetMapping("/listEncryptions")
    public ResponseEntity<List<EncryptionsDto>> listEncryptions() {
        try {
            List<Encryptions> encryptions = encryptionsService.findAllEncryptions();

            List<EncryptionsDto> encryptionsDto = new ArrayList<>();

            for (Encryptions encryp : encryptions) {
                EncryptionsDto encrypDto = Mapper.mapEntityToDto(encryp, EncryptionsDto.class);
                encryptionsDto.add(encrypDto);
            }

            return ResponseEntity.ok(encryptionsDto);

        } catch (IllegalAccessException | InstantiationException e) {
            e.printStackTrace(System.err);
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    @PostMapping("/register")
    public ResponseEntity<String> registerEncryptions(@RequestBody EncryptionsDto encryptionsDto) {
        try {
            TypeEncryptionDto typeDto = new TypeEncryptionDto.Builder()
                    .idTypeEncryption(encryptionsDto.getTypeEncryption().getIdTypeEncryption())
                    .descriptorName(encryptionsDto.getTypeEncryption().getDescriptorName())
                    .build();
            EncryptionsDto encrypDto = new EncryptionsDto.Builder()
                    .encryptedText(encryptionsDto.getEncryptedText())
                    .build();

            Encryptions encryption = Mapper.mapDtoToEntity(encrypDto, Encryptions.class);
            TypeEncryption typeEncryp = Mapper.mapDtoToEntity(typeDto, TypeEncryption.class);

            Encryptions savedEncryption = encryptionsService.saveEncryptions(encryption, typeEncryp);

            if (savedEncryption != null) {
                return ResponseEntity.ok("Encriptación Realizada Correctamente basada en Algoritmo " + encryptionsDto.getTypeEncryption().getDescriptorName());
            } else {
                return ResponseEntity.badRequest().body("Datos de la Encriptación son Inválidos");
            }
        } catch (IllegalAccessException | InstantiationException e) {
            e.printStackTrace(System.err);
            return ResponseEntity.badRequest().body("Error al Registrar una nueva encriptación");
        }
    }

}
