package com.grayhat.apicriptografiaencriptacion.controller;

import com.grayhat.apicriptografiaencriptacion.dto.TypeEncryptionDto;
import com.grayhat.apicriptografiaencriptacion.model.TypeEncryption;
import com.grayhat.apicriptografiaencriptacion.service.TypeEncryptionService;
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
@RequestMapping("/typeEncryption")
public class TypeEncryptionController {

    private final TypeEncryptionService typeEncryptionService;

    @Autowired
    public TypeEncryptionController(TypeEncryptionService typeEncryptionService) {
        this.typeEncryptionService = typeEncryptionService;
    }

    @GetMapping("/listTypeEncryption")
    public ResponseEntity<List<TypeEncryptionDto>> listTypeEncryption() {
        try {
            //Recuperamos los tipos de encriptación desde la base de datos
            Iterable<TypeEncryption> typeEncryptions = typeEncryptionService.findAllTypeEncryptions();

            //Convertimos los tipos de encriptación de entidad modelo a DTO
            List<TypeEncryptionDto> typeEncryptionDto = new ArrayList<>();

            for (TypeEncryption type : typeEncryptions) {
                TypeEncryptionDto typeDto = Mapper.mapEntityToDto(type, TypeEncryptionDto.class);
                typeEncryptionDto.add(typeDto);
            }

            return ResponseEntity.ok(typeEncryptionDto);
        } catch (IllegalAccessException | InstantiationException e) {
            e.printStackTrace(System.err);
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    @PostMapping("/register")
    public ResponseEntity<String> registerTypeEncryption(@RequestBody TypeEncryptionDto typeEncryptionDto) {
        try {
            TypeEncryptionDto typeEncryptionsDto = new TypeEncryptionDto.Builder()
                    .descriptorName(typeEncryptionDto.getDescriptorName())
                    .descriptor(typeEncryptionDto.getDescriptor())
                    .enabled(true)
                    .build();

            TypeEncryption typeEncryption = Mapper.mapDtoToEntity(typeEncryptionsDto, TypeEncryption.class);

            TypeEncryption savedTypeEncryption = typeEncryptionService.saveTypeEncryption(typeEncryption);

            if (savedTypeEncryption != null) {
                return ResponseEntity.ok("Tipo de Encriptación Registrado Correctamente");
            } else {
                return ResponseEntity.badRequest().body("Datos del Tipo de Encriptación Inválidos");
            }
        } catch (IllegalAccessException | InstantiationException e) {
            e.printStackTrace(System.err);
            return ResponseEntity.badRequest().body("Error al Registrar un Tipo de Encriptación");
        }
    }
}
