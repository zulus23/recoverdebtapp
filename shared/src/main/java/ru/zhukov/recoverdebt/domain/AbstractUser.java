package ru.zhukov.recoverdebt.domain;

import lombok.Data;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;


public abstract class AbstractUser {

     private Long id;
     private String name;
     private TypeUser typeUser;


     public AbstractUser(String username) {
          this.name = username;
     }

     public AbstractUser(Long id, String name, TypeUser typeUser) {
          this.id = id;
          this.name = name;
          this.typeUser = typeUser;
     }

     public Long getId() {
          return id;
     }

     public String getName() {
          return name;
     }

     public TypeUser getTypeUser() {
          return typeUser;
     }
}
