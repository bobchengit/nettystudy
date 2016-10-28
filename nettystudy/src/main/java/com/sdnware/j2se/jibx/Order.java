package com.sdnware.j2se.jibx;

import java.util.Date;
import java.util.List;

public class Order {

	
private long m_orderNumber;
    
    private Customer m_customer;
    
    /** Billing address information. */
    private Address m_billTo;
    
    private Shipping m_shipping;
    
    /** Shipping address information. If missing, the billing address is also used as the
     shipping address. */
    private Address m_shipTo;
    
    private List m_items;
    
    /** Date order was placed with server. */
    private Date m_orderDate;
    
    public long getM_orderNumber() {
		return m_orderNumber;
	}

	public void setM_orderNumber(long m_orderNumber) {
		this.m_orderNumber = m_orderNumber;
	}

	public Customer getM_customer() {
		return m_customer;
	}

	public void setM_customer(Customer m_customer) {
		this.m_customer = m_customer;
	}

	public Address getM_billTo() {
		return m_billTo;
	}

	public void setM_billTo(Address m_billTo) {
		this.m_billTo = m_billTo;
	}

	public Shipping getM_shipping() {
		return m_shipping;
	}

	public void setM_shipping(Shipping m_shipping) {
		this.m_shipping = m_shipping;
	}

	public Address getM_shipTo() {
		return m_shipTo;
	}

	public void setM_shipTo(Address m_shipTo) {
		this.m_shipTo = m_shipTo;
	}

	public List getM_items() {
		return m_items;
	}

	public void setM_items(List m_items) {
		this.m_items = m_items;
	}

	public Date getM_orderDate() {
		return m_orderDate;
	}

	public void setM_orderDate(Date m_orderDate) {
		this.m_orderDate = m_orderDate;
	}

	public Date getM_shipDate() {
		return m_shipDate;
	}

	public void setM_shipDate(Date m_shipDate) {
		this.m_shipDate = m_shipDate;
	}

	public Float getTotal() {
		return total;
	}

	public void setTotal(Float total) {
		this.total = total;
	}

	/** Date order was shipped. This will be <code>null</code> if the order has not
     yet shipped. */
    private Date m_shipDate;
    
    private Float total;

    public long getOrderNumber() {
        return m_orderNumber;
    }

    public void setOrderNumber(long orderId) {
        this.m_orderNumber = orderId;
    }
	
}
