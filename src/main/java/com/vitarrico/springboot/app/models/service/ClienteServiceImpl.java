package com.vitarrico.springboot.app.models.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.vitarrico.springboot.app.models.dao.IClienteDao;
import com.vitarrico.springboot.app.models.dao.IFacturaDao;
import com.vitarrico.springboot.app.models.dao.ILoteDao;
import com.vitarrico.springboot.app.models.entity.Cliente;
import com.vitarrico.springboot.app.models.entity.Factura;
import com.vitarrico.springboot.app.models.entity.Lote;

@Service
public class ClienteServiceImpl implements IClienteService{

	@Autowired
	private IClienteDao clienteDao;
	
	@Autowired
	private ILoteDao productoDao;
	
	@Autowired
	private IFacturaDao facturaDao;
	
	@Override
	@Transactional(readOnly = true)
	public List<Cliente> findAllByNombre() {
		// TODO Auto-generated method stub
		return (List<Cliente>) clienteDao.findAllByOrderByCreateAtDesc();
	}

	@Override
	@Transactional
	public void save(Cliente cliente) {
		clienteDao.save(cliente);
	}

	@Override
	@Transactional(readOnly = true)
	public Cliente findOne(Long id) {
		return clienteDao.findById(id).orElse(null);
	}
	
	@Override
	@Transactional(readOnly = true)
	public Cliente fetchByIdWithFacturas(Long id) {
		return clienteDao.fetchByIdWithFacturas(id);
	}

	@Override
	@Transactional
	public void delete(Long id) {
		clienteDao.deleteById(id);
	}

	@Override
	@Transactional(readOnly = true)
	public Page<Cliente> findAll(Pageable pageable) {
		return clienteDao.findAll(pageable);
	}

	@Override
	@Transactional(readOnly = true)
	public List<Lote> findByNombre(String term) {
		//return servicioProductoFeign.buscarProductoPorNombre(term);
		return productoDao.findByNombreLikeIgnoreCase("%"+term+"%");
	}

	@Override
	@Transactional
	public void saveFactura(Factura factura) {
		facturaDao.save(factura);
	}

	@Override
	@Transactional(readOnly=true)
	public Lote findProductoById(Long id) {
		return productoDao.findById(id).orElse(null);
	}

	@Override
	@Transactional(readOnly=true)
	public Factura findFacturaById(Long id) {
		return facturaDao.findById(id).orElse(null);
	}

	@Override
	@Transactional
	public void deleteFactura(Long id) {
		facturaDao.deleteById(id); // facturaDao.deleteById(id);
	}

	@Override
	@Transactional(readOnly=true)
	public Factura fetchFacturaByIdWithClienteWhithItemFacturaWithProducto(Long id) {
		return facturaDao.fetchByIdWithClienteWhithItemFacturaWithProducto(id);
	}
	
	
}
