package dio.springbootweb.controller;

import dio.springbootweb.model.Usuario;
import dio.springbootweb.repository.UsuarioRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
public class UsuarioController {
    @Autowired
    private UsuarioRepository repository;

    @PostMapping("/usuarios")
    public void post(@RequestBody Usuario usuario){
        repository.save(usuario);
    }
    @PutMapping("/usuario/{id}")
    public void put(@RequestBody Usuario usuario, @PathVariable("id") Integer id){
        repository.updateUser(usuario, id);
    }
    @GetMapping("/usuarios")
    public List<Usuario> getAll(){
        return repository.listAll();
    }
    @GetMapping("/usuario/{id}")
    public List<Usuario> getOne(@PathVariable("id") Integer id){
        
        List<Usuario> listUser = new ArrayList<>();
        listUser.add(repository.listAll().get(id - 1));
        return listUser;
        // new ResponseEntity<>(repository.findId(id), HttpStatus.OK);
    }
    @DeleteMapping("/usuarios/{id}")
    public void delete(@PathVariable("id") Integer id){
        repository.remove(id);
    }
}
