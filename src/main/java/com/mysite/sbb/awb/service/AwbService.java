package com.mysite.sbb.awb.service;

import com.mysite.sbb.awb.domain.Awb;
import com.mysite.sbb.awb.dto.AwbRequestDto;
import com.mysite.sbb.awb.repository.AwbRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Slf4j
public class AwbService {
    private final AwbRepository awbRepository;
//    private final SccRepository sccRepository;

    public Awb create(AwbRequestDto request) {

        Awb saveAwb = Awb.builder()
                .barcode(request.getBarcode())
                .separateNumber(request.getSeparateNumber())
                .waterVolume(request.getWaterVolume())
                .squareVolume(request.getSquareVolume())
                .width(request.getWidth())
                .length(request.getLength())
                .depth(request.getDepth())
                .weight(request.getWeight())
                //.sccList()
                .build();
        this.awbRepository.save(saveAwb);

        return saveAwb;
    }

}
