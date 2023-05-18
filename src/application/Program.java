package application;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

import model.entities.Reservation;

public class Program {
	
	// versao muito ruim....vai guardar em github

	public static void main(String[] args) throws ParseException {
		Scanner sc = new Scanner(System.in);
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		
		System.out.print("Room Number: ");
		int number = sc.nextInt();
		System.out.print("Check-in date (dd/MM/yyyy): ");
		Date checkIn = sdf.parse(sc.next());
		
		System.out.print("Check-out date (dd/MM/yyyy): ");
		Date checkOut = sdf.parse(sc.next());

		// aqui poderia instanciar Reservation mas tem regras para valer uma reserva:
		// a data checkOut tem que ser maior que checkIn
		
		if(!checkOut.after(checkIn)) {
			System.out.println("Error in reservation: check-out date must be after check-in date");
		}
		else {
			Reservation reservation = new Reservation(number, checkIn, checkOut);
			System.out.println("Reservation: " + reservation);
			
			// atualizar reserva
			System.out.println();
			System.out.println("Enter data to update the reservation: ");
			
			// leitura das datas a serem atualizadas
			
			System.out.print("Check-in date (dd/MM/yyyy): ");
			checkIn = sdf.parse(sc.next());
			
			System.out.print("Check-out date (dd/MM/yyyy): ");
			checkOut = sdf.parse(sc.next());
			
			// antes de instanciar tem que garantir que as datas estao ok, as novas datas de reserva
			// nao podem ser do passado
			// cria uma variavel now contendo a data do dia
			reservation.updateDates(checkIn, checkOut);
			// aqui trata o retorno do metodo updateDates, se null ok, senao erros a listar
			String error = reservation.updateDates(checkIn, checkOut);
			if (error != null) {
				System.out.println("Error in reservation: " + error);
			}
			else {
				System.out.println("Reservation: " + reservation);			
			}

		}
		
		
		
		
		sc.close();
	}

}