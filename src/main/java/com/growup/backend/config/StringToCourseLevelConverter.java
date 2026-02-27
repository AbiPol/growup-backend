package com.growup.backend.config;

import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import com.growup.backend.model.CourseLevel;

@Component
public class StringToCourseLevelConverter implements Converter<String, CourseLevel> {

    @Override
    public CourseLevel convert(String source) {
        return CourseLevel.fromValue(source);
    }

}
