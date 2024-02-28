package com.demo.payload;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PostDto {
    private long id;
    @NotNull
    @Size(min = 5,message = "character should be min 5 only")
    private String title;
    @NotNull
    @Size(min = 5,message = "character should be min 5 only")
    private String description;
    @NotNull
    @Size(min = 5,message = "character should be min 5 only")
    private String content;
}
