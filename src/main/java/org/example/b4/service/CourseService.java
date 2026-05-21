package org.example.b4.service;

import org.example.b4.exception.ResourceNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class CourseService {
    public String getCourseById(Long id){
        throw new ResourceNotFoundException("Khong tim thay khoa hoc theo id: " + id);
    }


}
