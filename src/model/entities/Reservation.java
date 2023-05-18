package model.entities;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

public class Reservation {
	private int roomNumber;
	private Date checkIn;
	private Date checkOut;
	
	public Reservation(int roomNumber, Date checkIn, Date checkOut) {
		this.roomNumber = roomNumber;
		this.checkIn = checkIn;
		this.checkOut = checkOut;
	}

	public int getRoomNumber() {
		return roomNumber;
	}

	public void setRoomNumber(int roomNumber) {
		this.roomNumber = roomNumber;
	}

	public Date getCheckIn() {
		return checkIn;
	}

	public Date getCheckOut() {
		return checkOut;
	}
	
	SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

	// Os set setCheckIn e setCheckOut foram apagados pois somente será permitido alterar estas datas via metodo
	
	// calcular diferença entre datas....interessante......
	// duas dicas, primeiro, calcular a diferença entre datas usando o metodo getTime() de Date atencao
	// o resultado de cada getTime() vem total em milisegundos, a diferença entre eles será também em 
	// milisegundo
	// 
	public long duration() {
		long dif = checkOut.getTime() - checkIn.getTime();
		// em dif tem a diferença de milisegundos mas pra converter em data tem que fazer
		return TimeUnit.DAYS.convert(dif, TimeUnit.MILLISECONDS);
	}
	// agora criar metodo para atualizar datas, apenas vai fazer o checkIn e checkOut do objeto 
	// receber as datas que vem como argumento
	
	public void updateDates(Date checkIn, Date checkOut) {
		this.checkIn = checkIn;
		this.checkOut = checkOut;
	}
	
	// vamos implementar o toString para mensagens de listar 
	@Override
	public String toString() {
		return "Room "
				+ roomNumber
				+ ", check-in: "
				+ sdf.format(checkIn)
				+ ", check-out: "
				+ sdf.format(checkOut)
				+ ", "
				+ duration()
				+ " nights";
	}
}