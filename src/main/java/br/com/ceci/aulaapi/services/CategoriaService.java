
package br.com.ceci.aulaapi.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import br.com.ceci.aulaapi.domain.Categoria;
import br.com.ceci.aulaapi.repositories.CategoriaRepository;
import br.com.ceci.aulaapi.services.exceptions.ObjectNotFoundException;

@Service
public class CategoriaService {
	@Autowired
private CategoriaRepository categoriaRepository;
	public Page<Categoria> pesquisar (String nome, Pageable pageable){
		return categoriaRepository.findByNomeContaining(nome, pageable);
	}
	
	public List<Categoria> listarTodas(){
		return categoriaRepository.findAll();
	}
	
	 public Categoria find(Integer id) {
		 Optional<Categoria> obj = categoriaRepository.findById(id);
		 return obj.orElseThrow(() -> new ObjectNotFoundException(
				 "Objeto não encontrado! ID:" +id+
				 "Tipo:"+ Categoria.class.getName()));
		 
	 }
	 public Categoria insert(Categoria obj) {
		 obj.setId(null);
		 return categoriaRepository.save(obj);
	 }
	 public Categoria update(Categoria obj) {
		 find(obj.getId());
		 return categoriaRepository.save(obj);
	 }
	 
	 public void delete(Integer id) {
		 find(id);
		 categoriaRepository.deleteById(id);
	 }
}
