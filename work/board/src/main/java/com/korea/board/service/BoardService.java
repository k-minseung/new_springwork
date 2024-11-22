package com.korea.board.service;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Optional;
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
		//repository.findAll()의 반환값이 List<BoardEntity>
		return repository.findAll().stream()
				.map(this::convertToDTO)
				.collect(Collectors.toList());
	}
	
	//1-1 한 건 조회 
	public BoardDTO getPostById(Long id){
		Optional<BoardEntity> board = repository.findById(id);
		return board.map(this::convertToDTO).orElseThrow(() -> new RuntimeException("게시글 못찾아요"));
		
	}
	
	
	//2 추가
	public BoardDTO createPost(BoardDTO boardDTO){
		boardDTO.setWritingTime(LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm")));
		BoardEntity board = convertToEntity(boardDTO);
		return convertToDTO(repository.save(board));
	}
	
	//3 수정
	public BoardDTO updatePost(Long id, BoardDTO boardDTO) {
		BoardEntity existingBoard = repository.findById(id).orElseThrow(() -> new RuntimeException("게시글 못찾아요"));
		existingBoard.setTitle(boardDTO.getTitle());
		existingBoard.setAuthor(boardDTO.getAuthor());
		existingBoard.setContent(boardDTO.getContent());
		return convertToDTO(repository.save(existingBoard));
	}
	
	//4 삭제
	public boolean deletePost(Long id) {
		if(repository.existsById(id)) {
			repository.deleteById(id);
			return true;
		}
		return false;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	//Entity -> DTO
	public BoardDTO convertToDTO(BoardEntity boardEntity) {
		return BoardDTO.builder()
				.id(boardEntity.getId())
				.title(boardEntity.getTitle())
				.author(boardEntity.getAuthor())
				.writingTime(boardEntity.getWritingTime())
				.content(boardEntity.getContent())
				.build();
	}
	
	//DTO->Entity
	public BoardEntity convertToEntity(BoardDTO boardDTO) {
		return BoardEntity.builder()
				.id(boardDTO.getId())
				.title(boardDTO.getTitle())
				.author(boardDTO.getAuthor())
				.writingTime(boardDTO.getWritingTime())
				.content(boardDTO.getContent())
				.build();
	}
	
	

}


















