package dev.temez.demo.service.user.model;

import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;
import org.jetbrains.annotations.NotNull;

@Getter
@Setter
@Entity
@Table(name = "users")
@AllArgsConstructor
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@FieldDefaults(level = AccessLevel.PRIVATE)
@SuppressWarnings("JpaDataSourceORMInspection")
public class User {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  long id;

  @NotNull
  @Column(updatable = false, nullable = false, unique = true)
  String username;

}
