package com.uca.capas.Tarea2Clase.controllers;

import java.time.DayOfWeek;
import java.time.LocalDate;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class MainController {
	@RequestMapping(value="/alumno",
					produces="text/plain")
	public @ResponseBody String mostrarAlumno() {
		return "Nombre: Juan Pablo" + "\n" +
			   "Apellido: Acosta" + "\n" +
			   "Carnet: 00128917" + "\n" +
			   "Carrera: Ingenieria Informatica" + "\n" +
			   "Año: Cuarto";
	}
	
	@RequestMapping(value="/fecha")
	public @ResponseBody String mostrarDia(HttpServletRequest request) {
		Integer dia = Integer.parseInt(request.getParameter("dia"));
		Integer mes = Integer.parseInt(request.getParameter("mes"));
		Integer anio = Integer.parseInt(request.getParameter("anio"));
		String fecha = dia.toString() + "/" + mes.toString() + "/" + anio.toString() + " sera/fue un dia ";
		
		DayOfWeek dayOfWeek = LocalDate.of(anio, mes, dia).getDayOfWeek();
		
		switch(dayOfWeek.getValue()) {
			case 1:
				return fecha.concat("Lunes");
			case 2:
				return fecha.concat("Martes");
			case 3:
				return fecha.concat("Miercoles");
			case 4:
				return fecha.concat("Jueves");
			case 5:
				return fecha.concat("Viernes");
			case 6:
				return fecha.concat("Sabado");
			case 7:
				return fecha.concat("Domingo");
			default:
				return "No se pudo calcular el dia de la semana para la fecha ingresada";
		}
	}
}
