package com.grayhat.apicriptografiaencriptacion.service.impl;

import com.grayhat.apicriptografiaencriptacion.service.IEncryptionStrategy;

/**
 *
 * @author grayhat
 */
public class CesarEncryptionStrategy implements IEncryptionStrategy {

    @Override
    public String encrypt(String input) {
        //Texto que saldrá cifrado
        String cipher = "";

        //Posiciones a adelantar
        int forwardPositions = 3;

        //Convertiamos el mensaje en un array de caracteres
        char[] lethers = input.toCharArray();

        //Vamos por cada caracter sumandole 3
        /*De esta manera obtenemos el código ASCII del caracter (int) lethers[i], luego a ese número le sumamos 3, 
        ((int) lethers[i]) + forwardPositions) <-- así quedaría
        y luego convertimos ese número en la letra a la que hace referencia en el código ASCII, solo casteando el numero a char
         */
        for (int i = 0; i < lethers.length; i++) {
            cipher += (char) (((int) lethers[i]) + forwardPositions);
        }

        return cipher; //retornamos el texto resultado ya cifrado
    }

}
