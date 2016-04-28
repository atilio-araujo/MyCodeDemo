package br.com.indracompany.poc.pedido.endereco.dao;

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

		EnderecoPedidoTO enderecoPedidoTO = new EnderecoPedidoTO();
		String hql = new String("FROM EnderecoPedido WHERE idEnderecoPedido = ?");
		List<EnderecoPedido> listaEnderecos = sessionFactory.getCurrentSession().createQuery(hql).setParameter(0, enderecoTO.getIdEnderecoPedido()).list();
		
		if ( listaEnderecos !=null && listaEnderecos.size() > 0) {
			enderecoPedidoTO = new EnderecoPedidoTO(listaEnderecos.get(0));
		}

		return enderecoPedidoTO;
	}

	@Override
	public List<EnderecoPedidoTO> buscaListaEnderecoPedido() {
		// TODO Auto-generated method stub
		return null;
	}

	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

}
