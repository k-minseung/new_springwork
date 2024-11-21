package com.korea.board.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.korea.board.dto.BoardDTO;
import com.korea.board.entity.BoardEntity;
import com.korea.board.repository.BoardRepository;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;


@Slf4j
@RequiredArgsConstructor
@Service
public class BoardService {
	
	private final BoardRepository repository; // 의존성 주입
	
	//1 조회
	public List<BoardDTO> getAllPost(){
		return repository.findAll().stream()
				.map(BoardDTO::new)
				.collect(Collectors.toList());
	}
	
	//2 추가
	
	//3 수정
	
	//4 삭제
	
	//Entity -> DTO 변환메서드
	
	
	//DTO -> Entity 변환메서드
	

}


















