/**
* Copyright (C) 2021 - Todos los derechos reservados.
* TODO 1 Systems
*/
package com.hulk.servicios.productos.test;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

import java.io.IOException;
import java.util.List;

import org.apache.commons.io.IOUtils;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import com.hulk.modelo.Producto;
import com.hulk.modelo.dao.ProductoDao;
import com.hulk.servicios.dtos.ProductoDto;
import com.hulk.servicios.productos.GestionProductoServicio;
import com.hulk.servicios.util.ClienteRestUtil;

/**
 * Fecha de creacion: 6 feb. 2021
 *
 * @author Hugo Riera Campos
 *
 */
public class GestionProductosServicioTest {

	private static int NUMERO_REGISTROS_ESPERADOS = 5;

	@InjectMocks
	private GestionProductoServicio gestionProductoService;

	@Mock
	ProductoDao productoDaoMock;

	@Before
	public void inicializar() {
		MockitoAnnotations.openMocks(this);
	}

	/**
	 * Test method for
	 * {@link com.hulk.servicios.productos.GestionProductoServicio#obtenerProductos()}.
	 */
	@Test
	public void deberiaObtenerProductos() throws IOException {

		ClassLoader classLoader = Thread.currentThread().getContextClassLoader();
		String productos = IOUtils
				.toString(classLoader.getResourceAsStream("com/hulk/validacionesjson/tbl_producto_202102061215.json"));

		ProductoDto productoDto = (ProductoDto) ClienteRestUtil.transformarCadenaJsonAObjeto(productos,
				ProductoDto.class);

		List<Producto> listaProductos = productoDto.getListaProductos();

		when(productoDaoMock.obtenerProductos()).thenReturn(listaProductos);

		assertEquals(gestionProductoService.obtenerProductos().size(), NUMERO_REGISTROS_ESPERADOS);

	}
}
