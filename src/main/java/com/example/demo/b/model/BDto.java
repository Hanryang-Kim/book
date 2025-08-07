package com.example.demo.b.model;

import com.example.demo.a.model.A;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

public class BDto {
    @Getter
    @NoArgsConstructor
    @Setter
    public static class Register {
        private String b01;
        private String b02;

        public B toEntity(A a) {
            B entity = B.builder()
                    .b01(b01)
                    .b02(b02)
                    .a(a)
                    .build();
            return entity;
        }
    }
    @Getter
    @Builder
    public static class BRes {
        private Integer idx;
        private String a01;
        private String a02;

        public static BRes from(B entity) {
            BRes dto  = BRes.builder()
                    .idx(entity.getIdx())
                    .a01(entity.getB01())
                    .a02(entity.getB02())
                    .build();

            return dto;
        }
    }
}
