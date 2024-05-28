package com.bookStore.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="MyBooks")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class MyBookList {
	
	@Id
	private int id;
	private String name;
	private String author;
	private String price;
	private String image;
	private String category; // Nouvel attribut pour la catégorie
	private String description;

}
