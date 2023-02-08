package dio.springbootweb.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import dio.springbootweb.model.Usuario;

import java.util.List;
//import java.util.Optional;

public interface IUsuarioRepository extends JpaRepository<Usuario, Integer> {
    //Query Method
    List<Usuario> findByLoginContaining(String login);
    //Query Method
    //Optional<Usuario> findById(Integer id);
    //Query Method
    Usuario findByNomeCompleto(String nomeCompleto);

    //Query Override
    @Query("SELECT u FROM Usuario u WHERE u.login LIKE %:login%")
    List<Usuario> filtrarPorNome(@Param("login") String login);
    
    @Transactional
    @Modifying
    @Query("update Usuario u set u.login = :login, u.nomeCompleto = :nome, u.password = :password where u.id = :id")
    int upToDate(@Param("login") String login, @Param("nome") String nome, @Param("password") String password, @Param("id") Integer id);
}
