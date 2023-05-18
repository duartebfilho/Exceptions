package application;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

import model.entities.Reservation;
import model.exceptions.DomainException;

public class Program {
	
	// versao muito ruim....vai guardar em github

	public static void main(String[] args) {
	Scanner sc = new Scanner(System.in);
	SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
	
	try {
	System.out.print("Room Number: ");
	int number = sc.nextInt();
	System.out.print("Check-in date (dd/MM/yyyy): ");
	Date checkIn = sdf.parse(sc.next());
	
	System.out.print("Check-out date (dd/MM/yyyy): ");
	Date checkOut = sdf.parse(sc.next());

	// aqui poderia instanciar Reservation mas tem regras para valer uma reserva:
	// a data checkOut tem que ser maior que checkIn
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
	
	reservation.updateDates(checkIn, checkOut);
	System.out.println("Reservation: " + reservation);	
	
	}
	catch(ParseException e){
		System.out.println("Invalid Date Format");
	}
	catch(DomainException e) {
		System.out.println("Error in reservation: " + e.getMessage());
	}
	catch(RuntimeException e) {
		System.out.println("Unexpected error");
	}
	
	sc.close();
	}

}