package ru.gb;

/**
 * Напишите программу, позволяющую анализировать посещаемость студентов.
 * Используйте паттерн MVP.
 * Есть группа студентов.
 * Для каждого студента есть журнал его посещаемости:
 * список дат занятий и для каждой даты — посетил студент занятие или нет.
 * Создайте класс AttendanceService (сервис посещаемости),
 * в котором хранится информация обо всех студентах.
 * Создайте класс AttendanceView, который позволяет отображать студентов и их посещаемость.
 * Создайте класс presenter со следующими функциями:
 * • Распечатать всех студентов и посещаемость каждого в процентах
 * • Распечатать студентов, отсортировав их по убыванию посещаемости (вверху самые посещающие)
 * • Распечатать студентов с посещаемостью ниже 25%
 * Проверьте, как это работает.
 */

import java.time.LocalDate;

public class App 
{
    public static void main( String[] args )
    {
        AttendanceService attendanceService = new AttendanceService();

        attendanceService.addLogAttendance("Иванов", LocalDate.of(2023, 1, 16), true);
        attendanceService.addLogAttendance("Иванов", LocalDate.of(2023, 1, 17), true);
        attendanceService.addLogAttendance("Иванов", LocalDate.of(2023, 1, 18), true);
        attendanceService.addLogAttendance("Иванов", LocalDate.of(2023, 1, 19), true);
        attendanceService.addLogAttendance("Иванов", LocalDate.of(2023, 1, 20), true);

        attendanceService.addLogAttendance("Петров", LocalDate.of(2023, 1, 16), true);
        attendanceService.addLogAttendance("Петров", LocalDate.of(2023, 1, 17), false);
        attendanceService.addLogAttendance("Петров", LocalDate.of(2023, 1, 18), true);
        attendanceService.addLogAttendance("Петров", LocalDate.of(2023, 1, 19), true);
        attendanceService.addLogAttendance("Петров", LocalDate.of(2023, 1, 20), true);

        attendanceService.addLogAttendance("Сидоров", LocalDate.of(2023, 1, 16), true);
        attendanceService.addLogAttendance("Сидоров", LocalDate.of(2023, 1, 17), false);
        attendanceService.addLogAttendance("Сидоров", LocalDate.of(2023, 1, 18), false);
        attendanceService.addLogAttendance("Сидоров", LocalDate.of(2023, 1, 19), true);
        attendanceService.addLogAttendance("Сидоров", LocalDate.of(2023, 1, 20), true);

        attendanceService.addLogAttendance("Иванова", LocalDate.of(2023, 1, 16), true);
        attendanceService.addLogAttendance("Иванова", LocalDate.of(2023, 1, 17), true);
        attendanceService.addLogAttendance("Иванова", LocalDate.of(2023, 1, 18), false);
        attendanceService.addLogAttendance("Иванова", LocalDate.of(2023, 1, 19), false);
        attendanceService.addLogAttendance("Иванова", LocalDate.of(2023, 1, 20), false);

        attendanceService.addLogAttendance("Петрова", LocalDate.of(2023, 1, 16), true);
        attendanceService.addLogAttendance("Петрова", LocalDate.of(2023, 1, 17), false);
        attendanceService.addLogAttendance("Петрова", LocalDate.of(2023, 1, 18), false);
        attendanceService.addLogAttendance("Петрова", LocalDate.of(2023, 1, 19), false);
        attendanceService.addLogAttendance("Петрова", LocalDate.of(2023, 1, 20), false);

        attendanceService.addLogAttendance("Сидорова", LocalDate.of(2023, 1, 16), true);
        attendanceService.addLogAttendance("Сидорова", LocalDate.of(2023, 1, 17), false);
        attendanceService.addLogAttendance("Сидорова", LocalDate.of(2023, 1, 18), true);
        attendanceService.addLogAttendance("Сидорова", LocalDate.of(2023, 1, 19), false);
        attendanceService.addLogAttendance("Сидорова", LocalDate.of(2023, 1, 20), true);

        AttendanceView attendanceView = new AttendanceView(attendanceService);

        AttendancePresenter attendancePresenter = new AttendancePresenter(attendanceService, attendanceView);

        System.out.println("Журнал посещаемости студентов: ");
        attendancePresenter.printAllAttendance();

        System.out.println("Текущая посещаемость студентов: ");
        attendancePresenter.printCurrentAttendance();
        
        System.out.println("Журнал посещаемости студентов с сортировкой: ");
        attendancePresenter.printSortedAttendance();

        System.out.println("Журнал посещаемости студентов менее 25%: ");
        attendancePresenter.printLowAttendance();
    }
}
