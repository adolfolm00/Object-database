package BBDD;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Pedido {
	
	private int codigo;
	private String idCliente;
	private float total;
	private Date fecha;
	private String direccionEntrega;
	private static int codigonext=1;
	
	
	
	
	public Pedido(String idCliente, float total, Date fecha, String direccionEntrega) {
		super();
		
		this.idCliente = idCliente;
		this.total = total;
		this.fecha = fecha;
		this.direccionEntrega = direccionEntrega;
		codigo=codigonext++;
		
	}
	
	public Pedido(int codigo,String idCliente, float total, Date fecha, String direccionEntrega) {
		super();
		this.codigo=codigo;
		this.idCliente = idCliente;
		this.total = total;
		this.fecha = fecha;
		this.direccionEntrega = direccionEntrega;
		
		
	}
	public int getCodigo() {
		return codigo;
	}
	public String getIdCliente() {
		return idCliente;
	}
	public float getTotal() {
		return total;
	}
	public Date getFecha() {
		return fecha;
	}
	public String getDireccionEntrega() {
		return direccionEntrega;
	}
	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}
	public void setIdCliente(String idCliente) {
		this.idCliente = idCliente;
	}
	public void setTotal(float total) {
		this.total = total;
	}
	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}
	
	public void setDireccionEntrega(String direccionEntrega) {
		this.direccionEntrega = direccionEntrega;
	}
	public void setIdCliente(Cliente c) {
		this.idCliente=c.getNif();
	}
	@Override
	public String toString() {
		SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyy");
		return "Pedido \nCódigo: " + codigo + "\nidCliente: " + idCliente + "\nTotal: " + total + "\nFecha:" + formatter.format(fecha)
				+ "\nDirección de entrega: " + direccionEntrega;
	}
	
	
	
	

}
