package co.micol.example.ajax.service;

import java.util.Date;

import lombok.Data;

@Data
public class TodoVO {
	private int todoNumber;
	private String todo;
	private Date dueDate;
	private String complete;
}
