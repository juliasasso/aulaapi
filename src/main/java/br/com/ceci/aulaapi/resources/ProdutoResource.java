package br.com.ceci.aulaapi.resources;

import java.net.URI;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import br.com.ceci.aulaapi.domain.Produto;
import br.com.ceci.aulaapi.services.ProdutoService;

@RestController
@RequestMapping("/produtos")
public class ProdutoResource {

	@Autowired
	private ProdutoService produtoService;
	
	@GetMapping("/{id}")
	public ResponseEntity<?>find(@PathVariable Integer id){
		Produto obj = produtoService.find(id);
		
		return ResponseEntity.ok().body(obj);
	}
	@PostMapping()
	public ResponseEntity<Void> insert(@RequestBody Produto obj){
		obj = produtoService.insert(obj);
		URI uri=ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(obj.getId()).toUri();
		return ResponseEntity.created(uri).build();
		
	}
	@PutMapping("/{id}")
	public ResponseEntity<Void> update(@RequestBody Produto obj, @PathVariable Integer id){
	obj.setId(id);
	obj = produtoService.update(obj);
	return ResponseEntity.noContent().build();
		
	}
    @DeleteMapping("{id}")
    public ResponseEntity <Void> delete (@PathVariable Integer id){
    	produtoService.delete(id);
    	return ResponseEntity.noContent().build();
    	
    }
	
}

