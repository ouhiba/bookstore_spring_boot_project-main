package com.bookStore.repository;

import com.bookStore.entity.MyFilmList;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MyFilmRepository extends JpaRepository<MyFilmList,Integer>{

}
