/**
* Copyright (C) 2021 - Todos los derechos reservados.
* TODO 1 Systems
*/
package com.hulk.servicios.productos.test;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import org.junit.Before;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import com.hulk.modelo.Inventario;
import com.hulk.modelo.dao.InventarioDao;
import com.hulk.servicios.inventario.GestionInventarioServicio;

/**
 * Fecha de creacion: 6 feb. 2021
 *
 * @author Hugo Riera Campos
 *
 */
class GestionInventarioServicioTest {
	public GestionInventarioServicioTest() {
	}

	@InjectMocks
	private GestionInventarioServicio gestionInventarioServicio;

	@Mock
	InventarioDao inventarioDaoMock;

	@Before
	public void inicializar() {
		MockitoAnnotations.openMocks(this);
	}

	/**
	 * Test method for
	 * {@link com.hulk.servicios.inventario.GestionInventarioServicio#actualizarInventario(com.hulk.modelo.Inventario)}.
	 */

	@Test
	public void deberiaActualizarInventario() {
		Inventario inventario = cargarInformacionTestInventario();
		gestionInventarioServicio.actualizarInventario(inventario);
		verify(inventarioDaoMock).actualizarInventario(inventario);
	}

	/**
	 * Test method for
	 * {@link com.hulk.servicios.inventario.GestionInventarioServicio#consultarStockProducto(java.lang.Integer)}.
	 */

	@Test
	public void deberiaConsultarStockProducto() {
		Inventario inventario = cargarInformacionTestInventario();
		when(inventarioDaoMock.consultarStockProducto(any(Integer.class))).thenReturn(inventario);
		gestionInventarioServicio.consultarStockProducto(any(Integer.class));
		verify(inventarioDaoMock, times(1)).consultarStockProducto(any(Integer.class));
	}

	/**
	 * Metódo que carga la información del inventario
	 * 
	 * @return
	 */
	private Inventario cargarInformacionTestInventario() {

		Inventario inventario = new Inventario();
		inventario.setId(1);
		inventario.setStock(20);
		return inventario;
	}
}
