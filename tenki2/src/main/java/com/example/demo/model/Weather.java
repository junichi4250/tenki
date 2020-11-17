package com.example.demo.model;

/**
 * 天気エンティティクラス
 *
 * @author jun
 *
 */
@Entity
@Table(name = "Weather")
public class Weather {

	@Id
	@Column
	private String weatherDate;
}
