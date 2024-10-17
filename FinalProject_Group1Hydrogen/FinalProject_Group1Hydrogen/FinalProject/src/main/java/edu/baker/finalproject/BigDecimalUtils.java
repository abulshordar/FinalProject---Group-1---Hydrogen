/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package edu.baker.finalproject;

import java.math.BigDecimal;
import java.math.MathContext;
import java.math.RoundingMode;

/**
 *
 * @author Noah Wood, ???
 */
class BigDecimalUtils {
    static final BigDecimal recip(BigDecimal x, MathContext mc) 
    {
        // Convert the BigDecimal to double
        double xDouble = x.doubleValue();

        // Perform the reciprocal operation (1 / x)
        double resultDouble = 1.0 / xDouble;

        // Convert the result back to BigDecimal with the specified MathContext
        return new BigDecimal(resultDouble, mc);
    }

    static final BigDecimal floor(BigDecimal x, MathContext mc) 
    {
        // Convert BigDecimal to double
        double xDouble = x.doubleValue();
        
        // Use Math.floor to compute the floor value of the double
        double result = Math.floor(xDouble);
        
        // Convert result back to BigDecimal with specified precision
        return new BigDecimal(result, mc);
    }

    static final BigDecimal ceil(BigDecimal x, MathContext mc) 
    {
        // Convert BigDecimal to double
        double xDouble = x.doubleValue();
        
        // Use Math.ceil to compute the ceiling value of the double
        double result = Math.ceil(xDouble);
        
        // Convert result back to BigDecimal with specified precision
        return new BigDecimal(result, mc);
    }

    static final BigDecimal round(BigDecimal x, MathContext mc) {
        // Convert BigDecimal to double
        double xDouble = x.doubleValue();

        // Round the double value using Math.round and convert back to BigDecimal
        BigDecimal result = new BigDecimal(Math.round(xDouble), mc);

        // Return the result with the specified precision
        return result.setScale(mc.getPrecision(), mc.getRoundingMode());
    }

    static final BigDecimal trunc(BigDecimal x, MathContext mc) 
    {
        // Convert BigDecimal to double
        double xDouble = x.doubleValue();

        // Use Math.floor for positive numbers and Math.ceil for negative numbers
        double result = xDouble >= 0 ? Math.floor(xDouble) : Math.ceil(xDouble);

        // Convert result back to BigDecimal with specified precision
        return new BigDecimal(result, mc);
    }

    /**
     * Computes nth power using BigDecimal arithmetic.
     * 
     * @param base The base
     * @param power The exponent
     * @param mc The MathContext for precision control
     * @return base^power as a BigDecimal
     * @author Noah Wood
     */
     static final BigDecimal ipow(BigDecimal base, BigDecimal power, MathContext mc)
    {
        return new BigDecimal(Math.pow(base.doubleValue(), power.round(mc).intValue()), mc);
    }

    /**
     * Computes nth power using BigDecimal arithmetic.
     * 
     * @param base The base
     * @param ipower The exponent
     * @param mc The MathContext for precision control
     * @return base^power as a BigDecimal
     * @author Noah Wood
     */
    static final BigDecimal ipow(BigDecimal base, long ipower, MathContext mc)
    {
        return new BigDecimal(Math.pow(base.doubleValue(), (int)ipower), mc);
    }

    /**
     * Computes nth (integer) root using BigDecimal arithmetic.
     * 
     * @param base The base
     * @param power The root
     * @param mc The MathContext for precision control
     * @return base^(1/root) as a BigDecimal
     * @author Noah Wood
     */
    static final BigDecimal iroot(BigDecimal base, BigDecimal root, MathContext mc)
    {
        if(root.equals(BigDecimal.ONE))
            return base;
        if(root.equals(BigDecimal.ZERO))
            return BigDecimal.ONE;
        Double x = base.abs().doubleValue();
        Double y = 1 / (double)root.round(mc).intValue();
        // Handle negative values
        BigDecimal out = new BigDecimal(Math.pow(x,y),mc);
        if(base.signum() < 0){
            if(y%2!=0){
                out = out.negate(mc);
            }
        }
        return out;
    }

