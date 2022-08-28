package com.to21.torun.vo;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class webVo {
	
	private String board_seq; //글번호
	private String board_title; //글제목
	private String board_content;//글
	private String board_views;//조회수
	private String board_init_date;//작성시간
	private String board_update_date;//업데이트시간
	private String writer;//작성자
	
	
	public String getWriter() {
		return writer;
	}
	public void setWriter(String writer) {
		this.writer = writer;
	}
	public String getBoard_seq() {
		return board_seq;
	}
	public void setBoard_seq(String board_seq) {
		this.board_seq = board_seq;
	}
	public String getBoard_title() {
		return board_title;
	}
	public void setBoard_title(String board_title) {
		this.board_title = board_title;
	}
	public String getBoard_content() {
		return board_content;
	}
	public void setBoard_content(String board_content) {
		this.board_content = board_content;
	}
	public String getBoard_views() {
		return board_views;
	}
	public void setBoard_views(String board_views) {
		this.board_views = board_views;
	}
	public String getBoard_init_date() {
		return board_init_date;
	}
	public void setBoard_init_date(String board_init_date) {
		this.board_init_date = board_init_date;
	}
	public String getBoard_update_date() {
		return board_update_date;
	}
	public void setBoard_update_date(String board_update_date) {
		this.board_update_date = board_update_date;
	}

}
