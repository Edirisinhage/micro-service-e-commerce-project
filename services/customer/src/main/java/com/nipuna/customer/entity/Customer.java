package com.nipuna.customer.entity;

import jakarta.validation.constraints.NotNull;
import lombok.*;
import org.bson.types.ObjectId;
import org.springframework.boot.autoconfigure.amqp.RabbitConnectionDetails;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.MongoId;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
@Document(collection = "customer")
public class Customer {

    @Id
    @Indexed(unique = true)
    private String id;

    @NotNull
    private String firstname;

    private String lastname;

    @Indexed(unique = true)
    private String email;

    private Address address;
}
