package com.mysite.sbb.basic.service.dto.response;

import com.mysite.sbb.basic.entity.Basic;
import com.mysite.sbb.common.entity.BaseTimeResponse;
import lombok.Builder;
import lombok.Getter;
import lombok.experimental.SuperBuilder;
import lombok.extern.log4j.Log4j2;

import java.util.List;
import java.util.stream.Collectors;

@Log4j2
@Getter
public class BasicResponse {

    @Getter
    public static class BasicSearchResponse {
        private final List<BasicGetResponse> basics;
        private final Boolean hasNext;
        private final Long cursorId;

        @Builder
        private BasicSearchResponse(
                List<BasicGetResponse> basics,
                Boolean hasNext,
                Long cursorId
        ) {
            this.basics = basics;
            this.hasNext = hasNext;
            this.cursorId = cursorId;
        }

        public static BasicSearchResponse of(List<BasicGetResponse> basics, Boolean hasNext, Long nextCursorId) {
            return BasicSearchResponse.builder()
                    .basics(basics)
                    .hasNext(hasNext)
                    .cursorId(nextCursorId)
                    .build();
        }
    }

    @Getter
    @SuperBuilder
    public static class BasicGetResponse extends BaseTimeResponse {
        private final Long id;
        private final String code;

        public static BasicGetResponse of(Basic basic) {
            log.info("basic info: {}", basic.getCreatedAt());
            return BasicGetResponse.builder()
                    .id(basic.getId())
                    .code(basic.getCode())
                    .createdAt(basic.getCreatedAt())
                    .updatedAt(basic.getUpdatedAt())
                    .deletedAt(basic.getDeletedAt())
                    .build();
        }

        // List<Basic>를 받아 List<BasicGetResponse>를 반환하는 of 메소드
        public static List<BasicGetResponse> ofList(List<Basic> basics) {
            return basics.stream().map(basic -> {
                log.info("basic info: {}", basic.getCreatedAt());
                return BasicGetResponse.builder()
                        .id(basic.getId())
                        .code(basic.getCode())
                        .createdAt(basic.getCreatedAt())
                        .updatedAt(basic.getUpdatedAt())
                        .deletedAt(basic.getDeletedAt())
                        .build();
            }).collect(Collectors.toList());
        }
    }
}