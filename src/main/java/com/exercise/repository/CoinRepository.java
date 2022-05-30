package com.exercise.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.exercise.model.Coin;

public interface CoinRepository extends JpaRepository<Coin, Long>{

}