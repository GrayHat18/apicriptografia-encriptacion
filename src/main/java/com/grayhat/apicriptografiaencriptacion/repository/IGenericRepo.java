package com.grayhat.apicriptografiaencriptacion.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.NoRepositoryBean;

/**
 * Interfaz para exponer los metodos crud a los servicios correspondientes
 *
 * @author grayhat
 * @param <T> Parametro de la clase que se va a implementar con los métodos crud
 * @param <ID> Parametros del id para utilizar en los metodos crud que lo
 * requieran
 */
@NoRepositoryBean
public interface IGenericRepo<T, ID> extends JpaRepository<T, Long> {

}
