package com.korea.board.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.korea.board.dto.BoardDTO;
import com.korea.board.dto.ResponseDTO;
import com.korea.board.entity.BoardEntity;
import com.korea.board.service.BoardService;

import lombok.Builder;



@RestController
@RequestMapping("/api/board")
public class BoardController {
	@Autowired
	private BoardService service;

	//1 조회
	@GetMapping("/all")
	public ResponseEntity<?> getAllPosts(){
		List<BoardDTO> dtos = service.getAllPosts();

	}
	
	
	
	//2 추가
	
		//3 수정
		
		//4 삭제
		
		//Entity -> DTO 변환메서드
		
		
		//DTO -> Entity 변환메서드
}






















