package ru.specialist;

import java.util.ArrayList;
import java.util.List;

// master
public class Invoice {
	private String contragent;
	private double total;
	
	private List<Line> lines = new ArrayList<Line>();
	
	public String getContragent() {
		return contragent;
	}
	
	public double getTotal() {
		return total;
	}

	public Invoice(String contragent) {
		this.contragent = contragent;
	}
	
	public Line add(String good, double price, int quantity) {
		Line l = new Line(good, price, quantity);
		lines.add(l);
		return l;
	}
	
	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append(String.format("%-32s%8.2f\n", 
				getContragent(), getTotal()));
		sb.append("----------------------------------------\n");
		for(Line line : lines)
			sb.append(line.toString()).append('\n');
		
		return sb.toString(); 
	}
	
	// detail
	public class Line
	{
		private String good;
		private double price;
		private int quantity;
		private double summa;
		
		private void updateSumma() {
			updateSumma(false);
		}
		
		
		private void updateSumma(boolean init) {
			if (!init)
				total -= summa;
			summa = price*quantity;
			//Invoice.this.total
			total += summa;
		}
		
		public String getGood() {
			return good;
		}
		public void setGood(String good) {
			this.good = good;
		}
		public double getPrice() {
			return price;
		}
		public void setPrice(double price) {
			this.price = price;
			updateSumma();
		}
		public int getQuantity() {
			return quantity;
		}
		public void setQuantity(int quantity) {
			this.quantity = quantity;
			updateSumma();
		}
		public double getSumma() {
			return summa;
		}

		private Line(String good, double price, int quantity) {
			this.good = good;
			this.price = price;
			this.quantity = quantity;
			updateSumma(true);
		}
		
		@Override
		public String toString() {
			return String.format("%-20s %-6.2f %4d %7.2f",
				getGood(), getPrice(), getQuantity(), getSumma());
		}
	}
}
