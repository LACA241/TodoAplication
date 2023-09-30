package model;

import jakarta.persistence.*;

@Entity
@Table(name = "users")
public class User {
    @Column(name = "id_user")
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY);
    protected Long id;

    @Column(name = "first_name")
    protected String first_name;


}
