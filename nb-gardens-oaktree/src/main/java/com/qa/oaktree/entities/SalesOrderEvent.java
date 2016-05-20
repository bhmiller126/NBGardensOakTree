package pojo;

import javax.print.attribute.DateTimeSyntax;

@Entity
@Table (name = "Sales_Order_Event")
public class SalesOrderEvent {
	@Id
	@Column (name = "sales_event_id" )
	@GeneratedValue (strategy = GenerationType.IDENTITY)
	public int salesEventId; 
	
	@ManytoOne
	@JoinColumn (name = "Sales_Order_sales_id", nullable = false)
	@NotNull
	private int salesOrderId; 
	
	@Column (name = "time_stamp", nullable = false)
	@NotNull
	private DateTimeSyntax timeStamp; 
	
	@Column (name = "description", nullable = true, length = 225)
	@Null
	@Size (min = 1, max =225)
	private String description; 
	
	@Column (name = "type", nullable = false, length = 20)
	@NotNull
	@Size (min = 1, max = 20)
	private String type; 
	
	public SalesOrderEvent (int salesEventId, int salesOrderId, DateTimeSyntax timeStamp, String description, String type) {
		this.salesEventId = salesEventId; 
		this.salesOrderId = salesOrderId; 
		this.timeStamp = timeStamp; 
		this.description = description; 
		this.type = type; 
		
	}

	public int getSalesEventId() {
		return salesEventId;
	}

	public void setSalesEventId(int salesEventId) {
		this.salesEventId = salesEventId;
	}

	public int getSalesOrderId() {
		return salesOrderId;
	}

	public void setSalesOrderId(int salesOrderId) {
		this.salesOrderId = salesOrderId;
	}

	public DateTimeSyntax getTimeStamp() {
		return timeStamp;
	}

	public void setTimeStamp(DateTimeSyntax timeStamp) {
		this.timeStamp = timeStamp;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

}
