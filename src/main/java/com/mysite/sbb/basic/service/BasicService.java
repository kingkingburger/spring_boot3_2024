package com.mysite.sbb.basic.service;

import com.mysite.sbb.basic.dto.request.BasicRegisterRequest;
import com.mysite.sbb.basic.entity.Basic;
import com.mysite.sbb.basic.repository.BasicRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Log4j2
@RequiredArgsConstructor
public class BasicService {


    private final BasicRepository basicRepository;


    public void registerBasic(BasicRegisterRequest basicRegisterRequest) {
        Basic basic = Basic.of(basicRegisterRequest);
        basicRepository.save(basic);
    }

    public List<Basic> getAllBasic() {
        return basicRepository.findAll();
    }

}
