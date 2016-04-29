package br.com.indracompany.poc.pedido.endereco.dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import br.com.indracompany.poc.pedido.endereco.entity.EnderecoPedido;
import br.com.indracompany.poc.pedido.endereco.to.EnderecoPedidoTO;

@Repository
public class EnderecoPedidoDAOImpl implements EnderecoPedidoDAO{

	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public EnderecoPedidoTO buscaEnderecoPedidoPorId(EnderecoPedidoTO enderecoTO) {

		EnderecoPedido enderecoPedido = new EnderecoPedido();
		enderecoPedido = this.buscaEnderecoPedidoPorId(enderecoTO.getIdEnderecoPedido());

		EnderecoPedidoTO enderecoPedidoTO = new EnderecoPedidoTO(enderecoPedido);

		return enderecoPedidoTO;
	}

	private EnderecoPedido buscaEnderecoPedidoPorId(Long idEndereco){
		EnderecoPedido enderecoPedido = new EnderecoPedido();

		String hql = new String("FROM EnderecoPedido WHERE idEnderecoPedido = ?");
		List<EnderecoPedido> listaEnderecos = sessionFactory.getCurrentSession().createQuery(hql).setParameter(0, idEndereco).list();
		
		if ( listaEnderecos !=null && listaEnderecos.size() > 0) {
			enderecoPedido = listaEnderecos.get(0);
		}

		return enderecoPedido;
	}

	@Override
	public List<EnderecoPedidoTO> buscaListaEnderecoPedido() {
		List<EnderecoPedidoTO> listaEnderecoPedido = new ArrayList<EnderecoPedidoTO>();
		listaEnderecoPedido = sessionFactory.getCurrentSession().createCriteria(EnderecoPedido.class).list();
		return listaEnderecoPedido;
	}

	@Override
	public void criaEnderecoPedido(EnderecoPedidoTO enderecoPedidoTO) {

		EnderecoPedido enderecoPedido = new EnderecoPedido(enderecoPedidoTO);
		this.getSessionFactory().getCurrentSession().save(enderecoPedido);
		
	}

	@Override
	public void apagaEnderecoPedido(EnderecoPedidoTO enderecoPedidoTO){

		EnderecoPedido enderecoPedido = this.buscaEnderecoPedidoPorId(enderecoPedidoTO.getIdEnderecoPedido());
		this.sessionFactory.getCurrentSession().delete(enderecoPedido);

	}

	@Override
	public EnderecoPedidoTO atualizaEnderecoPedido(EnderecoPedidoTO enderecoPedidoTO){

		EnderecoPedido enderecoPedidoOriginal = this.buscaEnderecoPedidoPorId(enderecoPedidoTO.getIdEnderecoPedido());
		EnderecoPedido enderecoPedidoFinal = (EnderecoPedido) this.sessionFactory.getCurrentSession().merge(new EnderecoPedido(enderecoPedidoTO));
		this.sessionFactory.getCurrentSession().update(enderecoPedidoFinal);

		return new EnderecoPedidoTO(enderecoPedidoFinal);
	}

	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

}
