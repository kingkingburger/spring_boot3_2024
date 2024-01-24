package com.mysite.sbb.awb.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.*;

import java.util.List;

@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Builder
@AllArgsConstructor
@Data
public class AwbRequestDto {

    @NotBlank
////    @Schema(example = "1830104")
    private String barcode;

    @NotBlank
//    @Schema(example = "0")
    private int separateNumber;

//    @Schema(example = "1.2")
    private int waterVolume;

//    @Schema(example = "1.4")
    private int squareVolume;

//    @Schema(example = "7")
    private int width;

//    @Schema(example = "16")
    private int length;

//    @Schema(example = "20")
    private int depth;

//    @Schema(example = "13")
    private int weight;

//    @Schema(example = "[\"GEN\",\"QTR\"]")
    private List<String> sccList;
}
