package com.mariem.type.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class TypeDto {

    private Long idType;

    private String nomType;

    private String codeType;
}
