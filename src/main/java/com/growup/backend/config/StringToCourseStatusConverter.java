package com.growup.backend.config;

import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import com.growup.backend.model.CourseStatus;

@Component
public class StringToCourseStatusConverter implements Converter<String, CourseStatus> {

    @Override
    public CourseStatus convert(String source) {
        return CourseStatus.fromValue(source);
    }

}
