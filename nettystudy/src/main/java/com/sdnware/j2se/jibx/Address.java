package com.sdnware.j2se.jibx;

public class Address {
	 /** First line of street information (required). */
    private String m_street1;
    
    /** Second line of street information (optional). */
    private String m_street2;
    
    private String m_city;
    
    /** State abbreviation (required for the U.S. and Canada, optional otherwise). */
    private String m_state;
    
    /** Postal code (required for the U.S. and Canada, optional otherwise). */
    private String m_postCode;
    
    /** Country name (optional, U.S. assumed if not supplied). */
    private String m_country;

    public String getStreet1() {
        return m_street1;
    }

    public void setStreet1(String street1) {
        this.m_street1 = street1;
    }

	public String getM_street1() {
		return m_street1;
	}

	public void setM_street1(String m_street1) {
		this.m_street1 = m_street1;
	}

	public String getM_street2() {
		return m_street2;
	}

	public void setM_street2(String m_street2) {
		this.m_street2 = m_street2;
	}

	public String getM_city() {
		return m_city;
	}

	public void setM_city(String m_city) {
		this.m_city = m_city;
	}

	public String getM_state() {
		return m_state;
	}

	public void setM_state(String m_state) {
		this.m_state = m_state;
	}

	public String getM_postCode() {
		return m_postCode;
	}

	public void setM_postCode(String m_postCode) {
		this.m_postCode = m_postCode;
	}

	public String getM_country() {
		return m_country;
	}

	public void setM_country(String m_country) {
		this.m_country = m_country;
	}
}
