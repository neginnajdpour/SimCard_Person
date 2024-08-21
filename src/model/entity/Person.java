package model.entity;

import com.google.gson.Gson;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@SuperBuilder

public class Person {
    private int id;
    private String name;
    private String family;
    private List<Simcard> simcardlist;

    @Override
    public String toString() {
        return new Gson().toJson(this);
    }

}
