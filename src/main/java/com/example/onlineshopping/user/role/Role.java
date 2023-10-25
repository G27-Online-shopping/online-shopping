package com.example.onlineshopping.user.role;

import com.example.onlineshopping.user.entity.User;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.UUID;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
public class Role {
    @Id
    private UUID id;
    private String code;
    @ManyToMany(mappedBy = "roles")
    private List<User> users;
}
