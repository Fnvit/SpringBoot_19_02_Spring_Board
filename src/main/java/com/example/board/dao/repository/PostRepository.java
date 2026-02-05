package com.example.board.dao.repository;

import com.example.board.domain.entity.PostEntity;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface PostRepository extends CrudRepository<PostEntity, Integer> {
    List<PostEntity> findAllByOrderByNoDesc();
}
