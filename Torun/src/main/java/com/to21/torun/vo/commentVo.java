package com.to21.torun.vo;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class commentVo {
	
	private String board_seq; //게시판 글번호
	private String comment_seq; //댓글 글번호
	private String parent_comment_seq; //상위댓글
	private String content; //댓글
	private String writer; //작성자
	private String init_date; //생성일시
	private String update_date; //수정일시
	private String delete_date; //삭제일시
	
	public String getBoard_seq() {
		return board_seq;
	}
	public void setBoard_seq(String board_seq) {
		this.board_seq = board_seq;
	}
	public String getComment_seq() {
		return comment_seq;
	}
	public void setComment_seq(String comment_seq) {
		this.comment_seq = comment_seq;
	}
	public String getParent_comment_seq() {
		return parent_comment_seq;
	}
	public void setParent_comment_seq(String parent_comment_seq) {
		this.parent_comment_seq = parent_comment_seq;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public String getWriter() {
		return writer;
	}
	public void setWriter(String writer) {
		this.writer = writer;
	}
	public String getInit_date() {
		return init_date;
	}
	public void setInit_date(String init_date) {
		this.init_date = init_date;
	}
	public String getUpdate_date() {
		return update_date;
	}
	public void setUpdate_date(String update_date) {
		this.update_date = update_date;
	}
	public String getDelete_date() {
		return delete_date;
	}
	public void setDelete_date(String delete_date) {
		this.delete_date = delete_date;
	}
	
}
