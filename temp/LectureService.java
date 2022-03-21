package com.sejong.project.capstone.service;

import com.sejong.project.capstone.repository.LectureRepository;
import org.springframework.stereotype.Service;

@Service
public class LectureService {
    private final LectureRepository lectureRepository;

    public LectureService(LectureRepository lectureRepository){ this.lectureRepository = lectureRepository; }


}
