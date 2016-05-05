package br.com.indracompany.poc.pedido.endereco.dao;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.hibernate.Criteria;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
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
		enderecoPedidoOriginal = (EnderecoPedido) this.sessionFactory.getCurrentSession().merge(new EnderecoPedido(enderecoPedidoTO));
		this.sessionFactory.getCurrentSession().update(enderecoPedidoOriginal);

		return new EnderecoPedidoTO(enderecoPedidoOriginal);
	}

	@Override
	public List<EnderecoPedidoTO> buscaEnderecoPedidoPorCriterio(EnderecoPedidoTO enderecoTO) {

		Criteria criteria = this.sessionFactory.getCurrentSession().createCriteria(EnderecoPedido.class);

		if (enderecoTO.getIdEnderecoPedido() > 0){
			criteria.add(Restrictions.eq("idEnderecoPedido", enderecoTO.getIdEnderecoPedido()));
		}

		if (StringUtils.isNotBlank(enderecoTO.getNomeEndereco())){
			criteria.add(Restrictions.eq("nomeEndereco", enderecoTO.getNomeEndereco()));
		}

		if (StringUtils.isNotBlank(enderecoTO.getDescricao())){
			criteria.add(Restrictions.like("descricao", "%" + enderecoTO.getDescricao() + "%"));

		}

		if (StringUtils.isNotBlank(enderecoTO.getPreferencial())){
			criteria.add(Restrictions.eq("preferencial", enderecoTO.getPreferencial()));
		}

		if (StringUtils.isNotBlank(enderecoTO.getEndereco1())){
			criteria.add(Restrictions.eq("endereco1", enderecoTO.getEndereco1()));
		}

		if (StringUtils.isNotBlank(enderecoTO.getEndereco2())){
			criteria.add(Restrictions.eq("endereco2", enderecoTO.getEndereco2()));
		}

		if (StringUtils.isNotBlank(enderecoTO.getEndereco3())){
			criteria.add(Restrictions.eq("endereco3", enderecoTO.getEndereco3()));
		}

		if (StringUtils.isNotBlank(enderecoTO.getEndereco4())){
			criteria.add(Restrictions.eq("endereco4", enderecoTO.getEndereco4()));
		}

		List<EnderecoPedido> listaEnderecoPedido = criteria.list();
		List<EnderecoPedidoTO> listaEnderecoPedidoTO = new ArrayList<EnderecoPedidoTO>();

		for ( EnderecoPedido endereco : listaEnderecoPedido ){
			EnderecoPedidoTO enderecoPedidoTO = new EnderecoPedidoTO(endereco);
			listaEnderecoPedidoTO.add(enderecoPedidoTO);
		}

		return listaEnderecoPedidoTO;
	}

	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

}
