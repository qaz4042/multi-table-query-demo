package com.example.mybatisplusmultitabledemo.model;


import com.lzb.mpmt.service.multiwrapper.annotations.MultiTableId;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

@AllArgsConstructor
@NoArgsConstructor
@SuperBuilder
@Data
public class Address {
    @MultiTableId
    private Integer code;
    private String name;
}