    /**
     * Computes nth (integer) root using BigDecimal arithmetic.
     * 
     * @param base The base
     * @param power The root
     * @param mc The MathContext for precision control
     * @return base^(1/root) as a BigDecimal
     * @author Noah Wood
     */
    static final BigDecimal iroot(BigDecimal base, long iroot, MathContext mc)
    {
        if(iroot == 1)
            return base;
        if(iroot == 0)
            return BigDecimal.ONE;
        Double x = base.abs().doubleValue();
        Double y = 1 / (double)iroot;
        // Handle negative values
        BigDecimal out = new BigDecimal(Math.pow(x,y),mc);
        if(base.signum() < 0){
            if(y%2!=0){
                out = out.negate(mc);
            }
        }
        return out;
    }

    /**
     * Computes nth power using BigDecimal arithmetic.
     * 
     * @param base The base
     * @param power The exponent
     * @param mc The MathContext for precision control
     * @return base^power as a BigDecimal
     * @author Noah Wood
     */
    static final BigDecimal pow(BigDecimal base, BigDecimal power, MathContext mc)
    {
        return new BigDecimal(Math.pow(base.doubleValue(), power.doubleValue()), mc);
    }

    /**
     * Computes e^x using BigDecimal arithmetic.
     * 
     * @param x The exponent
     * @param mc The MathContext for precision control
     * @return e^x as a BigDecimal
     * @author Noah Wood // Uh.... I don't actually remember doing this?
     */
    static final BigDecimal exp(BigDecimal x, MathContext mc)
    {
        // Convert BigDecimal to double
        double xDouble = x.doubleValue();
        
        // Compute e^x using Math.exp
        double result = Math.exp(xDouble);
        
        // Convert result back to BigDecimal with specified precision
        return new BigDecimal(result, mc);
    }

    /**
     * Computes 10^x using BigDecimal arithmetic.
     * 
     * @param x The exponent
     * @param mc The MathContext for precision control
     * @return 10^x as a BigDecimal
     * @author Noah Wood
     */
    static final BigDecimal exp10(BigDecimal x, MathContext mc) 
    {
        // Convert BigDecimal to double
        double xDouble = x.doubleValue();

        // Compute 10^x using Math.pow
        double result = Math.pow(10, xDouble);
        
        // Convert result back to BigDecimal with specified precision
        return new BigDecimal(result, mc);
    }

    static final BigDecimal log(BigDecimal x, MathContext mc)
    {
        return BigDecimal.ZERO; // STUB ONLY
    }

    static final BigDecimal exp10(BigDecimal x, MathContext mc)
    {
        return BigDecimal.ZERO; // STUB ONLY
    }

    static final BigDecimal log10(BigDecimal x, MathContext mc)
    {
        return BigDecimal.ZERO; // STUB ONLY
    }

    static final BigDecimal cos(BigDecimal x, MathContext mc)
    {
        return BigDecimal.ZERO; // STUB ONLY
    }

    static final BigDecimal sin(BigDecimal x, MathContext mc)
    {
        return BigDecimal.ZERO; // STUB ONLY
    }

    static final BigDecimal tan(BigDecimal x, MathContext mc)
    {
        return BigDecimal.ZERO; // STUB ONLY
    }

    static final BigDecimal asin(BigDecimal x, MathContext mc)
    {
        return BigDecimal.ZERO; // STUB ONLY
    }

    static final BigDecimal acos(BigDecimal x, MathContext mc)
    {
        return BigDecimal.ZERO; // STUB ONLY
    }

    static final BigDecimal atan(BigDecimal x, MathContext mc)
    {
        return BigDecimal.ZERO; // STUB ONLY
    }

    static final BigDecimal atan2(BigDecimal y, BigDecimal x, MathContext mc)
    {
        return BigDecimal.ZERO; // STUB ONLY
    }

    static final BigDecimal e(MathContext mc)
    {
        return BigDecimal.ZERO; // STUB ONLY
    }

    static final BigDecimal pi(MathContext mc)
    {
        return BigDecimal.ZERO; // STUB ONLY
    }

    static final BigDecimal factorial(BigDecimal x, MathContext mc)
    {
        return BigDecimal.ZERO; // STUB ONLY
    }
}
