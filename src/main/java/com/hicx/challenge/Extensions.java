package com.hicx.challenge;

import lombok.Data;

import java.util.HashSet;
import java.util.Set;

@Data
public class Extensions {

    private Set<String> fileExtensions;

    public Extensions() {
        fileExtensions = new HashSet<>();
        fileExtensions.add(Constants.TXT.value);
    }


}
