package com.spring.board.dao;

import java.util.List;

import javax.annotation.Resource;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import com.spring.board.dto.BoardDto;

@Repository
public class BoardDao {

  @Resource(name = "sqlSession")
  private SqlSession sqlSession;

  private static final String NAMESPACE = "com.spring.board.boardMapper";

  /**
   * 게시판 - 목록 수
   */
  public int getBoardCnt(BoardDto boardForm) throws Exception {

    return sqlSession.selectOne(NAMESPACE + ".getBoardCnt", boardForm);
  }

  /**
   * 게시판 - 목록 조회
   */
  public List<BoardDto> getBoardList(BoardDto boardForm) throws Exception {

    return sqlSession.selectList(NAMESPACE + ".getBoardList", boardForm);
  }

  /**
   * 게시판 - 상세 조회
   */
  public BoardDto getBoardDetail(BoardDto boardForm) throws Exception {

    return sqlSession.selectOne(NAMESPACE + ".getBoardDetail", boardForm);
  }

  /**
   * 게시판 - 등록
   */
  public int insertBoard(BoardDto boardForm) throws Exception {
    return sqlSession.insert(NAMESPACE + ".insertBoard", boardForm);
  }

  /**
   * 게시판 - 삭제
   */
  public int deleteBoard(BoardDto boardForm) throws Exception {

    return sqlSession.delete(NAMESPACE + ".deleteBoard", boardForm);
  }

  /**
   * 게시판 - 수정
   */
  public int updateBoard(BoardDto boardForm) throws Exception {

    return sqlSession.update(NAMESPACE + ".updateBoard", boardForm);
  }

}
