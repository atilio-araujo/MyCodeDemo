package br.com.indracompany.poc.pedido.endereco.dao;

import java.util.List;

import br.com.indracompany.poc.pedido.endereco.to.EnderecoPedidoTO;

public interface EnderecoPedidoDAO {

	public EnderecoPedidoTO buscaEnderecoPedidoPorId(EnderecoPedidoTO enderecoTO);
	public List<EnderecoPedidoTO> buscaEnderecoPedidoPorCriterio(EnderecoPedidoTO enderecoTO);
	public List<EnderecoPedidoTO> buscaListaEnderecoPedido();
	public void criaEnderecoPedido(EnderecoPedidoTO enderecoPedidoTO);
	public void apagaEnderecoPedido(EnderecoPedidoTO enderecoPedidoTO);
	public EnderecoPedidoTO atualizaEnderecoPedido(EnderecoPedidoTO enderecoPedidoTO);

}
