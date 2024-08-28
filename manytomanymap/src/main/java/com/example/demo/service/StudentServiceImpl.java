package com.example.demo.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dto.LaptopDTO;
import com.example.demo.dto.StudentDTO;
import com.example.demo.entity.Laptop;
import com.example.demo.entity.Student;
import com.example.demo.repository.StudentRepository;

@Service
public class StudentServiceImpl implements StudentService {

	@Autowired
	private StudentRepository repo;

	@Override
	public StudentDTO save(StudentDTO dto) {
		Student student = new Student();
		BeanUtils.copyProperties(dto, student);
		List<LaptopDTO> laptopDTO = dto.getLaptop();
		List<Laptop> list = new ArrayList<>();
		laptopDTO.forEach(i -> {
			Laptop lap = new Laptop();
			BeanUtils.copyProperties(i, lap);
			list.add(lap);
		});
		student.setLaptops(list);
		 Student save=repo.save(student);
		BeanUtils.copyProperties(save, dto);
		return dto;
		
	}

	@Override
	public List<StudentDTO> get() {
		List<Student> findAll = repo.findAll();
		List<StudentDTO> list = new ArrayList<>();
		findAll.forEach(i -> {
			List<LaptopDTO> dtos = new ArrayList<>();
			StudentDTO studentDTO = new StudentDTO();
			BeanUtils.copyProperties(i, studentDTO);
			List<Laptop> laptop = i.getLaptops();
			laptop.forEach(l -> {
				LaptopDTO laptopDTO = new LaptopDTO();
				BeanUtils.copyProperties(l, laptopDTO);
				List<StudentDTO> list2=new ArrayList<>();
				List<Student> students = l.getStudents();
				students.forEach(stu->{
					StudentDTO studentDTO1=new StudentDTO();
					BeanUtils.copyProperties(stu, studentDTO1);
					list2.add(studentDTO1);
				});
				laptopDTO.setStudent(list2);
				dtos.add(laptopDTO);
			});
			studentDTO.setLaptop(dtos);
			list.add(studentDTO);
		});
		return list;
	}

	@Override
	public StudentDTO update(StudentDTO dto) throws Exception {
	Optional<Student> findByStudentId = repo.findById(dto.getStudentId());
	

		if (findByStudentId.isPresent()) {
			Student student = findByStudentId.get();
			System.err.println(student);
			BeanUtils.copyProperties(dto, student);
		
			
			List<LaptopDTO> listDTO = dto.getLaptop();
			List<Laptop> list1 = new ArrayList<>();
			listDTO.forEach(i -> {
				Laptop lap = new Laptop();
				BeanUtils.copyProperties(i, lap);
				list1.add(lap);
				student.setLaptops(list1);
			});

			Student save = repo.save(student);
			BeanUtils.copyProperties(save, dto);
			return dto;

		}
		throw new Exception("not found");

	}

	@Override
	public StudentDTO delete(Integer studentId) {
		repo.deleteById(studentId);
		return new StudentDTO();
	}

}
