package application;
import java.io.Serializable;


public class Sales implements Serializable {
	private int deposit;
    private int change;
	private int pump_number;
	private int number_gallons;
    private int sales_id;
    
    
    public int getdeposit() {
        return deposit;
    }
    public void setdeposit(int deposit) {
        this.deposit = deposit;
    }
    public int getchange() {
        return change;
    }
    public void setchange(int change) {
        this.change = change;
    }
    public int getpump_number() {
        return pump_number;
    }
    public void setpump_number(int pump_number) {
        this.pump_number = pump_number;
    }
    public int getnumber_gallons() {
        return number_gallons;
    }
    public void setnumber_gallons(int number_gallons) {
        this.number_gallons = number_gallons;
    }
    public int getsales_id() {
        return sales_id;
    }
    public void setsales_id(int sales_id) {
        this.sales_id = sales_id;
    }
    
    
}