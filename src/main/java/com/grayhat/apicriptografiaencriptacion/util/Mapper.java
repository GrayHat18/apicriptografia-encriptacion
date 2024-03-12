package com.grayhat.apicriptografiaencriptacion.util;

import com.grayhat.apicriptografiaencriptacion.dto.EncryptionsDto;
import com.grayhat.apicriptografiaencriptacion.dto.TypeEncryptionDto;
import com.grayhat.apicriptografiaencriptacion.model.Encryptions;
import com.grayhat.apicriptografiaencriptacion.model.TypeEncryption;
import java.lang.reflect.Field;

/**
 * Clase para realizar Mapeos entre clases de Entidad a clases DTO,
 * considerandos aspectos de atributos exactamente iguales entre estas o
 * atributos con diferencias, por ejemplo atributos embebidos de otra clase
 * relacionada
 *
 * @author grayhat
 */
public class Mapper {

    /**
     *
     * @param <T> Clase ENTITY
     * @param <R> Clase DTO
     * @param entity nombre de la clase entidad
     * @param dtoClass clase de DTO a la cual se hará el mapeo
     * @return dto objeto de clase DTO
     * @throws InstantiationException
     * @throws IllegalAccessException
     */
    public static <T, R> R mapEntityToDto(T entity, Class<R> dtoClass) throws InstantiationException, IllegalAccessException {
        R dto = dtoClass.newInstance();

        for (Field dtoField : dtoClass.getDeclaredFields()) {
            dtoField.setAccessible(true);
            String fieldName = dtoField.getName();
            Field entityField;

            try {
                entityField = entity.getClass().getDeclaredField(fieldName);
                entityField.setAccessible(true);
            } catch (NoSuchFieldException | SecurityException e) {
                continue;
            }

            Object value = entityField.get(entity);
            if (value instanceof Encryptions && dtoField.getType().equals(EncryptionsDto.class)) {
                Encryptions encryp = (Encryptions) value;
                EncryptionsDto encrypDto = convertEncryptionsToDto(encryp);
                dtoField.set(dto, encrypDto);
            } else if (value instanceof TypeEncryption && dtoField.getType().equals(TypeEncryptionDto.class)) {
                TypeEncryption typeEncryp = (TypeEncryption) value;
                TypeEncryptionDto typeEncrypDto = convertTypeEncryptionToDto(typeEncryp);
                dtoField.set(dto, typeEncrypDto);
            } else {
                //En el caso de que sean exactamente iguales, se utilizar el valor value propiamente tal
                dtoField.set(dto, value);
            }

        }

        return dto;
    }

    /**
     * Metodo para Mapear una clase DTO a una clase Entidad
     *
     * @param <T> clase ENTITY
     * @param <R> clase DTO
     * @param dto objeto de la clase DTO
     * @param entityClass clase de entidad a la cual se hará el mapeo
     * @return entity objeto de clase ENTITY
     * @throws InstantiationException
     * @throws IllegalAccessException
     */
    public static <T, R> T mapDtoToEntity(R dto, Class<T> entityClass) throws InstantiationException, IllegalAccessException {
        T entity = entityClass.newInstance();

        for (Field entityField : entityClass.getDeclaredFields()) {
            entityField.setAccessible(true);
            String fieldName = entityField.getName();
            Field dtoField;

            try {
                dtoField = dto.getClass().getDeclaredField(fieldName);
                dtoField.setAccessible(true);
            } catch (NoSuchFieldException | SecurityException e) {
                continue;
            }

            Object value = dtoField.get(dto);

            if (value instanceof TypeEncryptionDto && entityField.getType().equals(TypeEncryption.class)) {
                TypeEncryptionDto typeEncryptionDto = (TypeEncryptionDto) value;
                TypeEncryption typeEncryption = convertTypeEncryptionDtoToEntity(typeEncryptionDto);
                entityField.set(entity, typeEncryption);
            } else if (value instanceof EncryptionsDto && entityField.getType().equals(Encryptions.class)) {
                EncryptionsDto encrypDto = (EncryptionsDto) value;
                Encryptions encryp = convertEncryptionsDtoToEntity(encrypDto);
                entityField.set(entity, encryp);
            } else {
                //En el caso de que sena exactamente iguales, se utiliza el valor value propiamente tal
                entityField.set(entity, value);
            }
        }

        return entity;
    }

    private static TypeEncryptionDto convertTypeEncryptionToDto(TypeEncryption typeEncryption) {
        TypeEncryptionDto typeEncryptionDto = new TypeEncryptionDto.Builder()
                .idTypeEncryption(typeEncryption.getIdTypeEncryption())
                .descriptorName(typeEncryption.getDescriptorName())
                .descriptor(typeEncryption.getDescriptor())
                .createdAt(typeEncryption.getCreatedAt())
                .updatedAt(typeEncryption.getUpdatedAt())
                .enabled(typeEncryption.isEnabled())
                .build();

        return typeEncryptionDto;
    }

    private static TypeEncryption convertTypeEncryptionDtoToEntity(TypeEncryptionDto typeEncryptionDto) {
        TypeEncryption typeEncryption = new TypeEncryption.Builder()
                .idTypeEncryption(typeEncryptionDto.getIdTypeEncryption())
                .descriptorName(typeEncryptionDto.getDescriptorName())
                .descriptor(typeEncryptionDto.getDescriptor())
                .createdAt(typeEncryptionDto.getCreatedAt())
                .updatedAt(typeEncryptionDto.getUpdatedAt())
                .enabled(typeEncryptionDto.isEnabled())
                .build();

        return typeEncryption;
    }

    private static EncryptionsDto convertEncryptionsToDto(Encryptions encryptions) {
        EncryptionsDto encrypDto = new EncryptionsDto.Builder()
                .idEncryptions(encryptions.getIdEncryption())
                .encryptedText(encryptions.getEncryptedText())
                .createdAt(encryptions.getCreatedAt())
                .updatedAt(encryptions.getUpdatedAt())
                .enabled(encryptions.isEnabled())
                .build();

        return encrypDto;
    }

    private static Encryptions convertEncryptionsDtoToEntity(EncryptionsDto encryptionsDto) {
        Encryptions encryp = new Encryptions.Builder()
                .idEncryptions(encryptionsDto.getIdEncryption())
                .encryptedText(encryptionsDto.getEncryptedText())
                .createdAt(encryptionsDto.getCreatedAt())
                .updatedAt(encryptionsDto.getUpdatedAt())
                .enabled(encryptionsDto.isEnabled())
                .build();

        return encryp;
    }
}
