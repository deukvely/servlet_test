package co.micol.lms.board.service;

import java.sql.Date;

import lombok.Getter;
import lombok.Setter;
@Setter
@Getter
public class BoardVO {
	private int boardId;
	private String boardWriter;
	private String boardTitle;
	private String boardSubject;
	private Date boardDate;
	private int boardHit;
}
