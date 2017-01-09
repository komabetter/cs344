package model;

import java.io.Serializable;


import javax.persistence.*;

import org.hibernate.annotations.ForeignKey;


@Entity
@Table(name = "orderdetail")
public class orderdetail implements Serializable {

	@Id
	@ManyToOne()
	@ForeignKey(name = "FK_order_id")
	@JoinColumn(name = "order_id", referencedColumnName = "order_id", nullable = false)
	private order order;

	@Id
	@ManyToOne()
	@ForeignKey(name = "FK_product_id")
	@JoinColumn(name = "product_id", referencedColumnName = "product_id", nullable = false)
	private product product;

	@Id
	@ManyToOne()
	@ForeignKey(name = "FK_customer_id")
	@JoinColumn(name = "customer_id", referencedColumnName = "customer_id", nullable = false)
	private customers customer;

	@Column(name = "statusCustomer")
	private String statusCustomer;

	public String getStatusCustomer() {
		return statusCustomer;
	}

	public void setStatusCustomer(String statusCustomer) {
		this.statusCustomer = statusCustomer;
	}

	public order getOrder() {
		return order;
	}

	public void setOrder(order order) {
		this.order = order;
	}

	public product getProduct() {
		return product;
	}

	public void setProduct(product product) {
		this.product = product;
	}

	public customers getCustomer() {
		return customer;
	}

	public void setCustomer(customers customer) {
		this.customer = customer;
	}

}