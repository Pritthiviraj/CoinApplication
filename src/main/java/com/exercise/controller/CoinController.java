package com.exercise.controller;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import com.exercise.model.Coin;
import com.exercise.repository.CoinRepository;

@Controller
@RequestMapping("/coin")
public class CoinController {

	@Autowired
	CoinRepository repo;
	
	@PostMapping("/savecoin")
	public ResponseEntity saveCoins(@RequestBody Coin coin) {
		Coin responseCoin = repo.save(coin);
		return new ResponseEntity(responseCoin,HttpStatus.ACCEPTED);
	}
	
	@GetMapping("/retrievecoins")
	public ResponseEntity<Map<String,Integer>> getCoins(){
		List<Coin> coins = repo.findAll();
		Map<String,Integer> responseCoins = coins.stream().collect(Collectors.groupingBy(Coin::getName,Collectors.summingInt(Coin::getCoin)));
		return new ResponseEntity(responseCoins,HttpStatus.OK);
	}
}
