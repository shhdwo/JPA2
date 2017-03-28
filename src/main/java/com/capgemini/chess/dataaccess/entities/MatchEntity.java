package com.capgemini.chess.dataaccess.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

import com.capgemini.chess.enums.MatchWinner;

@NamedQuery(name="Match.findByUserId", query="SELECT m FROM MatchEntity m WHERE m.player1.id = :id OR m.player2.id = :id")
@Entity
@Table(name = "matches")
public class MatchEntity extends AbstractEntity {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long id;
	
	@ManyToOne(fetch=FetchType.LAZY)
	private UserEntity player1;
	
	@ManyToOne(fetch=FetchType.LAZY)
	private UserEntity player2;
	
	@Column(nullable=true)
	private int points1;
	
	@Column(nullable=true)
	private int points2;
	
	@Enumerated
	@Column(nullable=false)
	private MatchWinner result;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public UserEntity getPlayer1() {
		return player1;
	}

	public void setPlayer1(UserEntity player1) {
		this.player1 = player1;
	}

	public UserEntity getPlayer2() {
		return player2;
	}

	public void setPlayer2(UserEntity player2) {
		this.player2 = player2;
	}

	public int getPoints1() {
		return points1;
	}

	public void setPoints1(int points1) {
		this.points1 = points1;
	}

	public int getPoints2() {
		return points2;
	}

	public void setPoints2(int points2) {
		this.points2 = points2;
	}

	public MatchWinner getResult() {
		return result;
	}

	public void setResult(MatchWinner result) {
		this.result = result;
	}

}
