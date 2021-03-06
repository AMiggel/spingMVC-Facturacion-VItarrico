package com.vitarrico.springboot.app.models.service;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.vitarrico.springboot.app.models.entity.Cliente;
import com.vitarrico.springboot.app.models.entity.Factura;
import com.vitarrico.springboot.app.models.entity.Lote;

public interface IClienteService {

	public List<Cliente> findAllByNombre();
	
	public Page<Cliente> findAll(Pageable pageable);

	public void save(Cliente cliente);
	
	public Cliente findOne(Long id);
	
	public Cliente fetchByIdWithFacturas(Long id);
	
	public void delete(Long id);
	
	public List<Lote> findByNombre(String term);
	
	public void saveFactura(Factura factura);
	
	public Lote findProductoById(Long id);
	
	public Factura findFacturaById(Long id);
	
	public void deleteFactura(Long id);
	
	public Factura fetchFacturaByIdWithClienteWhithItemFacturaWithProducto(Long id);

}
