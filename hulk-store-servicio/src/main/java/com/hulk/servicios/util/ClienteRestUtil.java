/**
* Copyright (C) 2021 - Todos los derechos reservados.
* TODO 1 Systems
*/
package com.hulk.servicios.util;

import java.lang.reflect.Type;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

/**
 * Fecha de creacion: 6 feb. 2021
 *
 * Clase de funciones utiles para la capa de servicio
 *
 * @author Hugo Riera Campos
 *
 */
public final class ClienteRestUtil {
	public ClienteRestUtil() {
	}

	/**
	 * Método utilitario que transforma una cadena Json a objeto
	 * 
	 * @param cadenaJson
	 * @param tipo
	 * @return
	 */
	public static Object transformarCadenaJsonAObjeto(final String cadenaJson, Type tipo) {
		Gson gson = new Gson();
		Type type = TypeToken.get(tipo).getType();
		return gson.fromJson(cadenaJson, type);
	}

}
