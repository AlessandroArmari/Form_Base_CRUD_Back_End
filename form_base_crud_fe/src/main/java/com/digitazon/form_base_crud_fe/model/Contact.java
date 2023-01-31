package com.digitazon.form_base_crud_fe.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AccessLevel;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Data // --->Lombok: I got @ToString, @Getter / @Setter, @EqualsAndHashCode,
      // @RequiredArgsConstructor
@NoArgsConstructor // ---> empty constructor
public class Contact {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Setter(AccessLevel.NONE)
    private Long id;

    @Column
    private String username;

    @Column
    private String email;

    /*
     * BECAUSE I HAVE @Data--->Lombok already provides us with an emoty constructor
     * public Contact(){
     * 
     * }
     */

    // Even tough I have Lombok installed, I need this constructor (without id)
    public Contact(String username, String email) {
        this.username = username;
        this.email = email;
    }

}
