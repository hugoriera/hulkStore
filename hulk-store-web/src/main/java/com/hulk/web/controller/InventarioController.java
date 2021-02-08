/**
* Copyright (C) 2021 - Todos los derechos reservados.
* TODO 1 Systems
*/
package com.hulk.web.controller;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import com.hulk.modelo.Inventario;
import com.hulk.modelo.Producto;
import com.hulk.servicios.inventario.GestionInventarioServicio;
import com.hulk.servicios.productos.GestionProductoServicio;
import com.hulk.web.utils.JsfUtils;
import com.hulk.web.viewModels.ProductoViewModel;

/**
 * Fecha de creacion: 6 feb. 2021
 *
 * @author Hugo Riera Campos
 *
 */
@Named("inventario")
@ViewScoped
public class InventarioController implements Serializable {

	private static final long serialVersionUID = 6054548660258203926L;

	private static final String DIALOGO_INGRESAR = "dlg3";
	private static final String DIALOGO_EGRESAR = "dlg4";

	@Inject
	private GestionProductoServicio srvGestionProductos;

	@Inject
	private GestionInventarioServicio srvGestionInventario;

	private List<ProductoViewModel> productos;

	private List<Producto> listaProductos;

	private ProductoViewModel productoSeleccionado;

	private Integer cantidadSolicitada;
	private Integer idProductoSeleccionado;

	@PostConstruct
	public void onload() {
		this.setListaProductos(srvGestionProductos.obtenerProductos());
		this.productoSeleccionado = new ProductoViewModel();
		this.setProductos(new ArrayList<ProductoViewModel>());
		this.setCantidadSolicitada(0);
		cargarProductos();
	}

	/**
	 * Método que actualiza stock en bodega por un ingreso
	 */
	public void ingresarInvetario() {
		Producto productoActualizar = this.listaProductos.stream()
				.filter(lp -> this.getIdProductoSeleccionado() == lp.getId()).findAny().orElse(null);
		Inventario inventario = productoActualizar.getInventario();
		inventario.setStock(inventario.getStock() + this.getCantidadSolicitada());
		srvGestionInventario.actualizarInventario(inventario);
		JsfUtils.mostrarOcutarDialogo(DIALOGO_INGRESAR, Boolean.FALSE);
	}

	/**
	 * Método que actualiza el stock en bodega por un egreso
	 */
	public void egresarInventario() {
		Producto productoActualizar = this.listaProductos.stream()
				.filter(lp -> this.getIdProductoSeleccionado() == lp.getId()).findAny().orElse(null);
		Inventario inventario = productoActualizar.getInventario();

		if (inventario.getStock() > 0) {
			inventario.setStock(inventario.getStock() - productoSeleccionado.getCantidadSolicitada());
			srvGestionInventario.actualizarInventario(inventario);
		}

		JsfUtils.mostrarOcutarDialogo(DIALOGO_EGRESAR, Boolean.FALSE);
	}

	public void alSeleccionarIngresoInventario(int productoId) {
		this.setIdProductoSeleccionado(productoId);
		JsfUtils.mostrarOcutarDialogo(DIALOGO_INGRESAR, Boolean.TRUE);
	}

	public void alSeleccionarEgresoInventario(int productoId) {
		this.setIdProductoSeleccionado(productoId);
		JsfUtils.mostrarOcutarDialogo(DIALOGO_EGRESAR, Boolean.TRUE);
	}

	/**
	 * Método que carga los productos en la clase de visualización de la vista
	 */
	private void cargarProductos() {
		ProductoViewModel productoViewModel;
		for (Producto producto : listaProductos) {
			productoViewModel = new ProductoViewModel();
			productoViewModel.setProductId(producto.getId());
			productoViewModel.setDescripcion(producto.getDescripcion());
			productoViewModel.setModeloId(producto.getModeloId());
			productoViewModel.setTipoProductoId(producto.getTipoProductoId());
			productoViewModel.setPrecio(producto.getPrecio());
			productoViewModel.setInventarioId(producto.getInventario().getId());
			productoViewModel.setStock(producto.getInventario().getStock());
			productoViewModel.setCantidadSolicitada(0);
			this.productos.add(productoViewModel);
		}
	}

	public List<ProductoViewModel> getProductos() {
		return productos;
	}

	public void setProductos(List<ProductoViewModel> productos) {
		this.productos = productos;
	}

	public ProductoViewModel getProductoSeleccionado() {
		return productoSeleccionado;
	}

	public void setProductoSeleccionado(ProductoViewModel productoSeleccionado) {
		this.productoSeleccionado = productoSeleccionado;
	}

	public List<Producto> getListaProductos() {
		return listaProductos;
	}

	public void setListaProductos(List<Producto> listaProductos) {
		this.listaProductos = listaProductos;
	}

	public Integer getCantidadSolicitada() {
		return cantidadSolicitada;
	}

	public void setCantidadSolicitada(Integer cantidadSolicitada) {
		this.cantidadSolicitada = cantidadSolicitada;
	}

	public Integer getIdProductoSeleccionado() {
		return idProductoSeleccionado;
	}

	public void setIdProductoSeleccionado(Integer idProductoSeleccionado) {
		this.idProductoSeleccionado = idProductoSeleccionado;
	}
}
