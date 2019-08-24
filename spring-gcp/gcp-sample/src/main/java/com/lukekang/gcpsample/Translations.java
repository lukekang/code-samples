package com.lukekang.gcpsample;


import lombok.Builder;
import lombok.Data;
import org.javatuples.Pair;

import java.util.Locale;
import java.util.Set;

@Data
@Builder
public class Translations {
    private String text;
    private Set<Pair<Locale, String>> transalatedTexts;
}
