package br.com.gustavoborgo.projectusers.repository;
import br.com.gustavoborgo.projectusers.entity.UsuarioEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UsuarioRepository extends JpaRepository<UsuarioEntity, Long> {


}
