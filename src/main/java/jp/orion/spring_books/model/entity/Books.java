package jp.orion.spring_books.model.entity;

import org.hibernate.validator.constraints.Length;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.Digits;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;

@Entity
public class Books {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	@Column(name = "nome")
	@NotBlank
	@NotEmpty
	@Length(max = 255)
	private String name;

	@Column(name = "autor")
	@NotBlank
	@NotEmpty
	@Length(max = 255)
	private String author;

	@Column(name = "ano_de_lançamento")
	@Digits(integer = Integer.MAX_VALUE, fraction = 0)
	private int yearRelease;

	public Books() {
	}

	public Books(String name, String author, int yearRelease) {

		this.name = name;
		this.author = author;
		this.yearRelease = yearRelease;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public int getYearRelease() {
		return yearRelease;
	}

	public void setYearRelease(int yearRelease) {
		this.yearRelease = yearRelease;
	}
}
