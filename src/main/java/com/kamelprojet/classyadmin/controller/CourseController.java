package com.kamelprojet.classyadmin.controller;

import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Tag(name = "Course Controller", description = "Endpoints for course management (Get all and specific courses, Delete course, Update course)")
@RestController
@RequestMapping("/course")
@AllArgsConstructor
public class CourseController {
}
