package br.com.alura.forum.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.alura.forum.modelo.Curso;

// Repository somente faz acesso ao banco de dados, ele que obtem os dados -> Acesso a dados = persistencia -> CRUD
public interface CursoRepository extends JpaRepository<Curso, Long> {

	Curso findByNome(String nome);

}
