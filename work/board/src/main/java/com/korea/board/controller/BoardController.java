package com.korea.board.controller;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
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
		List<BoardDTO> dtos = service.getAllPost();
		ResponseDTO<BoardDTO> response = ResponseDTO.<BoardDTO>builder().data(dtos).build();
		return ResponseEntity.ok(response);
	}
	
	//1-1 한 건 조회
	@GetMapping("/get/{id}")
	public ResponseEntity<?> getPostById(@PathVariable Long id){
		List<BoardDTO> dtos = Arrays.asList(service.getPostById(id));
		ResponseDTO<BoardDTO> response = ResponseDTO.<BoardDTO>builder().data(dtos).build();
		return ResponseEntity.ok(response);
		
	}

	//2 추가
	@PostMapping("/write")
	public ResponseEntity<?> createPost(@RequestBody BoardDTO boardDTO){
		List<BoardDTO> dtos = Arrays.asList(service.createPost(boardDTO));
		ResponseDTO<BoardDTO> response = ResponseDTO.<BoardDTO>builder().data(dtos).build();
		return ResponseEntity.ok(response);	
	}
	
	//3 수정
	@PutMapping("/modify/{id}")
	public boolean updatePost(@PathVariable Long id, @RequestBody BoardDTO boardDTO){
		BoardDTO dto =  service.updatePost(id,boardDTO);
		if(dto != null){
			return true;
		}
		return false;
	}
		
	//4 삭제
	@DeleteMapping("/delete/{id}")
	public boolean deletePost(@PathVariable Long id){
		return service.deletePost(id);
		
	}
		

}






















