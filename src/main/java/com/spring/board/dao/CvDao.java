package com.spring.board.dao;

import com.spring.board.dto.AchievementsDto;
import com.spring.board.dto.EducationDto;
import com.spring.board.dto.UserDto;
import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;
import java.util.List;

@Repository
public class CvDao {
    @Resource(name = "sqlSession")
    private SqlSession sqlSession;

    private static final String NAMESPACE = "com.spring.board.cvMapper";

    public UserDto getUser(){
        return sqlSession.selectOne(NAMESPACE+".getUser");
    }

    public int registerUser(UserDto userDto){
        return sqlSession.insert(NAMESPACE+".registerUser", userDto);
    }

    public int deleteUser(UserDto userDto){
        return sqlSession.delete(NAMESPACE+".deleteUser", userDto);
    }

    public List<EducationDto> getEducation(EducationDto educationDto) {
        return sqlSession.selectList(NAMESPACE + ".getEducation", educationDto);
    }

    public int insertEducation(EducationDto educationDto){
        return sqlSession.insert(NAMESPACE+".insertEducation", educationDto);
    }

    public int deleteEducation(EducationDto educationDto){
        return sqlSession.delete(NAMESPACE+".deleteEducation",educationDto);
    }

    public List<AchievementsDto> getAchievements(){
        return sqlSession.selectList(NAMESPACE+".getAchievements");
    }

    public int insertAchievements(AchievementsDto achievementsDto){
        return sqlSession.insert(NAMESPACE+".insertAchievements",achievementsDto);
    }

    public int deleteAchievements(AchievementsDto achievementsDto){
        return sqlSession.delete(NAMESPACE+".deleteAchievements",achievementsDto);
    }
}
