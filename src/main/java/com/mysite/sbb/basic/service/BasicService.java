package com.mysite.sbb.basic.service;

import com.mysite.sbb.basic.repository.BasicRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;

@Service
@Log4j2
@RequiredArgsConstructor
public class BasicService {


    private final BasicRepository basicRepository;



}
