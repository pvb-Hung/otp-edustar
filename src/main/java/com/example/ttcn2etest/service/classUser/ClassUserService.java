package com.example.ttcn2etest.service.classUser;

import com.example.ttcn2etest.model.dto.ClassUserDto;

import java.util.List;

public interface ClassUserService {
    List<ClassUserDto> getAllClassUser();
    ClassUserDto getClassById(String id);
    List<ClassUserDto> getClassesByUserId(Long userId);
    ClassUserDto createClassUser(ClassUserDto clasUserDto);
    ClassUserDto updateClassUser(Long id, ClassUserDto clasUserDto);
    void deleteClassUser(Long id);
}
