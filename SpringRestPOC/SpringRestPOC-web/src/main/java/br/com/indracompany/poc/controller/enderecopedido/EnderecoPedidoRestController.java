package br.com.indracompany.poc.controller.enderecopedido;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import br.com.indracompany.poc.pedido.endereco.service.EnderecoPedidoService;
import br.com.indracompany.poc.pedido.endereco.to.EnderecoPedidoTO;

@RestController
public class EnderecoPedidoRestController {

	@Autowired
	private EnderecoPedidoService service;

	@RequestMapping(value = "/enderecopedido/{idEnderecoPedido}", method = RequestMethod.GET)
	public EnderecoPedidoTO getEnderecoPedidoPorId(@PathVariable("idEnderecoPedido") String idEnderecoPedido) {

		EnderecoPedidoTO enderecoTO = new EnderecoPedidoTO();
		enderecoTO.setIdEnderecoPedido(new Long(idEnderecoPedido));

		enderecoTO = service.buscaEnderecoPedidoPorId(enderecoTO);

		return enderecoTO;
	}

	@RequestMapping(value = "/enderecopedido/", method = RequestMethod.GET)
	public List<EnderecoPedidoTO> getListaEnderecoPedido() {

		List<EnderecoPedidoTO> listaEnderecoPedido = new ArrayList<EnderecoPedidoTO>(); 
		listaEnderecoPedido = service.buscaListaEnderecoPedido();

		return listaEnderecoPedido;
	}

	@RequestMapping(value = "/enderecopedido/", method = RequestMethod.POST)
	public void criaEnderecoPedido(@RequestBody EnderecoPedidoTO enderecoPedidoTO){
		this.service.criaEnderecoPedido(enderecoPedidoTO);
	}

	@RequestMapping(value = "/enderecopedido/", method = RequestMethod.PUT)
	public void atualizaEnderecoPedido(@RequestBody EnderecoPedidoTO enderecoPedidoTO){
		this.service.atualizaEnderecoPedido(enderecoPedidoTO);
	}

	@RequestMapping(value = "/enderecopedido/", method = RequestMethod.DELETE)
	public void apagaEnderecoPedido(@RequestBody EnderecoPedidoTO enderecoPedidoTO){
		this.service.apagaEnderecoPedido(enderecoPedidoTO);
	}

	public EnderecoPedidoService getService() {
		return service;
	}

	public void setService(EnderecoPedidoService service) {
		this.service = service;
	}

	
}
