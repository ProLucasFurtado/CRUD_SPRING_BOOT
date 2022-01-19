package crud.springboot.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import crud.springboot.models.Usuarios;

@Repository
public interface UsuarioRepository extends JpaRepository<Usuarios, Long> {
	
	@Query(value ="select u from Usuarios u where upper(trim(u.nome)) like %?1%")
	public List<Usuarios> buscarPorNome(String nome);

}
