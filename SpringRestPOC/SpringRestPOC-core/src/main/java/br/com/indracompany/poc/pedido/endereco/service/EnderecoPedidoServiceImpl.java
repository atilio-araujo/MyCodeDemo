package br.com.indracompany.poc.pedido.endereco.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.com.indracompany.poc.pedido.endereco.dao.EnderecoPedidoDAO;
import br.com.indracompany.poc.pedido.endereco.service.EnderecoPedidoService;
import br.com.indracompany.poc.pedido.endereco.to.EnderecoPedidoTO;

@Service
@Transactional
public class EnderecoPedidoServiceImpl implements EnderecoPedidoService {

	@Autowired
	private EnderecoPedidoDAO enderecoPedidoDAO;

	@Override
	public EnderecoPedidoTO buscaEnderecoPedidoPorId(EnderecoPedidoTO enderecoTO) {
		return this.enderecoPedidoDAO.buscaEnderecoPedidoPorId(enderecoTO);
	}

	public EnderecoPedidoDAO getEnderecoPedidoDAO() {
		return enderecoPedidoDAO;
	}

	public void setEnderecoPedidoDAO(EnderecoPedidoDAO enderecoPedidoDAO) {
		this.enderecoPedidoDAO = enderecoPedidoDAO;
	}

}
