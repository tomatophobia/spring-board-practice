package com.spring.board.service;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring.board.common.PagingUtil;
import com.spring.board.common.ResultUtil;
import com.spring.board.dao.BoardDao;
import com.spring.board.dto.BoardDto;
import com.spring.board.dto.CommonDto;

@Service
public class BoardService {

  @Autowired
  private BoardDao boardDao;

  /**
   * 게시판 - 목록 조회
   */
  public ResultUtil getBoardList(BoardDto boardForm) throws Exception {

    ResultUtil resultUtil = new ResultUtil();

    CommonDto commonDto = new CommonDto();

    int totalCount = boardDao.getBoardCnt(boardForm);
    if (totalCount != 0) {
      CommonDto commonForm = new CommonDto();
      commonForm.setFunction_name(boardForm.getFunction_name());
      commonForm.setCurrent_page_no(boardForm.getCurrent_page_no());
      commonForm.setCount_per_page(5);
      commonForm.setCount_per_list(5);
      commonForm.setTotal_list_count(totalCount);
      commonDto = PagingUtil.setPageUtil(commonForm);
    }

    boardForm.setLimit(commonDto.getLimit());
    boardForm.setOffset(commonDto.getOffset());

    List<BoardDto> list = boardDao.getBoardList(boardForm);

    HashMap<String, Object> resultMap = new HashMap<String, Object>();
    resultMap.put("list", list);
    resultMap.put("totalCount", totalCount);
    resultMap.put("pagination", commonDto.getPagination());

    resultUtil.setData(resultMap);
    resultUtil.setState("SUCCESS");

    return resultUtil;
  }

  /**
   * 게시판 - 상세 조회
   */
  public BoardDto getBoardDetail(BoardDto boardForm) throws Exception {

    BoardDto boardDto = new BoardDto();

    boardDto = boardDao.getBoardDetail(boardForm);

    return boardDto;
  }

  /**
   * 게시판 - 등록
   */
  public BoardDto insertBoard(BoardDto boardForm) throws Exception {

    BoardDto boardDto = new BoardDto();

    int insertCnt = 0;

    insertCnt = boardDao.insertBoard(boardForm);

    if (insertCnt > 0) {
      boardDto.setResult("SUCCESS");
    } else {
      boardDto.setResult("FAIL");
    }

    return boardDto;
  }

  /**
   * 게시판 - 삭제
   */
  public BoardDto deleteBoard(BoardDto boardForm) throws Exception {

    BoardDto boardDto = new BoardDto();

    int deleteCnt = boardDao.deleteBoard(boardForm);

    if (deleteCnt > 0) {
      boardDto.setResult("SUCCESS");
    } else {
      boardDto.setResult("FAIL");
    }

    return boardDto;
  }

  /**
   * 게시판 - 수정
   */
  public BoardDto updateBoard(BoardDto boardForm) throws Exception {

    BoardDto boardDto = new BoardDto();

    int updateCnt = boardDao.updateBoard(boardForm);

    if (updateCnt > 0) {
      boardDto.setResult("SUCCESS");
    } else {
      boardDto.setResult("FAIL");
    }

    return boardDto;
  }

}
