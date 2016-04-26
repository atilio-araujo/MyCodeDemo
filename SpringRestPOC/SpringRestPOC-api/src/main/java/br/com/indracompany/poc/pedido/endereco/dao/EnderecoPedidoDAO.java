package br.com.indracompany.poc.pedido.endereco.dao;

import java.util.List;

import br.com.indracompany.poc.pedido.endereco.to.EnderecoPedidoTO;

public interface EnderecoPedidoDAO {

	public EnderecoPedidoTO buscaEnderecoPedidoPorId(EnderecoPedidoTO enderecoTO);
	public List<EnderecoPedidoTO> buscaListaEnderecoPedido();

}
