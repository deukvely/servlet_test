package co.micol.execsample.board.service;

import java.time.LocalDate;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class BoardVO {
	private int boardNumber;
	private String boardWriter;
	private String boardTitle;
	private String boardSubject;
	private LocalDate boardDate;
	private int boardHit;
	private String boardAttech;
	private String boardAttechDiv;
}
