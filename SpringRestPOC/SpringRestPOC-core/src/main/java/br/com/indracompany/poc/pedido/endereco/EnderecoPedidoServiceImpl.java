package br.com.indracompany.poc.pedido.endereco;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.indracompany.poc.pedido.endereco.dao.EnderecoPedidoDAO;
import br.com.indracompany.poc.pedido.endereco.service.EnderecoPedidoService;
import br.com.indracompany.poc.pedido.endereco.to.EnderecoPedidoTO;

@Service("EnderecoPedidoService")
public class EnderecoPedidoServiceImpl implements EnderecoPedidoService {

	@Autowired
	private EnderecoPedidoDAO enderecoPedidodao;

	@Override
	public EnderecoPedidoTO buscaEnderecoPedidoPorId(EnderecoPedidoTO enderecoTO) {
		return this.enderecoPedidodao.buscaEnderecoPedidoPorId(enderecoTO);
	}

	public EnderecoPedidoDAO getEnderecoPedidodao() {
		return enderecoPedidodao;
	}

	public void setEnderecoPedidodao(EnderecoPedidoDAO enderecoPedidodao) {
		this.enderecoPedidodao = enderecoPedidodao;
	}

}
