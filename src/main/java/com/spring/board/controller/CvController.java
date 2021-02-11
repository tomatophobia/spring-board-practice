package com.spring.board.controller;

import com.spring.board.dto.AchievementsDto;
import com.spring.board.dto.BoardDto;
import com.spring.board.dto.EducationDto;
import com.spring.board.dto.UserDto;
import com.spring.board.service.CvService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.List;

@Controller
@RequestMapping(value = "/cv")
public class CvController {

    @Autowired
    private CvService cvService;

    @RequestMapping(value = "/cvpage")
    public ModelAndView cvpage(HttpServletRequest request, HttpServletResponse response) {
        ModelAndView modelAndView=new ModelAndView();
        modelAndView.setViewName("cv/cvpage");
        UserDto userDto=cvService.getUser();
        modelAndView.addObject("userDto",userDto);
        List<AchievementsDto> achievementsDtoList = cvService.getAchievements();
        modelAndView.addObject("AchievementsList",achievementsDtoList);
        return modelAndView;
    }

    @RequestMapping(value="/registerName")
    @ResponseBody
    public UserDto registerUser(HttpServletRequest request, HttpServletResponse response,UserDto userDto){
        UserDto userDto1=cvService.registerUser(userDto);

        return userDto1;
    }

    @RequestMapping(value="/deleteName")
    @ResponseBody
    public UserDto deleteUser(HttpServletRequest request, HttpServletResponse response,UserDto userDto){
        UserDto userDto1=cvService.deleteUser(userDto);

        return userDto1;
    }

    @RequestMapping(value = "/education")
    @ResponseBody
    public HashMap<String, Object> getEducation(HttpServletRequest request, HttpServletResponse response, EducationDto educationDto) {
        List<EducationDto> educationDto1 = cvService.getEducation(educationDto);
        HashMap<String, Object> resultMap = new HashMap<String, Object>();
        resultMap.put("list", educationDto1);
        return resultMap;
    }

    @RequestMapping(value = "/educationWrite")
    public String educationWrite(HttpServletRequest request, HttpServletResponse response) {
        return "cv/educationWrite";
    }

    @RequestMapping(value="/insertEducation")
    @ResponseBody
    public EducationDto insertEducation(HttpServletRequest request, HttpServletResponse response, EducationDto educationDto){
        EducationDto educationDto1=cvService.insertEducation(educationDto);

        return educationDto1;
    }

    @RequestMapping(value="/deleteEducation")
    @ResponseBody
    public EducationDto deleteEducation(HttpServletRequest request, HttpServletResponse response, EducationDto educationDto){
        EducationDto educationDto1=cvService.deleteEducation(educationDto);

        return educationDto1;
    }

    @RequestMapping(value="/insertAchievements")
    @ResponseBody
    public AchievementsDto insertAchievements(HttpServletRequest request, HttpServletResponse response, AchievementsDto achievementsDto){
        AchievementsDto achievementsDto1=cvService.insertAchievements(achievementsDto);

        return achievementsDto1;
    }

    @RequestMapping(value="/deleteAchievements")
    @ResponseBody
    public AchievementsDto deleteAchievements(HttpServletRequest request, HttpServletResponse response, AchievementsDto achievementsDto){
        AchievementsDto achievementsDto1=cvService.deleteAchievements(achievementsDto);

        return achievementsDto1;
    }


}
