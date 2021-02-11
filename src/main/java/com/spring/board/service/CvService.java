package com.spring.board.service;

import com.spring.board.dao.CvDao;
import com.spring.board.dto.AchievementsDto;
import com.spring.board.dto.EducationDto;
import com.spring.board.dto.UserDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CvService {

    @Autowired
    private CvDao cvDao;

    public UserDto getUser(){
        return cvDao.getUser();
    }

    public UserDto registerUser(UserDto userDto){
        UserDto userDto1=new UserDto();
        int insertCnt=0;
        insertCnt=cvDao.registerUser(userDto);

        if (insertCnt>0){
            userDto1.setResult("success");
        }
        else {
            userDto1.setResult("fail");
        }
        return userDto1;
    }

    public UserDto deleteUser(UserDto userDto){
        UserDto userDto1=new UserDto();
        int deleteCnt=0;
        deleteCnt=cvDao.deleteUser(userDto);

        if (deleteCnt>0){
            userDto1.setResult("success");
        }
        else {
            userDto1.setResult("fail");
        }
        return userDto1;
    }

    public List<EducationDto> getEducation(EducationDto educationDto) {

        return cvDao.getEducation(educationDto);
    }

    public EducationDto insertEducation(EducationDto educationDto){

        EducationDto educationDto1 =new EducationDto();

        int insertCnt=0;
        insertCnt=cvDao.insertEducation(educationDto);

        if (insertCnt>0){
            educationDto1.setResult("success");
        }
        else{
            educationDto1.setResult("fail");
        }
        return educationDto1;
    }

    public EducationDto deleteEducation(EducationDto educationDto){
        EducationDto educationDto1=new EducationDto();

        int deleteCnt=cvDao.deleteEducation(educationDto);

        if (deleteCnt>0){
            educationDto1.setResult("success");
        }
        else{
            educationDto1.setResult("fail");
        }
        return educationDto1;
    }

    public List<AchievementsDto> getAchievements(){
        return cvDao.getAchievements();
    }

    public AchievementsDto insertAchievements(AchievementsDto achievementsDto){

        AchievementsDto achievementsDto1 =new AchievementsDto();

        int insertCnt=0;
        insertCnt=cvDao.insertAchievements(achievementsDto);

        if (insertCnt>0){
            achievementsDto1.setResult("success");
        }
        else{
            achievementsDto1.setResult("fail");
        }
        return achievementsDto1;
    }

    public AchievementsDto deleteAchievements(AchievementsDto achievementsDto){
        AchievementsDto achievementsDto1=new AchievementsDto();

        int deleteCnt=cvDao.deleteAchievements(achievementsDto);

        if (deleteCnt>0){
            achievementsDto1.setResult("success");
        }
        else{
            achievementsDto1.setResult("fail");
        }
        return achievementsDto1;
    }

}
