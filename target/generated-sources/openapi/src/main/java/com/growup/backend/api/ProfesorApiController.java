package com.growup.backend.api;

import com.growup.backend.model.Activity;
import com.growup.backend.model.AnalyticsSummary;
import com.growup.backend.model.CourseItem;
import com.growup.backend.model.CoursePerformance;
import com.growup.backend.model.DashboardStats;
import com.growup.backend.model.RevenueData;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.multipart.MultipartFile;

import jakarta.validation.constraints.*;
import jakarta.validation.Valid;

import java.util.List;
import java.util.Map;
import java.util.Optional;
import jakarta.annotation.Generated;

@Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2026-02-20T10:35:35.234080800Z[Atlantic/Canary]")
@Controller
@RequestMapping("${openapi.aPIDeGrowUp.base-path:/api/v1}")
public class ProfesorApiController implements ProfesorApi {

    private final ProfesorApiDelegate delegate;

    public ProfesorApiController(@Autowired(required = false) ProfesorApiDelegate delegate) {
        this.delegate = Optional.ofNullable(delegate).orElse(new ProfesorApiDelegate() {});
    }

    @Override
    public ProfesorApiDelegate getDelegate() {
        return delegate;
    }

}
