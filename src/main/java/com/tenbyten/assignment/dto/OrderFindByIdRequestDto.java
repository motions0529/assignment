package com.tenbyten.assignment.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.NotNull;

@Getter
@Setter
@NoArgsConstructor
public class OrderFindByIdRequestDto {
    @NotNull
    private Long memberid;
}
