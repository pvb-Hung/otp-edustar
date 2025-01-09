package com.example.ttcn2etest.service.classUser;

import com.example.ttcn2etest.exception.MyCustomException;
import com.example.ttcn2etest.model.dto.ClassUserDto;
import com.example.ttcn2etest.model.etity.ClassUser;
import com.example.ttcn2etest.repository.classUser.ClassUserRepository;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class ClassUserServiceImpl implements ClassUserService{
    private final ModelMapper modelMapper;
    private final ClassUserRepository classUserRepository;

    public ClassUserServiceImpl(ModelMapper modelMapper, ClassUserRepository classUserRepository) {
        this.modelMapper = modelMapper;
        this.classUserRepository = classUserRepository;
    }

    @Override
    public List<ClassUserDto> getAllClassUser() {
        return classUserRepository.findAll().stream().map(classUser -> {
            try {
                return modelMapper.map(classUser, ClassUserDto.class);
            } catch (Exception e) {
                System.out.println("Lỗi ánh xạ: " + e.getMessage());
                throw e;
            }
        }).toList();
    }

    @Override
    public ClassUserDto getClassById(String id) {
        Optional<ClassUser> classUser = classUserRepository.findAllClassByClassId(id);
        if (classUser.isPresent()) {
            return modelMapper.map(classUser.get(), ClassUserDto.class);
        }else{
            throw new MyCustomException("ID của dịch vụ không tồn tại");
        }
    }

    @Override
    public List<ClassUserDto> getClassesByUserId(Long userId) {
        List<ClassUser> classUsers = classUserRepository.findByIdUser(userId);
        return classUsers.stream()
                .map(classUser -> modelMapper.map(classUser, ClassUserDto.class))
                .collect(Collectors.toList());
    }

    @Override
    public ClassUserDto createClassUser(ClassUserDto clasUserDto) {
        ClassUser classUser = modelMapper.map(clasUserDto, ClassUser.class);
        classUser = classUserRepository.save(classUser);
        return modelMapper.map(classUser,ClassUserDto.class);
    }

    @Override
    public ClassUserDto updateClassUser(Long id, ClassUserDto classUserDto) {

        // Tìm kiếm bản ghi trong database
        Optional<ClassUser> existingClassUser = classUserRepository.findById(id);
        if (existingClassUser.isEmpty()) {
            throw new MyCustomException("ClassUser with id " + id + " not found");
        }

        // Cập nhật thông tin
        ClassUser classUser = existingClassUser.get();
        classUser.setClassId(classUserDto.getClassId());
        classUser.setIdUser(classUserDto.getIdUser());

        // Lưu lại bản ghi đã cập nhật
        ClassUser updatedClassUser = classUserRepository.save(classUser);

        // Trả về DTO
        return modelMapper.map(updatedClassUser, ClassUserDto.class);

    }


    @Override
    public void deleteClassUser(Long id) {
        if (!classUserRepository.existsById(id)){
            throw new RuntimeException("Class user not found with id: " + id);
        }
        classUserRepository.deleteById(id);
    }
}
