package com.demo.consumer.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.demo.consumer.entity.WikimediaData;
@Repository
public interface WikiRepo extends JpaRepository<WikimediaData, Long> {

}
