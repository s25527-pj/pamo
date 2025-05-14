package com.example.pambmio.utils;

public class BMICalculator {
    public static float calculateBMI(float weightKg, float heightCm) {
        if (weightKg <= 0 || heightCm <= 0) {
            throw new IllegalArgumentException("Waga i wzrost muszą być większe niż 0");
        }
        float heightM = heightCm / 100;
        return weightKg / (heightM * heightM);
    }

    public static String interpretBMI(float bmi) {
        if (bmi < 18.5) return "Niedowaga";
        else if (bmi < 24.9) return "Optimum";
        else if (bmi < 29.9) return "Nadwaga";
        else return "Otyłość";
    }
}
