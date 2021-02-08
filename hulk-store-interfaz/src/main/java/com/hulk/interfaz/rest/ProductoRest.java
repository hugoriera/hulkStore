/**
* Copyright (C) 2021 - Todos los derechos reservados.
* TODO 1 Systems
*/
package com.hulk.interfaz.rest;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.hulk.modelo.Producto;
import com.hulk.servicios.productos.GestionProductoServicio;

/**
 * Fecha de creacion: 7 feb. 2021
 *
 * @author Hugo Riera Campos
 *
 */
@Stateless
@Path("/")
@Produces("application/json")
@Consumes("application/json")
public class ProductoRest implements Serializable {

	private static final long serialVersionUID = -657140082018899206L;

	@Inject
	private GestionProductoServicio srvGestionProductoServicio;

	@GET
	@Path("/consultaProductos")
	@Produces(MediaType.APPLICATION_JSON)
	public Response consultarProductos() {

		List<Producto> listaProductos = srvGestionProductoServicio.obtenerProductos();

		if (null != listaProductos) {
			return Response.status(Response.Status.OK).entity(listaProductos).type(MediaType.APPLICATION_JSON).build();
		} else {
			return Response.status(Response.Status.OK).entity(new ArrayList<>()).type(MediaType.APPLICATION_JSON)
					.build();
		}
	}
}
