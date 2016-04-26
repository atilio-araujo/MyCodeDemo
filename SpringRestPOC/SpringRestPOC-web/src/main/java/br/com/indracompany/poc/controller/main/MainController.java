package br.com.indracompany.poc.controller.main;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import br.com.indracompany.poc.pedido.endereco.service.EnderecoPedidoService;
import br.com.indracompany.poc.pedido.endereco.to.EnderecoPedidoTO;

@Controller
public class MainController {

	@Autowired
	private EnderecoPedidoService service;

	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String main(Map<String, Object> model) {
		model.put("bodyMessage", "Mensagem gerada pelo controller!");

		return "main";
	}

	@RequestMapping(value = "/main/{idEnderecoPedido:.+}", method = RequestMethod.GET)
	public ModelAndView hello(@PathVariable("idEnderecoPedido") String idEnderecoPedido) {

		ModelAndView model = new ModelAndView();
		model.setViewName("main");

		EnderecoPedidoTO enderecoTO = new EnderecoPedidoTO();
		enderecoTO.setIdEnderecoPedido(new Long(idEnderecoPedido));

		service.buscaEnderecoPedidoPorId(enderecoTO);

		model.addObject("nomeEnderecoPedido", enderecoTO.getNomeEndereco());

		return model;

	}

	public EnderecoPedidoService getService() {
		return service;
	}

	public void setService(EnderecoPedidoService service) {
		this.service = service;
	}

}
