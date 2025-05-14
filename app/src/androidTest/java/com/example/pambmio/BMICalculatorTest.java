package com.example.pambmio;

import com.example.pambmio.utils.BMICalculator;

import org.junit.Test;
import static org.junit.Assert.*;

public class BMICalculatorTest {

    @Test
    public void testCalculateBMI() {
        float bmi = BMICalculator.calculateBMI(70, 175);
        assertEquals(22.86f, bmi, 0.01f);
    }

    @Test
    public void testInterpretBMI_Niedowaga() {
        String result = BMICalculator.interpretBMI(17.0f);
        assertEquals("Niedowaga", result);
    }

    @Test
    public void testInterpretBMI_Optimum() {
        String result = BMICalculator.interpretBMI(22.0f);
        assertEquals("Optimum", result);
    }

    @Test
    public void testInterpretBMI_Nadwaga() {
        String result = BMICalculator.interpretBMI(27.5f);
        assertEquals("Nadwaga", result);
    }

    @Test
    public void testInterpretBMI_Otyłość() {
        String result = BMICalculator.interpretBMI(31.0f);
        assertEquals("Otyłość", result);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testBMIThrowsForInvalidInput() {
        BMICalculator.calculateBMI(0, 170);
    }
}
