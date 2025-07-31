package br.com.gustavoborgo.projectusers.service;
import br.com.gustavoborgo.projectusers.dto.UsuarioDTO;
import br.com.gustavoborgo.projectusers.entity.UsuarioEntity;
import br.com.gustavoborgo.projectusers.repository.UsuarioRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class UsuarioService {

    @Autowired
    private UsuarioRepository usuarioRepository;


public List<UsuarioDTO> ListarTodos() {
        List<UsuarioEntity> usuarios = usuarioRepository.findAll();
        return usuarios.stream().map(UsuarioDTO::new).toList();
    }

public void inserir(UsuarioDTO usuarioDTO) {
        UsuarioEntity usuarioEntity = new UsuarioEntity(usuarioDTO);
        usuarioRepository.save(usuarioEntity);
}

    public UsuarioDTO alterar(UsuarioDTO usuarioDTO) {
        UsuarioEntity existente = usuarioRepository.findById(usuarioDTO.getId())
                .orElseThrow(() -> new RuntimeException("Usuário não encontrado"));

        // Atualiza apenas os campos desejados, ignorando o ID
        BeanUtils.copyProperties(usuarioDTO, existente, "id");

        return new UsuarioDTO(usuarioRepository.save(existente));
    }

public void excluir(Long id) {
        UsuarioEntity usuarioEntity = usuarioRepository.findById(id).get();
        usuarioRepository.delete(usuarioEntity);
}

public UsuarioDTO buscarPorId(Long id) {
        return new UsuarioDTO(usuarioRepository.findById(id).get());
}

}

