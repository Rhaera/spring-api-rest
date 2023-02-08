package dio.springbootweb.repository;

import dio.springbootweb.model.Usuario;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class UsuarioRepository {
    
    @Autowired
    private IUsuarioRepository iUsuarioRepository;

    public void save(Usuario usuario){
        System.out.println("UPDATE - Recebendo o usuário na camada de repositório");
        System.out.println(usuario);
        iUsuarioRepository.save(usuario);
    }
    public void updateUser(Usuario usuario, Integer id){
        
        iUsuarioRepository.upToDate(usuario.getLogin(), usuario.getNomeCompleto(), usuario.getPassword(), id);

    }
    public void remove(Integer id){
        iUsuarioRepository.delete(iUsuarioRepository.getById(id));
    }
    public List<Usuario> listAll(){
        return iUsuarioRepository.findAll();
    }
    public Usuario findId(Integer id){
        return iUsuarioRepository.getById(id);
    }
    
}
