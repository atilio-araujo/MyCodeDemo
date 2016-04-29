package br.com.indracompany.poc.pedido.endereco.service;

import java.util.List;

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

	@Override
	public List<EnderecoPedidoTO> buscaListaEnderecoPedido() {
		return this.enderecoPedidoDAO.buscaListaEnderecoPedido();
	}

	@Override
	public void criaEnderecoPedido(EnderecoPedidoTO enderecoPedidoTO) {
		this.enderecoPedidoDAO.criaEnderecoPedido(enderecoPedidoTO);
	}

	@Override
	public void apagaEnderecoPedido(EnderecoPedidoTO enderecoPedidoTO) {
		this.enderecoPedidoDAO.apagaEnderecoPedido(enderecoPedidoTO);	
	}

	@Override
	public EnderecoPedidoTO atualizaEnderecoPedido(EnderecoPedidoTO enderecoPedidoTO) {
		return this.atualizaEnderecoPedido(enderecoPedidoTO);
	}

	public EnderecoPedidoDAO getEnderecoPedidoDAO() {
		return enderecoPedidoDAO;
	}

	public void setEnderecoPedidoDAO(EnderecoPedidoDAO enderecoPedidoDAO) {
		this.enderecoPedidoDAO = enderecoPedidoDAO;
	}
}
