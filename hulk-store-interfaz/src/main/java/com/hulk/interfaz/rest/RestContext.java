/**
* Copyright (C) 2021 - Todos los derechos reservados.
* TODO 1 Systems
*/
package com.hulk.interfaz.rest;

import javax.ejb.Stateless;
import javax.ws.rs.ApplicationPath;
import javax.ws.rs.core.Application;

/**
 * Fecha de creacion: 7 feb. 2021
 *
 * @author Hugo Riera Campos
 *
 */
@Stateless
@ApplicationPath("/rest")
public class RestContext extends Application {
	public RestContext() {
		super();
	}
}
