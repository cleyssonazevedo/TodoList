package br.senai.sp.informatica.todolist.dao;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import br.senai.sp.informatica.todolist.modelo.ItemLista;
import br.senai.sp.informatica.todolist.modelo.Lista;


@Repository
public class ItemDAO {
	@PersistenceContext
	private EntityManager manager;
	
	@Transactional
	public void MarcarFeito(long idItem, boolean valor){
		ItemLista item = manager.find(ItemLista.class, idItem);
		item.setFeito(valor);
		manager.merge(item);
	}
	
	@Transactional
	public void Inserir(long idLista, ItemLista item) {
		item.setLista(manager.find(Lista.class, idLista));
		manager.persist(item);
	}
	
}