package com.bookStore.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table(name ="Film")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Film {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	private String name;
	private String author;
	private String price;
	private String image;
	private String category; // Nouvel attribut pour la catégorie
	private String description;


}
