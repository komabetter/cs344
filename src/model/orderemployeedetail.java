package model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.*;

import org.hibernate.annotations.ForeignKey;

@Entity
@Table(name = "orderemployeedetail")
public class orderemployeedetail implements Serializable {

	@Id
	@OneToOne()
	@ForeignKey(name = "FK_order_ids")
	@JoinColumn(name = "order_id", referencedColumnName = "order_id", nullable = false)
	private order order;

	@Id
	@ManyToOne()
	@ForeignKey(name = "FK_employee_id_send")
	@JoinColumn(name = "employee_send", referencedColumnName = "employee_id", nullable = false)
	private employee employee_send;

	@Id
	@ManyToOne()
	@ForeignKey(name = "FK_customer_id_resive")
	@JoinColumn(name = "employee_resive", referencedColumnName = "employee_id", nullable = false)
	private employee employee_resive;

	public order getOrder() {
		return order;
	}

	public void setOrder(order order) {
		this.order = order;
	}

	public employee getEmployee_send() {
		return employee_send;
	}

	public void setEmployee_send(employee employee_send) {
		this.employee_send = employee_send;
	}

	public employee getEmployee_resive() {
		return employee_resive;
	}

	public void setEmployee_resive(employee employee_resive) {
		this.employee_resive = employee_resive;
	}

}