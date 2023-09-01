package co.micol.example.notice.service;


import java.util.Date;

import lombok.Data;

@Data
public class ReplyVO {
	public int replyId;
	public int noticeId;
	public String reply;
	public String replyer;
	public Date replyDate;
	
	@Override
	public String toString() {
		return "ReplyVO [replyId=" + replyId + ", noticeId=" + noticeId + ", reply=" + reply + ", replyer=" + replyer
				+ ", replyDate=" + replyDate + "]";
	}
}
