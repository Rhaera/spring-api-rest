package dio.springbootweb.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "tab_usuario")
public class Usuario {
    @Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
	
	@Column(name = "nome_completo", length = 50, nullable = false)
	private String nomeCompleto;
	
    @Column(length = 20, nullable = false)
	private String login;
	
	@Column(length = 100, nullable = false)
    private String password;
    public Usuario() {}
    public Usuario(String nome, String login, String password) {
        this.nomeCompleto = nome;
        this.login = login;
        this.password = password;
    }
    public String getNomeCompleto() {
        return nomeCompleto;
    }
    public void setNomeCompleto(String nome) {
        this.nomeCompleto = nome;
    }
    public String getLogin() {
        return login;
    }
    public void setLogin(String login) {
        this.login = login;
    }
    public String getPassword() {
        return password;
    }
    public void setPassword(String password) {
        this.password = password;
    }
    @Override
    public String toString() {
        return "User{" +
                "login='" + login + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}
