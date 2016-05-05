package br.com.indracompany.poc.controller.enderecopedido;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.math.NumberUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import br.com.indracompany.poc.pedido.endereco.service.EnderecoPedidoService;
import br.com.indracompany.poc.pedido.endereco.to.EnderecoPedidoTO;

@RestController
public class EnderecoPedidoRestController {

	@Autowired
	private EnderecoPedidoService service;

	@RequestMapping(value = "/enderecopedido/id/{idEnderecoPedido}", method = RequestMethod.GET)
	public EnderecoPedidoTO getEnderecoPedidoPorId(@PathVariable("idEnderecoPedido") String idEnderecoPedido) {

		EnderecoPedidoTO enderecoTO = new EnderecoPedidoTO();
		enderecoTO.setIdEnderecoPedido(new Long(idEnderecoPedido));

		enderecoTO = service.buscaEnderecoPedidoPorId(enderecoTO);

		return enderecoTO;
	}

	@RequestMapping(value = "/enderecopedido", method = RequestMethod.GET)
	public List<EnderecoPedidoTO> getEnderecoPedidoPorCriterio( 
			@RequestParam(value="idEnderecoPedido", required = false) String idEnderecoPedido,
			@RequestParam(value="nomeEndereco", required = false) String nomeEndereco,
			@RequestParam(value="descricao", required = false) String descricao,
			@RequestParam(value="endereco1", required = false) String endereco1,
			@RequestParam(value="endereco2", required = false) String endereco2,
			@RequestParam(value="endereco3", required = false) String endereco3,
			@RequestParam(value="endereco4", required = false) String endereco4) {

		EnderecoPedidoTO enderecoPedidoTO = validaDadosDaPesquisa(idEnderecoPedido, nomeEndereco, descricao, endereco1, endereco2, endereco3, endereco4);

		List<EnderecoPedidoTO> listaEnderecoPedido = new ArrayList<EnderecoPedidoTO>();

		listaEnderecoPedido = service.buscaEnderecoPedidoPorCriterio(enderecoPedidoTO);

		return listaEnderecoPedido;
	}

	@RequestMapping(value = "/enderecopedido", method = RequestMethod.POST)
	public void criaEnderecoPedido(@RequestBody EnderecoPedidoTO enderecoPedidoTO){
		enderecoPedidoTO.setUsuarioCriacao("a5013669");
		enderecoPedidoTO.setDataCriacao(new Date(System.currentTimeMillis()));
		enderecoPedidoTO.setDelecaoLogica('N');
		this.service.criaEnderecoPedido(enderecoPedidoTO);
	}

	@RequestMapping(value = "/enderecopedido", method = RequestMethod.PUT)
	public void atualizaEnderecoPedido(@RequestBody EnderecoPedidoTO enderecoPedidoTO){
		enderecoPedidoTO.setUsuarioCriacao("a5013669");
		this.service.atualizaEnderecoPedido(enderecoPedidoTO);
	}

	@RequestMapping(value = "/enderecopedido", method = RequestMethod.DELETE)
	public void apagaEnderecoPedido(@RequestParam(value="idEnderecoPedido", required = true) String idEnderecoPedido){
		EnderecoPedidoTO enderecoPedidoTO = new EnderecoPedidoTO();

		if (NumberUtils.isNumber(idEnderecoPedido)) {
			enderecoPedidoTO.setIdEnderecoPedido(new Long(idEnderecoPedido));
		}

		this.service.apagaEnderecoPedido(enderecoPedidoTO);
	}

	private EnderecoPedidoTO validaDadosDaPesquisa(String idEnderecoPedido, String nomeEndereco, String descricao, String endereco1,
			String endereco2, String endereco3, String endereco4) {

		EnderecoPedidoTO enderecoPedidoTO = new EnderecoPedidoTO();

		if (NumberUtils.isNumber(idEnderecoPedido)) {
			enderecoPedidoTO.setIdEnderecoPedido(new Long(idEnderecoPedido));
		}
		if (StringUtils.isNotBlank(nomeEndereco)) {
			enderecoPedidoTO.setNomeEndereco(nomeEndereco);
		}
		if (StringUtils.isNotBlank(descricao)) {
			enderecoPedidoTO.setDescricao(descricao);
		}
		if (StringUtils.isNotBlank(endereco1)) {
			enderecoPedidoTO.setEndereco1(endereco1);
		}
		if (StringUtils.isNotBlank(endereco2)) {
			enderecoPedidoTO.setEndereco2(endereco2);
		}
		if (StringUtils.isNotBlank(endereco3)) {
			enderecoPedidoTO.setEndereco3(endereco3);
		}
		if (StringUtils.isNotBlank(endereco3)) {
			enderecoPedidoTO.setEndereco4(endereco4);
		}

		return enderecoPedidoTO;
	}

	public EnderecoPedidoService getService() {
		return service;
	}

	public void setService(EnderecoPedidoService service) {
		this.service = service;
	}

	
}
