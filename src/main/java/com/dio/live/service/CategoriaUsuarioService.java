package com.dio.live.service;

import com.dio.live.model.CategoriaUsuario;
import com.dio.live.model.CategoriaUsuario;
import com.dio.live.repository.CategoriaUsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CategoriaUsuarioService {


    CategoriaUsuarioRepository categoriaUsuarioRepository;

    @Autowired
    public CategoriaUsuarioService(CategoriaUsuarioRepository categoriaUsuarioRepository){
        this.categoriaUsuarioRepository = categoriaUsuarioRepository;
    }

    public CategoriaUsuario saveCategoria(CategoriaUsuario categoriaUsuario){
        return categoriaUsuarioRepository.save(categoriaUsuario);

    }

    public List<CategoriaUsuario> findAll() {
        return categoriaUsuarioRepository.findAll();
    }

    public Optional<CategoriaUsuario> getById(Long idCategoriaUsuario) {
        return categoriaUsuarioRepository.findById(idCategoriaUsuario);
    }

    public CategoriaUsuario updateCategoriaUsuario(CategoriaUsuario categoriaUsuario){
        return categoriaUsuarioRepository.save(categoriaUsuario);
    }

    public void deleteCategoriaUsuario(long deleteCategoriaUsuario) {
        categoriaUsuarioRepository.deleteById(deleteCategoriaUsuario);
    }

}
