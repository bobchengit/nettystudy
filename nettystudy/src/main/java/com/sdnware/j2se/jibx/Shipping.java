package com.sdnware.j2se.jibx;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Shipping
{
    private static final List values = new ArrayList();
    
    public static final Shipping STANDARD_MAIL = new Shipping("STANDARD_MAIL");
    public static final Shipping PRIORITY_MAIL = new Shipping("PRIORITY_MAIL");
    public static final Shipping INTERNATIONAL_MAIL = new Shipping("INTERNATIONAL_MAIL");
    public static final Shipping DOMESTIC_EXPRESS = new Shipping("DOMESTIC_EXPRESS");
    public static final Shipping INTERNATIONAL_EXPRESS = new Shipping("INTERNATIONAL_EXPRESS");
    
    private String text;
    
    private Shipping(String text) {
        this.text = text;
        values.add(this);
    }
    
    public static Shipping fromString(String text) {
        for (Iterator iter = values.iterator(); iter.hasNext();) {
            Shipping value = (Shipping)iter.next();
            if (value.text.equals(text)) {
                return value;
            }
        }
        throw new IllegalArgumentException("'" + text + " is not a legal value");
    }
    
    public String toString() {
        return text;
    }
}
