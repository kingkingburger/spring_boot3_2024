package com.mysite.sbb.basic.service.dto.response;

import com.mysite.sbb.basic.entity.Basic;
import lombok.Builder;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

import java.util.List;

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
    public static class BasicGetResponse {
        private final Long id;
        private final String code;

        @Builder
        private BasicGetResponse(Long id, String code) {
            this.id = id;
            this.code = code;
        }

        public static BasicGetResponse of(Basic basic){
            return BasicGetResponse.builder()
                    .id(basic.getId())
                    .code(basic.getCode())
                    .build();
        }
    }
}
