/**
* Copyright (C) 2021 - Todos los derechos reservados.
* TODO 1 Systems
*/
package com.hulk.web.utils;

import org.primefaces.PrimeFaces;

/**
 * Fecha de creacion: 7 feb. 2021
 *
 * @author Hugo Riera Campos
 *
 */
public class JsfUtils {
	public JsfUtils() {
	}

	/**
	 * Método que muestra o oculat dialogos
	 * 
	 * @param dialogo
	 * @param state
	 */
	public static void mostrarOcutarDialogo(String dialogo, Boolean state) {
		StringBuilder script = new StringBuilder();
		script.append("PF('").append(dialogo).append("').");
		script.append(state ? "show()" : "hide()");
		JsfUtils.ejecutarJavaScriptDeVista(script.toString());
	}

	public static void ejecutarJavaScriptDeVista(String script) {
		PrimeFaces.current().executeScript(script);
	}

}
