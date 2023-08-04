package co.micol.lms.member.service;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class MemberVO {
	private String memberId;
	private String memberPassword;
	private String memberName;
	private int memberAge;
	private String memberGender;
	private String memberTel;
	private String memberAddress;
}
