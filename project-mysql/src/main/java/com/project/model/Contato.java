package com.project.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name="contato")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Contato {

	@Id
	@GeneratedValue
	private int id;
	private String name;
	private String number;
	
}
