/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package it.tss.ex.ereditarieta;

import java.util.Arrays;

/**
 *
 * @author ospite
 */
public class CheckParamsHelper {

    private CheckParamsHelper() {
    }

    public static boolean isNotValuedString(String value) {
        return value == null || value.isBlank();
    }

    public static boolean isAnyNotValuedString(String... values) {
        return Arrays.stream(values).anyMatch(CheckParamsHelper::isNotValuedString);
    }

    public static boolean isNotPositiveValued(Double value) {
        return value <= 0;
    }

}
